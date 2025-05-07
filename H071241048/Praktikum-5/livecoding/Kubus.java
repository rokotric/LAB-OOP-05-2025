package livecoding;

import java.util.Scanner;

public class Kubus extends BangunRuang{
    public Kubus(double sisi){
        this.setSisi(sisi);
    }

    double luas (){
        double hasil = 6 * (this.getSisi()*2);
        return hasil;
    }
    double volume(){
        double hasil = this.getSisi() * this.getSisi() * this.getSisi();
        return hasil;
    }

    public static void runKubus(){
        Scanner x = new Scanner(System.in);

        System.out.println("=====Kubus");
        System.out.print("SISI: ");
        int inputsisi = x.nextInt();


        Kubus kubus = new Kubus(inputsisi);

        System.out.println("luas kubus: "+ kubus.luas());
        System.out.println("volume kubus: "+ kubus.volume());
        x.close();
    }
}
