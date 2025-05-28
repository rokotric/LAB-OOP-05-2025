import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Group; 
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.scene.paint.Color; 
import javafx.stage.FileChooser;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.application.Application;
import javafx.scene.SnapshotParameters; 

import java.io.File;
import java.util.List;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Objects;

public class MyMomentApp extends Application {
    // ---------- DEKLARASI KOMPONEN UTAMA ---------- //
    private Stage primaryStage; // Window utama aplikasi
    private User currentUser; // Data user yang sedang aktif
    private List<Post> posts = new ArrayList<>(); // Penyimpanan semua postingan
    private FlowPane postsContainer; // Container untuk grid postingan
    private ScrollPane scrollPane; // Area scrollable untuk postsContainer

    private ImageView profileImageViewRegister = new ImageView();
    private File selectedProfileImageFile;
    // Konfigurasi tampilan gambar
    private static final double ASPECT_RATIO = 4.0 / 5.0; // Rasio lebar:tinggi postingan
    private double currentUploadRotation = 0;// Penyimpanan rotasi gambar saat upload

    // ---------- MAIN & START METHOD ---------- //
    public static void main(String[] args) {
        launch(args); // Entry point standar JavaFX
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("MyMoment");
        showRegisterScene(); // Tampilkan scene pertama
        primaryStage.show(); // Penting: menampilkan window
    }
    // ---------- METHOD UTILITY ---------- //
    private Image loadPlaceholderImage() {
        try { // Memuat gambar default dari resources
            InputStream stream = Objects.requireNonNull(getClass().getResourceAsStream("/placeholder.png"));
            if (stream != null) {
                return new Image(stream); // Return null jika gagal
            } else {
                System.err.println("Placeholder image not found!");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error loading placeholder image: " + e.getMessage());
            return null;
        }
    }
    // ---------- REGISTER SCENE ---------- //
    private void showRegisterScene() {
        VBox registerLayout = new VBox(20); // Layout vertikal
        registerLayout.setPadding(new Insets(50)); // Padding 50px di semua sisi
        registerLayout.setAlignment(Pos.CENTER);
        registerLayout.setId("register-layout"); 

        Label titleLabel = new Label("MyMoment");
        titleLabel.getStyleClass().add("header-label"); 

        TextField nickNameField = new TextField();
        nickNameField.setPromptText("Input User Account (Nick Name)");

        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");

        Button uploadProfileButton = new Button("Upload Foto Profil");
        profileImageViewRegister.setFitHeight(120); 
        profileImageViewRegister.setFitWidth(120); 
        profileImageViewRegister.setId("profile-image-view-register"); 
        // Clip lingkaran untuk foto profil
        Circle clip = new Circle(60, 60, 60); // (centerX, centerY, radius)
        profileImageViewRegister.setClip(clip); // Potong gambar jadi lingkaran
        profileImageViewRegister.setImage(loadPlaceholderImage());
        // Event handler untuk upload gambar
        uploadProfileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Foto Profil");
            fileChooser.getExtensionFilters().addAll( // Filter jenis file
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            // Buka dialog file dan update ImageView
            selectedProfileImageFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedProfileImageFile != null) {
                try {
                    Image image = new Image(new FileInputStream(selectedProfileImageFile));
                    profileImageViewRegister.setImage(image);
                } catch (FileNotFoundException ex) {
                    showAlert("Error", "File tidak ditemukan.");
                }
            }
        });
        // ---------- VALIDASI INPUT ---------- //
        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String nickName = nickNameField.getText().trim(); 
            String fullName = fullNameField.getText().trim(); 

            if (nickName.isEmpty() || fullName.isEmpty() || selectedProfileImageFile == null || profileImageViewRegister.getImage().isError()) {
                showAlert("Input Error", "Mohon isi semua field dan upload foto profil yang valid.");
                return; // Validasi dasar
            }

            try { // Jika valid, buat user dan masuk ke home
                Image profileImage = new Image(new FileInputStream(selectedProfileImageFile));
                currentUser = new User(nickName, fullName, profileImage); // pembuatan akun
                showHomeScene();
            } catch (FileNotFoundException ex) {
                showAlert("Error", "Gagal memuat foto profil.");
            }
        });

        registerLayout.getChildren().addAll(
                titleLabel,
                new Label("Nick Name"), 
                nickNameField,
                new Label("Full Name"), 
                fullNameField,
                uploadProfileButton,
                profileImageViewRegister,
                submitButton
        );

        Scene registerScene = new Scene(registerLayout, 550, 700); 
        String cssPath = getClass().getResource("/styles.css") != null ?
                         getClass().getResource("/styles.css").toExternalForm() : null;
        if (cssPath != null) {
            registerScene.getStylesheets().add(cssPath);
        } else {
            System.err.println("CSS file not found for register scene! Path: /styles.css");
        }
        primaryStage.setScene(registerScene);
        primaryStage.setTitle("Register - MyMoment");
    }
    // ---------- HOME SCENE ---------- //
    private void showHomeScene() {
        BorderPane homeLayout = new BorderPane();
        homeLayout.setId("home-layout"); 

        HBox topBar = new HBox(20);
        topBar.setId("top-bar"); 
        // ---------- TOP BAR ---------- //
        ImageView profileImageViewHome = new ImageView(currentUser.getProfileImage());
        profileImageViewHome.setFitHeight(180);
        profileImageViewHome.setFitWidth(180);
        profileImageViewHome.setId("profile-image-view-home"); 
        profileImageViewHome.setClip(new Circle(90, 90, 90)); // Clip lingkaran besar

        VBox userInfo = new VBox(5);
        Label nickNameLabel = new Label(currentUser.getNickName());
        nickNameLabel.setId("nick-name-label");

        Label fullNameLabel = new Label(currentUser.getFullName());
        fullNameLabel.setId("full-name-label");

        userInfo.getChildren().addAll(nickNameLabel, fullNameLabel);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button addPostButton = new Button("Add Post");
        addPostButton.setOnAction(e -> showUploadPostWindow());

        topBar.getChildren().addAll(profileImageViewHome, userInfo, spacer, addPostButton);
        homeLayout.setTop(topBar);
        // ---------- POSTS CONTAINER ---------- //
        postsContainer = new FlowPane(15, 15); // Grid dengan jarak 15px
        postsContainer.setId("posts-container");  

        scrollPane = new ScrollPane(postsContainer); // Enable scrolling
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.getStyleClass().add("scroll-pane"); 
        homeLayout.setCenter(scrollPane);

        // Listener untuk resize responsif
        scrollPane.widthProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.doubleValue() > 0) {
                postsContainer.setPrefWrapLength(newVal.doubleValue() - (postsContainer.getPadding().getLeft() + postsContainer.getPadding().getRight()));
                resizeImages(newVal.doubleValue()); // Panggil saat ukuran berubah
            }
        });
        updatePostsDisplay();

        Scene homeScene = new Scene(homeLayout, 700, 800); 
        String cssPath = getClass().getResource("/styles.css") != null ?
                         getClass().getResource("/styles.css").toExternalForm() : null;
        if (cssPath != null) {
            homeScene.getStylesheets().add(cssPath);
        } else {
            System.err.println("CSS file not found for home scene! Path: /styles.css");
        }
        primaryStage.setScene(homeScene);
        primaryStage.setTitle("Home - MyMoment");

        javafx.application.Platform.runLater(() -> {
            postsContainer.setPrefWrapLength(scrollPane.getWidth() - (postsContainer.getPadding().getLeft() + postsContainer.getPadding().getRight()));
            resizeImages(scrollPane.getWidth());
        });
    }
    // ---------- UPLOAD POST WINDOW ---------- //
    private void showUploadPostWindow() {
        currentUploadRotation = 0; 

        Stage uploadStage = new Stage();
        uploadStage.initModality(Modality.APPLICATION_MODAL);
        uploadStage.initOwner(primaryStage);
        uploadStage.setTitle("Upload Post");

        VBox uploadLayout = new VBox(15);
        uploadLayout.setId("upload-post-layout");
        uploadLayout.setAlignment(Pos.TOP_CENTER); 

        ImageView postImageView = new ImageView();
        postImageView.setFitHeight(200);
        postImageView.setFitWidth(200);
        postImageView.setPreserveRatio(true);
        Image placeholder = loadPlaceholderImage();
        if (placeholder != null) {
            postImageView.setImage(placeholder);
        } else {
            System.err.println("Failed to load placeholder for upload post window.");
        }
        postImageView.setId("upload-post-image-view");
        postImageView.setRotate(currentUploadRotation);

        StackPane imageWrapper = new StackPane(postImageView);
        imageWrapper.setPrefSize(200, 200);
        imageWrapper.setAlignment(Pos.CENTER);
        imageWrapper.setStyle("-fx-border-color: #DDDDDD; -fx-border-width: 1px; -fx-background-color: #ffffff; -fx-effect: dropshadow(gaussian, rgba(0,0,0,0.1), 5, 0, 0, 0);");


        final File[] selectedPostImageFile = {null};

        Button uploadImageButton = new Button("Upload Image");
        uploadImageButton.getStyleClass().add("button"); 
        uploadImageButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Gambar Postingan");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
            selectedPostImageFile[0] = fileChooser.showOpenDialog(uploadStage);
            if (selectedPostImageFile[0] != null) {
                try {
                    Image image = new Image(new FileInputStream(selectedPostImageFile[0]));
                    postImageView.setImage(image);
                    currentUploadRotation = 0; 
                    postImageView.setRotate(currentUploadRotation); 
                } catch (FileNotFoundException ex) {
                    showAlert("Error", "File tidak ditemukan.");
                }
            }
        });
        // ---------- ROTASI GAMBAR ---------- //
        Button rotateButton = new Button("Rotate");
        rotateButton.getStyleClass().add("button"); 
        rotateButton.setOnAction(e -> {
            currentUploadRotation = (currentUploadRotation + 90) % 360; // Rotasi 90°
            postImageView.setRotate(currentUploadRotation);
        });

        TextField captionField = new TextField();
        captionField.setPromptText("Caption");
        captionField.getStyleClass().add("text-field"); 

        Button submitPostButton = new Button("Submit");
        submitPostButton.getStyleClass().add("button"); 
        submitPostButton.setOnAction(e -> {
            String caption = captionField.getText().trim();
            if (selectedPostImageFile[0] == null) {
                showAlert("Input Error", "Mohon upload gambar postingan.");
                return;
            }

            try {
                Image originalImage = new Image(new FileInputStream(selectedPostImageFile[0]));
                Image imageToPost = originalImage;
                // ---------- SNAPSHOT ROTASI ---------- //
                if (currentUploadRotation != 0) {
                    ImageView tempView = new ImageView(originalImage);
                    tempView.setRotate(currentUploadRotation);

                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT);

                    Group tempGroup = new Group(tempView);
                    imageToPost = tempGroup.snapshot(params, null);
                }

                posts.add(new Post(caption, imageToPost)); // Pemanggilan class Post
                updatePostsDisplay();
                uploadStage.close();
            } catch (FileNotFoundException ex) {
                showAlert("Error", "Gagal memuat gambar postingan.");
            }
        });

        HBox uploadButtonBox = new HBox(uploadImageButton);
        uploadButtonBox.setAlignment(Pos.CENTER);
        uploadButtonBox.setPadding(new Insets(10, 0, 0, 0));

        HBox rotateButtonBox = new HBox(rotateButton);
        rotateButtonBox.setAlignment(Pos.CENTER);
        rotateButtonBox.setPadding(new Insets(10, 0, 0, 0));

        HBox captionFieldBox = new HBox(captionField);
        captionFieldBox.setAlignment(Pos.CENTER);
        captionFieldBox.setPadding(new Insets(10, 0, 0, 0));

        HBox submitButtonBox = new HBox(submitPostButton);
        submitButtonBox.setAlignment(Pos.CENTER);
        submitButtonBox.setPadding(new Insets(20, 0, 0, 0));

        uploadLayout.getChildren().addAll(
                uploadButtonBox,
                imageWrapper,
                rotateButtonBox,
                captionFieldBox,
                submitButtonBox
        );

        Scene uploadScene = new Scene(uploadLayout, 450, 600);
        String cssPath = getClass().getResource("/styles.css") != null ?
                         getClass().getResource("/styles.css").toExternalForm() : null;
        if (cssPath != null) {
            uploadScene.getStylesheets().add(cssPath);
        } else {
            System.err.println("CSS file not found for upload scene! Path: /resources/styles.css");
        }
        uploadStage.setScene(uploadScene);
        uploadStage.showAndWait();
    }
    // ---------- RESPONSIVE IMAGE RESIZING ---------- //
    private void resizeImages(double containerWidth) {
        if (postsContainer == null || containerWidth <= 0) return;

        double padding = postsContainer.getPadding().getLeft() + postsContainer.getPadding().getRight();
        double hgap = postsContainer.getHgap();
        double effectiveWidth = containerWidth - padding - 20;
        // Hitung ukuran berdasarkan lebar container dan jumlah kolom (3)
        int columns = 3;
        double newWidth = (effectiveWidth - (columns - 1) * hgap) / columns;

        if (newWidth <= 1) {
            newWidth = 10;
        }

        double newHeight = newWidth / ASPECT_RATIO; // Pertahankan rasio 4:5
        // Update semua gambar di container
        for (Node node : postsContainer.getChildren()) {
            if (node instanceof StackPane) {
                StackPane pane = (StackPane) node;
                ImageView imageView = (ImageView) pane.getChildren().get(0);
                Post post = (Post) pane.getUserData();
                Image image = post.getPostImage();

                pane.setPrefSize(newWidth, newHeight); // Ukuran tetap
                pane.setMinSize(newWidth, newHeight);
                pane.setMaxSize(newWidth, newHeight);
                pane.setClip(new Rectangle(newWidth, newHeight)); // Pencegah overflow

                double imgRatio = image.getWidth() / image.getHeight();
                double targetRatio = ASPECT_RATIO;

                if (imgRatio > targetRatio) {
                    imageView.setFitHeight(newHeight);
                    imageView.setFitWidth(0);
                } else {
                    imageView.setFitWidth(newWidth);
                    imageView.setFitHeight(0);
                }
            }
        }
    }
    // ---------- POST DETAILS WINDOW ---------- //
    private void updatePostsDisplay() {
        if (postsContainer == null) return;

        postsContainer.getChildren().clear();

        for (Post post : posts) {
            ImageView postView = new ImageView(post.getPostImage());
            postView.setPreserveRatio(true); 
            postView.getStyleClass().add("post-image-view"); 

            StackPane imageContainer = new StackPane(postView);
            imageContainer.setUserData(post);
            imageContainer.getStyleClass().add("post-image-container"); 

            Tooltip.install(imageContainer, new Tooltip(post.getCaption().isEmpty() ? "Lihat detail" : post.getCaption()));

            imageContainer.setOnMouseClicked(e -> showPostDetailsWindow(post));

            postsContainer.getChildren().add(imageContainer);
        }
        if (primaryStage.getScene() != null && primaryStage.getScene().getRoot() == scrollPane.getParent()) {
             javafx.application.Platform.runLater(() -> resizeImages(scrollPane.getWidth()));
        }
    }
    // ---------- POST DETAILS WINDOW ---------- //
    private void showPostDetailsWindow(Post post) {
        Stage detailStage = new Stage();
        detailStage.initModality(Modality.APPLICATION_MODAL);
        detailStage.initOwner(primaryStage);
        detailStage.setTitle("Detail Postingan");

        VBox detailLayout = new VBox(15);
        detailLayout.setId("detail-post-layout"); 
        // Tampilkan gambar besar dengan caption
        ImageView postImageView = new ImageView(post.getPostImage());
        postImageView.setPreserveRatio(true);
        postImageView.setFitWidth(550); // Ukuran tetap untuk detail
        postImageView.setFitHeight(550);
        postImageView.setId("detail-post-image-view"); 

        Label captionLabel = new Label(post.getCaption());  // Caption wrap text
        captionLabel.setWrapText(true);
        captionLabel.setMaxWidth(550);
        captionLabel.setAlignment(Pos.CENTER);
        captionLabel.setId("caption-label-detail"); 


        detailLayout.getChildren().addAll(postImageView, captionLabel);

        ScrollPane detailScrollPane = new ScrollPane(detailLayout);
        detailScrollPane.setFitToWidth(true);
        detailScrollPane.setFitToHeight(true);
        detailScrollPane.getStyleClass().add("scroll-pane"); 
        detailScrollPane.setStyle("-fx-border-color: transparent;"); 

        Scene detailScene = new Scene(detailScrollPane, 650, 750); 
        String cssPath = getClass().getResource("/styles.css") != null ?
                         getClass().getResource("/styles.css").toExternalForm() : null;
        if (cssPath != null) {
            detailScene.getStylesheets().add(cssPath);
        } else {
            System.err.println("CSS file not found for detail scene! Path: /resources/styles.css");
        }        detailStage.setScene(detailScene);
        detailStage.showAndWait();
    }
    // ---------- ALERT DIALOG ---------- //
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING); // Dialog warning
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait(); // Blocking operation
    }
}