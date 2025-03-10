import java.util.Scanner;

public class TP1_1_H071241033 {
    static void kapitalisasi_judul() {
        try(Scanner scanner = new Scanner (System.in)) {
            System.out.print("Masukkan judul film: ");
            String judul = scanner.nextLine().toLowerCase(); //mengubah judul menjadi huruf kecil semua
            String[] kataArray = judul.split(" ");
            for (int i = 0; i < kataArray.length; i++) {
                kataArray[i] = kataArray[i].substring(0,1).toUpperCase() + kataArray[i].substring(1);
            }
            String hasil = String.join(" ",kataArray);
            System.out.println(hasil);
        }
    }


    public static void main(String[] args) {
        kapitalisasi_judul();
    }   
}