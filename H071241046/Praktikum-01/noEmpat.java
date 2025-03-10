import java.util.Scanner;

public class noEmpat {
    public static void main(String[] args) {

        var sc = new Scanner(System.in);
        int numInput = sc.nextInt();

        System.out.println(faktorial(numInput));
    }

    static int faktorial(int num){
        if (num == 1){
            return 1;
        } else if (num == 0){
            return 1;
        } else {
            return num * faktorial(num-1);
        }
    }
}
