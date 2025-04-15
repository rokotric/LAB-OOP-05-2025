import java.util.Scanner;

public class faktorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan bilangan: ");
        int n = scanner.nextInt();

        int hasil = faktorial(n);

        System.out.println("Hasil: " + hasil);

        scanner.close();
    }

    public static int faktorial(int n) {
        if (n == 0 || n == 1) { 
            return 1;
        } else {
            return n * faktorial(n - 1);
        }
    }
}
