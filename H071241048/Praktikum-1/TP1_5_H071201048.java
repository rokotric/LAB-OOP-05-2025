import java.util.Scanner;

public class TP1_5_H071201048 {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("Masukkan password: ");
        String input = x.nextLine();

        boolean kapital = false, kecil = false, angka = false;

        for(char i : input.toCharArray()){
            if (Character.isUpperCase(i)){
                kapital = true;
            } else if (Character.isLowerCase(i)){
                kecil = true;
            }else if (Character.isDigit(i)){
                angka = true;
            }
        }

        if (input.length() >= 8 && kapital && kecil && angka) {
            System.out.println("Password Valid!");
        } else {
            System.out.println("Password Tidak Valid");        
            System.out.println("Minimal 8 karakter & Harus mengandung huruf besar, huruf kecil, dan angka");
        }
        x.close();
    }
}
