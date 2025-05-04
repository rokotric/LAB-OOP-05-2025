import java.util.ArrayList;

public class Student {
    String name;
    String id;
    int semester;
    ArrayList<String> courses;
    
    public Student(String name, String id, int semester) {
        this.name = name;
        this.id = id;
        this.semester = semester;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getSemester() {
        return semester;
    }
    public void setSemester(int semester) {
        this.semester = semester;
    }
    public ArrayList<String> getCourses() {
        return courses;
    }
    public void setCourses(ArrayList<String> courses) {
        this.courses = courses;
    }
    
    public void addCourse(String CourseName) {
        if (courses == null) {
            courses = new ArrayList<>();
        }
        courses.add(CourseName);
    }

    public void printInfo() {
        System.out.println("Name : " + name);
        System.out.println("ID : " + id);
        System.out.println("Semester : " + semester);
        System.out.println("Courses : " + courses);
    }

    public static void main(String[] args) {
        Student Mahasiswa = new Student("Hanifah", "H071241080", 2 );
        Mahasiswa.addCourse("OOP");
        Mahasiswa.addCourse("Desain dan Analisis Algoritma");
        Mahasiswa.printInfo();
    }
    
}
