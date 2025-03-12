import java.util.Scanner;

public class SearchIn2DArray {
    public static void main(String[] args) {
        int[][] nums = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        Scanner scanner = new Scanner(System.in);

        try {
            // Meminta input dari pengguna
            System.out.print("Masukkan angka yang ingin dicari: ");
            int target = scanner.nextInt();

            // Mencari angka dalam array
            boolean found = false;
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < nums[i].length; j++) {
                    if (nums[i][j] == target) {
                        System.out.println("Found " + target + " at [" + i + "][" + j + "]");
                        found = true;
                        break; // Hentikan pencarian setelah ditemukan
                    }
                }
                if (found) break;
            }

            // Jika tidak ditemukan
            if (!found) {
                System.out.println(target + " not found in the array.");
            }
        } catch (Exception e) {
            System.out.println("Input tidak valid. Harap masukkan angka.");
        } finally {
            scanner.close();
        }
    }
}