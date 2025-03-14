import java.util.Scanner;

public class TP1_2_H071241080 {
    public static void main(String[] args) {
        int[][] nums = { 
            {1, 2, 1}, 
            {4, 5, 6}, 
            {7, 8, 9} };

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Masukkan angka yang dicari: ");
            int angka = scanner.nextInt();

            boolean ditemukan = false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == angka) {
                        System.out.println("Menemukan angka " + angka + " di [" + i + "][" + j + "]");
                        ditemukan = true;
                        break; 
                    }
                }
                if (ditemukan) break;
            }
            if (!ditemukan) {
                System.out.println("Angka tidak ditemukan");
            }
            
        } catch (Exception e) {
            System.out.println("Input tidak valid");
        } finally {
            scanner.close(); 
        }
    }
}

