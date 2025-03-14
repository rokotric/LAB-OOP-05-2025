class Person{
    String name;
    int age;
    boolean isMale;

    int getAge() {
        return age;
    }
    void setAge(int age) {
        this.age = age;
    }
    
    String getName() {
        return name;
    }
    void setName(String name) {
        this.name = name;
    }

    void setGender(boolean isMale) {
        this.isMale = isMale;
    }
    String getGender(){
        if (isMale){
            return "Male";
        }else{
            return "Female";
        }
    }
}


public class TP2_1_H071201048 {
    public static void main(String[] args) {
        Person orang = new Person();

        orang.setName("Cecep Kecap");
        orang.setAge(23);
        orang.setGender(true);

        System.out.println("Nama : " + orang.getName());
        System.out.println("Umur : "+ orang.getAge());
        
        if(orang.getGender() == "Male"){
            System.out.println("Brooo is Male");
        }else{
            System.out.println("Sist is Female");
        }
    }
}
