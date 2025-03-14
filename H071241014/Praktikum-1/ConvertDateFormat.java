import java.util.Scanner;

public class ConvertDateFormat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Masukkan tanggal (dd-mm-yy): ");
            String input = scanner.nextLine();

            
            String[] parts = input.split("-");
            int day = Integer.parseInt(parts[0]);
            int month = Integer.parseInt(parts[1]);
            int year = Integer.parseInt(parts[2]);

            
            year += (year <= 30) ? 2000 : 1900;

            
            String[] bulan = {
                "", "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
            };

            
            System.out.println(day + " " + bulan[month] + " " + year);
        } catch (Exception e) {
            System.out.println("Format input tidak valid. Gunakan format dd-mm-yy.");
        } finally {
            scanner.close();
        }
    }
}