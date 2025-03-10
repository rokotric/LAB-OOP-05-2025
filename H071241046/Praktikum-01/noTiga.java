import java.util.Scanner;

public class noTiga {
    public static void main(String[] args) {

        var sc = new Scanner(System.in);

        String tanggal = sc.nextLine();

        System.out.println(dateTool(tanggal));


    }

    static String dateTool(String tanggalIn){
        String[] tanggalArray = tanggalIn.split("-");
        String tanggal = tanggalArray[0];
        String bulan = switch (tanggalArray[1]){
            case "01" -> "Januari";
            case "02" -> "Februari";
            case "03" -> "Maret";
            case "04" -> "April";
            case "05" -> "Mei";
            case "06" -> "Juni";
            case "07" -> "Juli";
            case "08" -> "Agustus";
            case "09" -> "September";
            case "10" -> "Oktober";
            case "11" -> "November";
            case "12" -> "Desember";
            default -> null;


        };

        String tahun = (Integer.parseInt(tanggalArray[2]) <= 25 ) ? "20" + tanggalArray[2] : "19" + tanggalArray[2];



        return tanggal + " " + bulan + " " + tahun;
    }
}
