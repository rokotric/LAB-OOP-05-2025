import java.util.*;
class Student{
    String id, nama;
    int semester;
    ArrayList<String> courses = new ArrayList<>();

    public ArrayList<String> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }


    void addCourse(String kelas){
        courses.add(kelas);
    }

    void printInfo(){
        System.out.println("Nama : "+nama);
        System.out.println("NIM : "+id);
        System.out.println("Semester : "+semester);
        System.out.println("courses : "+"\n"+ courses);
    }

}

public class LiveCode {
    public static void main(String[] args) {
        Student gweh = new Student();

        gweh.setNama("Budi siregar");;
        gweh.setId("H071241048");;
        gweh.setSemester(2);;
        gweh.addCourse("Pengantar Sistem Informasi");
        gweh.addCourse("PBO");

        gweh.printInfo();
    }
}
