package app.src.main.java.tp;
import javafx.scene.image.Image;

public class User {
    private String nickName;
    private String fullName;
    private Image profileImage;

    public User(String nickName, String fullName, Image profileImage) {
        this.nickName = nickName;
        this.fullName = fullName;
        this.profileImage = profileImage;
    }

    public String getNickName() { return nickName; }
    public String getFullName() { return fullName; }
    public Image getProfileImage() { return profileImage; }
}
