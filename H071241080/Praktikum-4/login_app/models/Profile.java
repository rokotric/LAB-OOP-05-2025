package login_app.models;

public class Profile {
    // todo 3
    private String fullName;
    private String nickName;
    private int age;
    private String hobby;

    // todo 4
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Nama lengkap: " + fullName +
               "\nNama panggilan: " + nickName +
               "\nUmur: " + age +
               "\nHobi: " + hobby;
    }
}