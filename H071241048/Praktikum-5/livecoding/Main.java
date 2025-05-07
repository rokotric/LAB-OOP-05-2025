package livecoding;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);

        System.out.println("===BangunDatar");
        System.out.println("1.Persegi\n"+"2.Persegi panjang");
        System.out.println("===BangunRuang");
        System.out.println("3.Balok\n"+"4.Kubus");
        System.out.print("piihan: ");
        int pilih = x.nextInt();

        switch (pilih) {
            case 1:
                Persegi.runPersegi();
                break;
            case 2:
                PersegiPanjang.runPersegiPanjang();
                break;
            case 3:
                Balok.runBalok();
                break;
            case 4:
                Kubus.runKubus();
                break;
        
            default:
                break;
        }
        x.close();
    }
}
