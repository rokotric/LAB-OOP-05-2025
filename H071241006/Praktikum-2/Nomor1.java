public class Nomor1 {
    String name;
    int age;
    boolean isMale;

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
            return "Laki-laki";
        } else {
            return "Perempuan";
        }
    }

    public static void main(String[] args) {
        Nomor1 orang = new Nomor1();

        orang.setName("A. izza syathra");
        orang.setAge(18);
        orang.setGender(false);

        System.out.println("Nama: " + orang.getName());
        System.out.println("Umur: " + orang.getAge());
        System.out.println("Jenis Kelamin: " + orang.getGender());
    }
}
