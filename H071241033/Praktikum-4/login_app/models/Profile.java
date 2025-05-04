package login_app.models;

public class Profile {
    /*
     * TODO:
     * Tambahkan attribute, method, atau constructor
     * yang dibutuhkan di kelas user
     */
    String fullname;
    String nickName;
    int age;
    String hobby;

    public Profile() {
        
    }
    public void setFullName(String fullname) {
        this.fullname = fullname;
    }
    public String getFullName() {
        return this.fullname;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getNickName() {
        return this.nickName;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.age = age;
        }
    }
    public int getAge() {
        return this.age;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
    public String getHobby() {
        return this.hobby;
    }
}