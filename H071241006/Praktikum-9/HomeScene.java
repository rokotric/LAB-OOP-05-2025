package app.src.main.java.tp;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HomeScene {
    private Scene scene;
    private FlowPane postGallery;

    public HomeScene(Stage primaryStage, User user) {
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        HBox userInfo = new HBox(10);
        ImageView profile = new ImageView(user.getProfileImage());
        profile.setFitWidth(60);
        profile.setFitHeight(60);

        VBox textInfo = new VBox();
        Label nickname = new Label(user.getNickName());
        Label fullname = new Label(user.getFullName());
        textInfo.getChildren().addAll(nickname, fullname);

        Button addPostBtn = new Button("Add Post");
        addPostBtn.setOnAction(e -> new UploadPostWindow(postGallery));

        userInfo.getChildren().addAll(profile, textInfo, addPostBtn);

        postGallery = new FlowPane();
        postGallery.setHgap(10);
        postGallery.setVgap(10);
        postGallery.setPadding(new Insets(10));

        ScrollPane scrollPane = new ScrollPane(postGallery);
        scrollPane.setFitToWidth(true);

        root.getChildren().addAll(userInfo, scrollPane);
        scene = new Scene(root, 600, 500);
    }

    public Scene getScene() {
        return scene;
    }
}
