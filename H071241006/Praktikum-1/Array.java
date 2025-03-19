import java.util.Random;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int[][] nums = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                nums[i][j] = random.nextInt(9) + 1; 
            }
        }

        System.out.println("Array 2D:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }

        try {
            System.out.print("\nMasukkan angka yang dicari: ");
            int cari = scanner.nextInt();

            boolean ditemukan = false;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (nums[i][j] == cari) {
                        System.out.println("Found " + cari + " at [" + i + "][" + j + "]");
                        ditemukan = true;
                        break; 
                    }
                }
                if (ditemukan) break;
            }

            if (!ditemukan) {
                System.out.println("Angka " + cari + " tidak ditemukan.");
            }

        } catch (Exception e) {
            System.out.println("Input harus berupa angka!");
        }

        scanner.close();
    }
}
