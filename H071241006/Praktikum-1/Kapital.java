import java.util.Scanner;

public class Kapital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan Judul Film: ");
        String judul = scanner.nextLine(); 

        String hasil = ubahKapital(judul);

        System.out.println(hasil);

        scanner.close();
    }

    public static String ubahKapital(String teks) {
        String[] kata = teks.split(" ");
        String hasil = ""; 

        for (int i = 0; i < kata.length; i++) {
            if (kata[i].length() > 0) {
                String kataKapital = kata[i].substring(0, 1).toUpperCase() + kata[i].substring(1).toLowerCase();
                hasil += kataKapital + " "; 
            }
        }

        return hasil.trim(); 
    }
}
