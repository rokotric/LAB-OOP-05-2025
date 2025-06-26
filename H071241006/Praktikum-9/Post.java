package app.src.main.java.tp;
import javafx.scene.image.Image;

public class Post {
    private String caption;
    private Image postImage;

    public Post(String caption, Image postImage) {
        this.caption = caption;
        this.postImage = postImage;
    }

    public String getCaption() { return caption; }
    public Image getPostImage() { return postImage; }
}
