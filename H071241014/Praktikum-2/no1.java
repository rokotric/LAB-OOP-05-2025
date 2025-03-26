class Person {
    private String name;
    private int age;
    private boolean isMale;

    // Setter untuk name
    public void setName(String name) {
        this.name = name;
    }

    // Getter untuk name
    public String getName() {
        return name;
    }

    // Setter untuk age
    public void setAge(int age) {
        this.age = age;
    }

    // Getter untuk age
    public int getAge() {
        return age;
    }

    // Setter untuk gender
    public void setGender(boolean isMale) {
        this.isMale = isMale;
    }

    // Getter untuk gender dalam bentuk String
    public String getGender() {
        return isMale ? "Male" : "Female";
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("daffa");
        person.setAge(25);
        person.setGender(true);

        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Gender: " + person.getGender());
    }
}