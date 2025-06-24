package org.example;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException; // Ditambahkan
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene; // Ditambahkan
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip; // Ditambahkan
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MyMomentApp extends Application {

    private Stage primaryStage;
    private User currentUser;
    private List<Post> posts = new ArrayList<>();
    private FlowPane postsContainer;
    private ScrollPane scrollPane;

    private ImageView profileImageViewRegister = new ImageView();
    private File selectedProfileImageFile;

    //Rasio diubah menjadi 2:3 (Lebar : Tinggi)
    private static final double ASPECT_RATIO = 2.0 / 3.0;

    // Field untuk menyimpan status rotasi saat ini di window upload
    private double currentUploadRotation = 0;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("MyMoment");

        showRegisterScene();
        primaryStage.show();
    }

    private Image loadPlaceholderImage() {
        try {
            InputStream stream = getClass().getResourceAsStream("/placeholder.png");
            if (stream != null) {
                return new Image(stream);
            } else {
                System.err.println("Placeholder image not found!");
                return null;
            }
        } catch (Exception e) {
            System.err.println("Error loading placeholder image: " + e.getMessage());
            return null;
        }
    }

    //Register (Tidak ada perubahan)
    private void showRegisterScene() {
        VBox registerLayout = new VBox(20);
        registerLayout.setPadding(new Insets(50));
        registerLayout.setAlignment(Pos.CENTER);
        registerLayout.setStyle("-fx-background-color: #F5F5F5;");

        Label titleLabel = new Label("MyMoment");
        titleLabel.setFont(new Font("Arial", 24));

        TextField nickNameField = new TextField();
        nickNameField.setPromptText("Input User Account (Nick Name)");
        nickNameField.setMaxWidth(300);

        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");
        fullNameField.setMaxWidth(300);

        Button uploadProfileButton = new Button("Upload Foto Profil");
        profileImageViewRegister.setFitHeight(100);
        profileImageViewRegister.setFitWidth(100);
        Circle clip = new Circle(50, 50, 50);
        profileImageViewRegister.setClip(clip);
        profileImageViewRegister.setImage(loadPlaceholderImage());

        uploadProfileButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Pilih Foto Profil");
            fileChooser.getExtensionFilters().addAll(
                    new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif")
            );
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

        Button submitButton = new Button("Submit");
        submitButton.setOnAction(e -> {
            String nickName = nickNameField.getText();
            String fullName = fullNameField.getText();

            if (nickName.isEmpty() || fullName.isEmpty() || selectedProfileImageFile == null) {
                showAlert("Input Error", "Mohon isi semua field dan upload foto profil.");
                return;
            }

            try {
                Image profileImage = new Image(new FileInputStream(selectedProfileImageFile));
                currentUser = new User(nickName, fullName, profileImage);
                showHomeScene();
            } catch (FileNotFoundException ex) {
                showAlert("Error", "Gagal memuat foto profil.");
            }
        });

        registerLayout.getChildren().addAll(
                titleLabel,
                nickNameField,
                fullNameField,
                uploadProfileButton,
                profileImageViewRegister,
                submitButton
        );

        Scene registerScene = new Scene(registerLayout, 500, 600);
        primaryStage.setScene(registerScene);
        primaryStage.setTitle("Register - MyMoment");
    }

    //Home Screen (Tidak ada perubahan)
    private void showHomeScene() {
        BorderPane homeLayout = new BorderPane();
        homeLayout.setPadding(new Insets(20));
        homeLayout.setStyle("-fx-background-color: #FFFFFF;");

        HBox topBar = new HBox(20);
        topBar.setAlignment(Pos.CENTER_LEFT);
        topBar.setPadding(new Insets(10));

        ImageView profileImageViewHome = new ImageView(currentUser.getProfileImage());
        profileImageViewHome.setFitHeight(80);
        profileImageViewHome.setFitWidth(80);
        Circle clip = new Circle(40, 40, 40);
        profileImageViewHome.setClip(clip);

        VBox userInfo = new VBox(5);
        Label nickNameLabel = new Label(currentUser.getNickName());
        nickNameLabel.setStyle("-fx-font-weight: bold; -fx-font-size: 16px;");
        Label fullNameLabel = new Label(currentUser.getFullName());
        fullNameLabel.setStyle("-fx-font-size: 14px;");
        userInfo.getChildren().addAll(nickNameLabel, fullNameLabel);

        Region spacer = new Region();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        Button addPostButton = new Button("Add Post");
        addPostButton.setOnAction(e -> showUploadPostWindow());

        topBar.getChildren().addAll(profileImageViewHome, userInfo, spacer, addPostButton);
        homeLayout.setTop(topBar);

        postsContainer = new FlowPane(15, 15);
        postsContainer.setPadding(new Insets(20));
        postsContainer.setAlignment(Pos.TOP_LEFT);
        scrollPane = new ScrollPane(postsContainer);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent;");
        homeLayout.setCenter(scrollPane);

        scrollPane.widthProperty().addListener((obs, oldVal, newVal) -> resizeImages(newVal.doubleValue()));

        updatePostsDisplay();

        Scene homeScene = new Scene(homeLayout, 600, 700);
        primaryStage.setScene(homeScene);
        primaryStage.setTitle("Home - MyMoment");

        javafx.application.Platform.runLater(() -> resizeImages(scrollPane.getWidth()));
    }

    // --- Window Upload Post (DIMODIFIKASI) ---
    private void showUploadPostWindow() {
        currentUploadRotation = 0; // Reset rotasi setiap window dibuka

        Stage uploadStage = new Stage();
        uploadStage.initModality(Modality.APPLICATION_MODAL);
        uploadStage.initOwner(primaryStage);
        uploadStage.setTitle("Upload Post");

        VBox uploadLayout = new VBox(15);
        uploadLayout.setPadding(new Insets(30));
        uploadLayout.setAlignment(Pos.CENTER);
        uploadLayout.setStyle("-fx-background-color: #F0F0F0;");

        ImageView postImageView = new ImageView();
        postImageView.setFitHeight(200);
        postImageView.setFitWidth(200);
        postImageView.setPreserveRatio(true);
        postImageView.setImage(loadPlaceholderImage());
        postImageView.setStyle("-fx-border-color: #CCCCCC; -fx-border-width: 1px;");
        postImageView.setRotate(currentUploadRotation); // Atur rotasi awal

        final File[] selectedPostImageFile = {null};

        Button uploadImageButton = new Button("Upload Image");
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
                    currentUploadRotation = 0; // Reset rotasi saat gambar baru dipilih
                    postImageView.setRotate(currentUploadRotation); // Terapkan reset ke view
                } catch (FileNotFoundException ex) {
                    showAlert("Error", "File tidak ditemukan.");
                }
            }
        });

        //Tombol Rotate
        Button rotateButton = new Button("Rotate");
        rotateButton.setOnAction(e -> {
            currentUploadRotation = (currentUploadRotation + 90) % 360;
            postImageView.setRotate(currentUploadRotation);
        });

        TextField captionField = new TextField();
        captionField.setPromptText("Caption");
        captionField.setMaxWidth(300);

        Button submitPostButton = new Button("Submit");
        submitPostButton.setOnAction(e -> {
            String caption = captionField.getText();
            if (selectedPostImageFile[0] == null) {
                showAlert("Input Error", "Mohon upload gambar postingan.");
                return;
            }

            try {
                Image originalImage = new Image(new FileInputStream(selectedPostImageFile[0]));
                Image imageToPost = originalImage;

                //Jika ada rotasi, buat snapshot
                if (currentUploadRotation != 0) {
                    ImageView tempView = new ImageView(originalImage);
                    tempView.setRotate(currentUploadRotation);

                    SnapshotParameters params = new SnapshotParameters();
                    params.setFill(Color.TRANSPARENT); // Latar belakang transparan

                    // Gunakan Group untuk snapshot agar bounds lebih akurat
                    Group tempGroup = new Group(tempView);
                    imageToPost = tempGroup.snapshot(params, null);
                }

                posts.add(new Post(caption, imageToPost));
                updatePostsDisplay();
                uploadStage.close();
            } catch (FileNotFoundException ex) {
                showAlert("Error", "Gagal memuat gambar postingan.");
            }
        });

        //Tambahkan rotateButton ke layout
        uploadLayout.getChildren().addAll(uploadImageButton, postImageView, rotateButton, captionField, submitPostButton);

        Scene uploadScene = new Scene(uploadLayout, 400, 500); // Tinggikan scene sedikit
        uploadStage.setScene(uploadScene);
        uploadStage.showAndWait();
    }

    // --- Helper Methods ---

    // paksa 3 kolom dengan rasio 2:3 (Tidak ada perubahan)
    private void resizeImages(double containerWidth) {
        if (postsContainer == null || containerWidth <= 0) return;

        double padding = postsContainer.getPadding().getLeft() + postsContainer.getPadding().getRight();
        double hgap = postsContainer.getHgap();
        double effectiveWidth = containerWidth - padding - 20;

        int columns = 3;
        double newWidth = (effectiveWidth - (columns - 1) * hgap) / columns;

        if (newWidth <= 1) {
            newWidth = 10;
        }

        double newHeight = newWidth / ASPECT_RATIO;

        for (Node node : postsContainer.getChildren()) {
            if (node instanceof StackPane) {
                StackPane pane = (StackPane) node;
                ImageView imageView = (ImageView) pane.getChildren().get(0);
                Post post = (Post) pane.getUserData();
                Image image = post.getPostImage();

                pane.setPrefSize(newWidth, newHeight);
                pane.setMinSize(newWidth, newHeight);
                pane.setMaxSize(newWidth, newHeight);

                Rectangle clip = new Rectangle(newWidth, newHeight);
                pane.setClip(clip);

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

    //updatePostsDisplay (Tidak ada perubahan)
    private void updatePostsDisplay() {
    if (postsContainer == null) return;

    postsContainer.getChildren().clear();

    for (Post post : posts) {
        ImageView postView = new ImageView(post.getPostImage());
        postView.setPreserveRatio(true);

        StackPane imageContainer = new StackPane(postView);
        imageContainer.setUserData(post);
        
        // Base style for posts
        String baseStyle = "-fx-background-color: black; " +
                         "-fx-cursor: hand; " +
                         "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 0); " +
                         "-fx-transition: all 0.2s ease;";
        
        // Hover style
        String hoverStyle = "-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.5), 8, 0, 2, 2); " +
                          "-fx-scale-x: 1.03; " +
                          "-fx-scale-y: 1.03;";
        
        // Apply base style
        imageContainer.setStyle(baseStyle);

        // Add hover effects
        imageContainer.setOnMouseEntered(e -> {
            imageContainer.setStyle(baseStyle + hoverStyle);
        });
        
        imageContainer.setOnMouseExited(e -> {
            imageContainer.setStyle(baseStyle);
        });

        // Tooltip and click handler
        Tooltip.install(imageContainer, new Tooltip(
            post.getCaption().isEmpty() ? "Click to view details" : post.getCaption()
        ));

        imageContainer.setOnMouseClicked(e -> showPostDetailsWindow(post));
        postsContainer.getChildren().add(imageContainer);
    }
    
    // Refresh layout
    resizeImages(scrollPane.getWidth());
}

    //showPostDetailsWindow (Tidak ada perubahan)
    private void showPostDetailsWindow(Post post) {
        Stage detailStage = new Stage();
        detailStage.initModality(Modality.APPLICATION_MODAL);
        detailStage.initOwner(primaryStage);
        detailStage.setTitle("Detail Postingan");

        VBox detailLayout = new VBox(15);
        detailLayout.setPadding(new Insets(20));
        detailLayout.setAlignment(Pos.CENTER);
        detailLayout.setStyle("-fx-background-color: #FFFFFF;");

        ImageView postImageView = new ImageView(post.getPostImage());
        postImageView.setPreserveRatio(true);
        postImageView.setFitWidth(550);
        postImageView.setFitHeight(550);

        Label captionLabel = new Label(post.getCaption());
        captionLabel.setFont(new Font("Arial", 16));
        captionLabel.setWrapText(true);
        captionLabel.setMaxWidth(550);
        captionLabel.setAlignment(Pos.CENTER);
        captionLabel.setStyle("-fx-padding: 10px 0 0 0;");

        detailLayout.getChildren().addAll(postImageView, captionLabel);

        ScrollPane detailScrollPane = new ScrollPane(detailLayout);
        detailScrollPane.setFitToWidth(true);
        detailScrollPane.setFitToHeight(true);
        detailScrollPane.setStyle("-fx-background-color: transparent; -fx-background: transparent; -fx-border-color: transparent;");

        Scene detailScene = new Scene(detailScrollPane, 600, 700);
        detailStage.setScene(detailScene);
        detailStage.showAndWait();
    }

    //peringatan (Tidak ada perubahan)
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}