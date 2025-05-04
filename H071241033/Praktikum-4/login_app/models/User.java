package login_app.models;

public class User {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */
    private String username;
    private String password;
    private Profile profile;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
    public Profile getProfile() {
        return this.profile;
    }

    public String getPassword() {
        return this.password;
    }
    public String getUsername() {
        return this.username;
    }
}