import java.util.Scanner;

public class TP1_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan tanggal (dd-mm-yy): ");
        String inputDate = scanner.nextLine();

        if (inputDate.matches("\\d{2}-\\d{2}-\\d{2}")) {
            String day = inputDate.substring(0, 2);  
            String month = inputDate.substring(3, 5); 
            String year = inputDate.substring(6, 8);  

            int yearInt = Integer.parseInt(year);
            String fullYear = (yearInt >= 50) ? "19" + year : "20" + year; 

            String monthName;
            switch (month) {
                case "01": monthName = "Januari"; break;
                case "02": monthName = "Februari"; break;
                case "03": monthName = "Maret"; break;
                case "04": monthName = "April"; break;
                case "05": monthName = "Mei"; break;
                case "06": monthName = "Juni"; break;
                case "07": monthName = "Juli"; break;
                case "08": monthName = "Agustus"; break;
                case "09": monthName = "September"; break;
                case "10": monthName = "Oktober"; break;
                case "11": monthName = "November"; break;
                case "12": monthName = "Desember"; break;
                default:
                    System.out.println("Bulan tidak valid!");
                    scanner.close();
                    return;
            }

            if (day.startsWith("0")) {
                day = day.substring(1);
            }

            System.out.println("Output: " + day + " " + monthName + " " + fullYear);
        } else {
            System.out.println("Format tanggal tidak valid! Gunakan format dd-mm-yy");
        }

        scanner.close();
    }
}
