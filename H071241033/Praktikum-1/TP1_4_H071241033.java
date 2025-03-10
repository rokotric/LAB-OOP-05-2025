import java.util.Scanner;

public class TP1_4_H071241033 {
    public static int faktorial(int n) {
        if (n == 0 || n == 1){
            return 1;
        }
        return n * faktorial(n-1);
    }
    static void panggil_faktorial() {
        Scanner scanner = new Scanner (System.in);
        System.out.print("Masukkan bilangan n: ");
        int n = scanner.nextInt();
        System.out.println(faktorial(n));
        scanner.close();
    }

    public static void main(String[] args) {
        panggil_faktorial();
    }
}