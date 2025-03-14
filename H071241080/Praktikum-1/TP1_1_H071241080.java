import java.util.Scanner;

public class TP1_1_H071241080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan judul film: ");
        String judul = scanner.nextLine();  
        scanner.close();

        String[] words = judul.split(" "); 
        StringBuilder hasil = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                hasil.append(Character.toUpperCase(word.charAt(0)))
                .append(word.substring(1).toLowerCase()).append(" ");
                }
            }
        System.out.println(hasil.toString().trim());
    }
}
