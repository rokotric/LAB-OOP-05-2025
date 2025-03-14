import java.util.Scanner;

public class TP1_5_H071241080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        boolean hurupBesar = false, hurupKecil = false, angka = false;

        if (password.length() >= 8) {
            for (char hurup : password.toCharArray()) {
                if (Character.isUpperCase(hurup)) hurupBesar = true;
                if (Character.isLowerCase(hurup)) hurupKecil = true;
                if (Character.isDigit(hurup)) angka = true;
            }
        }

        if (password.length() >= 8 && hurupBesar && hurupKecil && angka) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }

        scanner.close();
    }
}
