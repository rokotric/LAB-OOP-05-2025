class Person {
    public String name;
    public int age;
    public boolean isMale;

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    public String getGender() {
        return isMale ? "Male" : "Female";
    }
}

public class TP2_1_H071241033 {
    public static void main(String[] args) {
        Person p = new Person();
        p.setName("Oline");
        p.setAge(17);
        p.setGender(false);

        System.out.println("Name: " + p.getName());
        System.out.println("Age: " + p.getAge());
        System.out.println("Gender: " + p.getGender());
    }
}