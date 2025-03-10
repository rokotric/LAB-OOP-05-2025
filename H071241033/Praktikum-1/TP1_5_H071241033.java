import java.util.Scanner;

public class TP1_5_H071241033 {
    static void validasi_pw() {
        Scanner scanner = new Scanner (System.in);
        System.out.println("== INPUT PASSWORD ==");
        System.out.println("Note: PW minimal 8 karakter dan harus mengandung huruf besar, huruf kecil, dan angka");
        System.out.print("Masukkan password: ");
        String pw = scanner.nextLine();
        
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{8,}$";
        boolean result = pw.matches(pattern);
        if (result) {
            System.out.println("Password valid");
        } else {
            System.out.println("Password tidak valid");
        }
        scanner.close();
    }

    public static void main(String[] args) {
        validasi_pw();
    }
}