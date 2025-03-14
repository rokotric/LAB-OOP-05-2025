import java.util.Scanner;

public class TP1_3_H071241080 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String input = scanner.nextLine();
        scanner.close();

        String[] parts = input.split("-");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        year += (year >= 26) ? 1900 : 2000;

        String[] namabulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        System.out.println(day + " " + namabulan[month - 1] + " " + year);
    } 
}

