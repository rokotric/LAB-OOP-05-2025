package login_app.models;

public class User {
    // todo 1
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() { // getter krn atribut ptivate
        return username;
    }

    // todo 2
    public boolean isPasswordMatch(String password) {
        return this.password.equals(password);
    }
}