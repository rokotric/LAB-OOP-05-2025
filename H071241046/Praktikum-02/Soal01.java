public class Soal01 {
    String name;
    int age;
    boolean isMale;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIsMale( ) {
        if(isMale == true){
            return "male";
        } else{
            return "female";
        }
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;

    }

    public static void main(String[] args) {
        var someone = new Soal01();
        someone.setName("Furina");
        someone.setAge(20);
        someone.setIsMale(false);

        System.out.println(someone.getName());
        System.out.println(someone.getAge());
        System.out.println(someone.getIsMale());
    }
}
