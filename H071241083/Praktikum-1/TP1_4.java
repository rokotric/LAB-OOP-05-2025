import java.util.Scanner;

public class TP1_4 {
    public static int hitungFaktorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * hitungFaktorial(n - 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan bilangan n: ");
            int n = scanner.nextInt();

            if (n < 0) {
                System.out.println("Faktorial tidak terdefinisi untuk bilangan negatif!");
            } else {
                int hasil = hitungFaktorial(n);
                System.out.println("Faktorial dari " + n + " adalah: " + hasil);
            }
        } catch (Exception e) {
            System.out.println("Input harus berupa bilangan bulat!");
        } finally {
            scanner.close();
        }
    }
}
