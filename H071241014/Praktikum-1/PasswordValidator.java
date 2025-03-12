import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Meminta input password dari pengguna
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();

            // Memvalidasi password
            if (isValidPassword(password)) {
                System.out.println("Password valid");
            } else {
                System.out.println("Password tidak valid. Harus minimal 8 karakter, mengandung huruf besar, huruf kecil, dan angka.");
            }
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan dalam input.");
        } finally {
            scanner.close();
        }
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            return false;
        }

        boolean hasUpper = false, hasLower = false, hasDigit = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                hasUpper = true;
            } else if (Character.isLowerCase(ch)) {
                hasLower = true;
            } else if (Character.isDigit(ch)) {
                hasDigit = true;
            }

            // Jika semua kriteria sudah terpenuhi, langsung return true
            if (hasUpper && hasLower && hasDigit) {
                return true;
            }
        }
        return false;
    }
}