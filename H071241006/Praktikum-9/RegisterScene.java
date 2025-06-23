package app.src.main.java.tp;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class RegisterScene {
    private Scene scene;
    private Image profileImage;

    public RegisterScene(Stage primaryStage) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        TextField nicknameField = new TextField();
        nicknameField.setPromptText("Nick Name");

        TextField fullNameField = new TextField();
        fullNameField.setPromptText("Full Name");

        ImageView profilePreview = new ImageView();
        profilePreview.setFitWidth(100);
        profilePreview.setFitHeight(100);
        profilePreview.setPreserveRatio(true);

        Button uploadBtn = new Button("Upload Foto Profil");
        uploadBtn.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                profileImage = new Image(file.toURI().toString());
                profilePreview.setImage(profileImage);
            }
        });

        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(e -> {
            User user = new User(nicknameField.getText(), fullNameField.getText(), profileImage);
            HomeScene homeScene = new HomeScene(primaryStage, user);
            primaryStage.setScene(homeScene.getScene());
        });

        root.getChildren().addAll(nicknameField, fullNameField, uploadBtn, profilePreview, submitBtn);
        scene = new Scene(root, 400, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
