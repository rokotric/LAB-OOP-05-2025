package livecoding;

import java.util.Scanner;

public class PersegiPanjang extends BangunDatar {
    public PersegiPanjang(double panjang, double lebar){
        this.setLebar(lebar);
        this.setPanjang(panjang);
    }
    double hitungLuas(){
        double hasil = this.getPanjang() * this.getLebar();
        return hasil;
    }
    double hitungKeliling(){
        double hasil = 2 * (this.getPanjang() * this.getLebar());
        return hasil;
    }

    public static void runPersegiPanjang(){
        Scanner x = new Scanner(System.in);

        System.out.println("=====PersegiPanjang");
        System.out.print("panjang: ");
        int inputpanjang= x.nextInt();
        System.out.print("lebar: ");
        int inputlebar= x.nextInt();


        PersegiPanjang pp = new PersegiPanjang(inputpanjang, inputlebar);

        System.out.println("luas persegi panjang: "+ pp.hitungLuas());
        System.out.println("keliling persegi panjang: "+ pp.hitungKeliling());
        x.close();
    }
}
