import java.util.ArrayList;

public class PR {
    public static void main(String[] args) {
        Student s = new Student();
        s.setNama("Marsha");
        s.setID("J082345679");
        s.setSemester(5);
        s.addMatkul("Pengantar Ilmu Komunikasi");
        s.addMatkul("Teori Komunikasi");

        s.printInfo();
    }
}

class Student {
    String nama;
    String ID;
    int semester;
    ArrayList<String> matkul = new ArrayList<>();

    void setNama(String nama) {
        this.nama = nama;
    }
    void setID(String ID) {
        this.ID = ID;
    }
    void setSemester(int semester) {
        this.semester = semester;
    }
    void addMatkul(String matkul) {
        this.matkul.add(matkul);
    }
    void printInfo() {
        System.out.println("Nama: " + this.nama);
        System.out.println("ID: " + this.ID);
        System.out.println("Semester: " + this.semester);
        System.out.println("Matkul: ");
        for (String matkul_x : matkul) {
            System.out.println("- " + matkul_x);
        }
    }
}