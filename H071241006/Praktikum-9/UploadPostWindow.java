package app.src.main.java.tp;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.File;

public class UploadPostWindow {
    private Image postImage;

    public UploadPostWindow(FlowPane gallery) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Upload Post");

        VBox root = new VBox(10);
        root.setPadding(new javafx.geometry.Insets(20));

        ImageView preview = new ImageView();
        preview.setFitWidth(200);
        preview.setFitHeight(150);

        TextField captionField = new TextField();
        captionField.setPromptText("Caption");

        Button uploadImageBtn = new Button("Upload Image");
        uploadImageBtn.setOnAction(e -> {
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(window);
            if (file != null) {
                postImage = new Image(file.toURI().toString());
                preview.setImage(postImage);
            }
        });

        Button submit = new Button("Submit");
        submit.setOnAction(e -> {
            if (postImage != null) {
                Post post = new Post(captionField.getText(), postImage);
                ImageView postView = new ImageView(post.getPostImage());
                postView.setFitWidth(150);
                postView.setFitHeight(100);
                Tooltip tooltip = new Tooltip(post.getCaption());
                Tooltip.install(postView, tooltip);
                gallery.getChildren().add(postView);
                window.close();
            }
        });

        root.getChildren().addAll(uploadImageBtn, preview, captionField, submit);
        Scene scene = new Scene(root, 300, 400);
        window.setScene(scene);
        window.show();
    }
}
