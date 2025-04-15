package ToDoList;

import java.util.ArrayList;
import Task.Task;

public class ToDoList {
    private String namaPengguna;
    private ArrayList<Task> daftarTask;

    public ToDoList() {
        this.namaPengguna = "User";
        this.daftarTask = new ArrayList<>();
    }

    public ToDoList(String namaPengguna) {
        this.namaPengguna = namaPengguna;
        this.daftarTask = new ArrayList<>();
    }

    public void tambahTask(Task task) {
        daftarTask.add(task);
    }

    public void setSelesai(int index) {
        if (index >= 0 && index < daftarTask.size()) {
            daftarTask.get(index).selesaikan();
        }
    }

    public void tampilkanTask() {
        System.out.println("Daftar Tugas " + namaPengguna + ":");
        for (int i = 0; i < daftarTask.size(); i++) {
            System.out.println((i + 1) + ". " + daftarTask.get(i));
        }
    }

    public void bandingkan(ToDoList lain) {
        int selesaiA = this.hitungSelesai();
        int selesaiB = lain.hitungSelesai();

        if (selesaiA > selesaiB) {
            System.out.println(this.namaPengguna + " lebih produktif dari " + lain.namaPengguna);
        } else if (selesaiB > selesaiA) {
            System.out.println(lain.namaPengguna + " lebih produktif dari " + this.namaPengguna);
        } else {
            System.out.println("Keduanya sama produktif.");
        }
    }

    private int hitungSelesai() {
        int count = 0;
        for (Task t : daftarTask) {
            if (t.isSelesai()) count++;
        }
        return count;
    }

}

