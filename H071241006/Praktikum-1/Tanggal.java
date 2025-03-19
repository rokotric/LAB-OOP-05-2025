import java.util.Scanner;

public class Tanggal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String tanggal = scanner.nextLine();

        String[] bagian = tanggal.split("-");

        int hari = Integer.parseInt(bagian[0]);
        int bulan = Integer.parseInt(bagian[1]);
        int tahun = Integer.parseInt(bagian[2]);

        if (tahun < 50) {
            tahun = 2000 + tahun; 
        } else {
            tahun = 1900 + tahun;
        }

        String[] namaBulan = {
            "", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
            "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        System.out.println(hari + " " + namaBulan[bulan] + " " + tahun);

        scanner.close();
    }
}
