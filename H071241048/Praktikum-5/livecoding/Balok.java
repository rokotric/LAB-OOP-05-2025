package livecoding;

import java.util.Scanner;

public class Balok extends BangunRuang{
    public Balok(double panjang, double lebar, double tinggi){
        this.setLebar(lebar);
        this.setPanjang(panjang);
        this.setTinggi(tinggi);
    }

    double luas (){ //2(pl + pt + lt)
        double hasil = 2 * ((this.getPanjang()*this.getLebar()) + (this.getPanjang()*this.getTinggi()) + (this.getLebar()*this.getTinggi()));
        return hasil;
    }
    double volume(){
        double hasil = this.getPanjang() * this.getLebar() * this.getTinggi();
        return hasil;
    }

    public static void runBalok(){
        Scanner x = new Scanner(System.in);

        System.out.println("=====balook");
        System.out.print("panjang: ");

        int inputPanjang = x.nextInt();
        System.out.print("Lebar ");
        int inputLebar = x.nextInt();
        System.out.print("Tinggi: ");
        int inputTinggi= x.nextInt();

        Balok balok = new Balok(inputPanjang,inputLebar,inputTinggi);

        System.out.println("luas balok: "+ balok.luas());
        System.out.println("volume balok: "+ balok.volume());
        x.close();
    }
}
