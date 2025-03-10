import java.util.Scanner;

public class TP1_3_H071201048 {

    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        System.out.print("input: ");
        String[] bak = x.nextLine().split("-");

        int tanggal = Integer.parseInt(bak[0]);
        int bulanAngka = Integer.parseInt(bak[1]);
        int tahun = Integer.parseInt(bak[2]);

        String bulan;

        switch (bulanAngka) {
            case 1:  bulan = "Januari"; break;
            case 2:  bulan = "Februari"; break;
            case 3:  bulan = "Maret"; break;
            case 4:  bulan = "April"; break;
            case 5:  bulan = "Mei"; break;
            case 6:  bulan = "Juni"; break;
            case 7:  bulan = "Juli"; break;
            case 8:  bulan = "Agustus"; break;
            case 9:  bulan = "September"; break;
            case 10: bulan = "Oktober"; break;
            case 11: bulan = "November"; break;
            case 12: bulan = "Desember"; break;
            default: bulan = "Bulan tidak valid!";
        }

        if(tahun >= 0 && tahun <= 30){
            tahun = 2000 + tahun;
        }else if(tahun >= 31 && tahun <= 99){
            tahun = 1900 + tahun;
        }else{
            System.out.println("tahun tidak valid");
        }

        System.out.println(tanggal+" "+bulan+" "+ tahun);
        x.close();
    }
}
