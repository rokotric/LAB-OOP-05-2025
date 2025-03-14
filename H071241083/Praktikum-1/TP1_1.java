import java.util.Scanner;

public class TP1_1 {
    public static void main(String[] argas) {
        Scanner Scanner = new Scanner(System.in);
        System.out.print("Masukkan Judul Film :\n");
        String input = Scanner.nextLine();
        String result = Kapital(input);
        System.out.println(result);

        Scanner.close();
    }

    public static String Kapital(String input) {
        String[] words = input.split(" ");
        StringBuilder hurufKapital = new StringBuilder();

        for (String kata : words) {
            if (kata.length() > 0) {
                hurufKapital.append(Character.toUpperCase(kata.charAt(0)));
                hurufKapital.append(kata.substring(1).toLowerCase());
                hurufKapital.append(" ");
            }
        }

        return hurufKapital.toString().trim();
    }
}