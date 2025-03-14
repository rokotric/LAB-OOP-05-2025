import java.util.Scanner;

public class FaktorialRekursi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Meminta input dari pengguna
            System.out.print("Masukkan bilangan: ");
            int n = scanner.nextInt();

            // Validasi input (faktorial hanya untuk bilangan >= 0)
            if (n < 0) {
                System.out.println("Faktorial tidak terdefinisi untuk bilangan negatif.");
            } else {
                // Menghitung faktorial menggunakan rekursi
                long hasil = hitungFaktorial(n);
                System.out.println("Output: " + hasil);
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan bilangan bulat.");
        } finally {
            scanner.close();
        }
    }

    // Fungsi rekursif untuk menghitung faktorial
    public static long hitungFaktorial(int n) {
        if (n == 0 || n == 1) {
            return 1; // Basis rekursi
        }
        return n * hitungFaktorial(n - 1); // Panggilan rekursif
    }
}