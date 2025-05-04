public class Person {
    public String name;
    public int age;
    public boolean isMale;
        
    public void setName(String newName) {
        name = newName;
    }
    
    public String getName() {
        return name;
    }
        
    public void setAge(int newAge) {
        age = newAge;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setGender(boolean gender) {
        isMale = gender;
    }
    
    public String getGender() {
        if (isMale) {
            return "Male";
        } else {
            return "Female";
        }
    }
}
