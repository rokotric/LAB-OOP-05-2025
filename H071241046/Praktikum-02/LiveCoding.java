import java.util.ArrayList;

public class LiveCoding {

    String nama;
    String NIM;
    int semester;
    ArrayList courses = new ArrayList();

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public int getSemeseter() {
        return semester;
    }

    public void setSemeseter(int semester) {
        this.semester = semester;
    }

    public void  getCorses() {
        for(Object course : this.courses){
            System.out.println(course);
        }
    }

    public void addCourse(String newCourse) {
        courses.add(newCourse);
    }

    public void printInfo(){
        System.out.println("Nama: " + this.getNama());
        System.out.println("NIM: " + this.getNIM());
        System.out.println("Semester: " + this.getSemeseter());

        System.out.println("Courses: ");
        for(Object course : courses){
            System.out.println(course);
        }
    }

    public static void main(String[] args) {


        var mahasiswa = new LiveCoding();
        mahasiswa.setNama("Asep");
        mahasiswa.setNIM("H1234512");
        mahasiswa.setSemeseter(4);

        mahasiswa.printInfo();

        mahasiswa.addCourse("OOP");
        mahasiswa.addCourse("Mobile");


    }
}
