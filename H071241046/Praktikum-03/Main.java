import ToDoList.ToDoList;
import Task.Task;

public class Main {
    public static void main(String[] args) {

        ToDoList budi = new ToDoList("Budi");
        budi.tambahTask(new Task("Belajar Java", "Pendidikan"));
        budi.tambahTask(new Task("Beli telur", "Belanja"));
        budi.setSelesai(0);

        ToDoList ani = new ToDoList("Ani");
        ani.tambahTask(new Task("Masak makan siang", "Rumah"));
        ani.tambahTask(new Task("Kerjakan laporan", "Kuliah"));
        ani.setSelesai(1);

        ToDoList user = new ToDoList();
        user.tambahTask(new Task("Masak makan siang", "Rumah"));
        user.tambahTask(new Task("Kerjakan laporan", "Kuliah"));
        user.setSelesai(1);

        budi.tampilkanTask();
        ani.tampilkanTask();
        user.tampilkanTask();

        budi.bandingkan(ani);

    }
}
