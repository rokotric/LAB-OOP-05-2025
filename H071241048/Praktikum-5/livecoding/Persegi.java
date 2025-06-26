package livecoding;

import java.util.Scanner;

public class Persegi extends BangunDatar {
    public Persegi(double sisi){
        this.setSisi(sisi);
    }
    double hitungLuas(){
        double hasil = this.getSisi() * this.getSisi();
        return hasil;
    }
    double hitungKeliling(){
        double hasil = 4 * this.getSisi();
        return hasil;
    }

    public static void runPersegi(){
        Scanner x = new Scanner(System.in);

        System.out.println("=====Persegi");
        System.out.print("SISI: ");
        int inputsisi = x.nextInt();


        Persegi persegi = new Persegi(inputsisi);

        System.out.println("luas persegi: "+ persegi.hitungLuas());
        System.out.println("keliling persegi: "+ persegi.hitungKeliling());
        x.close();
    }
}
