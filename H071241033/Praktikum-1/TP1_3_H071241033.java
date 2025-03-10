import java.util.Scanner;

public class TP1_3_H071241033 {
    static void format_tanggal() {
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};
        Scanner scanner = new Scanner (System.in);
        System.out.print("Masukkan tanggal dalam format 'dd-mm-yy': ");
        String input = scanner.nextLine();
        String[]inputArr = input.split("-");
        int inputBulan = Integer.parseInt(inputArr[1]) -1;
        int tahun = Integer.parseInt(inputArr[2]);
        int tanggal = Integer.parseInt(inputArr[0]);
        // 
        if (tahun < 30) {
            tahun += 2000;
        } else {
            tahun += 1900;
        }
        System.out.println(tanggal + " " + bulan[inputBulan] + " " + tahun);
        scanner.close();
    }

    public static void main(String[] args) {
        format_tanggal();
    }
}