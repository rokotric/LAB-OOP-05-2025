import java.util.Scanner;

public class TP1_5 {
    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpper = false, hasLower = false, hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            if (Character.isLowerCase(ch)) hasLower = true;
            if (Character.isDigit(ch)) hasDigit = true;
        }

        return hasUpper && hasLower && hasDigit;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (isValidPassword(password)) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid! Harus minimal 8 karakter, mengandung huruf besar, huruf kecil, dan angka.");
        }

        scanner.close();
    }    
}
