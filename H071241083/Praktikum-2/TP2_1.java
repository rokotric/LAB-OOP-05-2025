class Person {
    String name;
    int age;
    boolean isMale;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void setAge(int age) {
        this.age = age;
    }

    int getAge() {
        return age;
    }

    void setGender(boolean isMale) {
        this.isMale = isMale;

    }

    String getGender() {
        return isMale ? "Laki-Laki" : "Perempuan";
    }
}

public class TP2_1 {

    public static void main(String[] args) {
        Person someone = new Person();

        someone.setName("Aril");
        someone.setAge(20);
        someone.setGender(true);

        System.out.println("================================");
        System.out.println("Nama   : " + someone.getName());
        System.out.println("Usia   : " + someone.getAge());
        System.out.println("Gender : " + someone.getGender());
        System.out.println("================================");
    }
    

}