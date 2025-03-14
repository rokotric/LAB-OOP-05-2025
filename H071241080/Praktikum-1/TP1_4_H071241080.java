import java.util.Scanner;

public class TP1_4_H071241080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        int angka = scanner.nextInt();

        if (angka < 0) {
            System.out.println("Bilangan harus positif");
        } else {
            int hasil = Faktorial(angka);
            System.out.println("Output: " + hasil);
        }
        scanner.close();
    }
    
    public static int Faktorial(int n) {
        return (n == 0) ? 1 : n * Faktorial(n - 1);
    }
}

