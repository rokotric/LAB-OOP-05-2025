import java.util.Scanner;

public class TP1_1_H071201048 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan Judul Film: ");
        String judul = x.nextLine();
        String hasil = "";

        for (int i = 0; i < judul.length(); i++) {
            
            if (i == 0 || judul.charAt(i-1) == ' ') {
                hasil += judul.toUpperCase().charAt(i);
            } else {
                hasil += judul.toLowerCase().charAt(i);
            }
        }

        System.out.println(hasil);
        x.close();
    }
}
