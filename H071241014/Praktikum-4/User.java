package login_app;

public class User {
   private String userName;
   private String password;
   private Profile profile;
   
   public User(String userName, String password, Profile profile) {
        this.userName = userName;
        this.password = password;
        this.profile = profile;
   }

   public String getUserName() {
    return userName;
   }

   public String getPassword() {
    return password;
   }

   public Profile getProfile() {
    return profile;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setProfile(Profile profile) {
      this.profile = profile;
   }
   

}