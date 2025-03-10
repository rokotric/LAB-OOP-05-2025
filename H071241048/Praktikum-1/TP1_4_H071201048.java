import java.util.Scanner;

public class TP1_4_H071201048 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan nilai: ");
        int input = x.nextInt();

        System.out.println(faktorial(input));
        x.close();
    }

    public static int faktorial(int n) {
        if (n == 0 || n== 1){
            return 1;
        } else {
            return n * faktorial(n-1);
        }
    }
}
