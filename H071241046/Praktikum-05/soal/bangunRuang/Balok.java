package soal.bangunRuang;

import soal.BangunRuang;

import java.util.Scanner;

public class Balok extends BangunRuang {
    Scanner sc = new Scanner(System.in);
    int panjang;
    int lebar;
    int tinggi;

    public void setPanjang() {
        System.out.print("Masukkan panjang : ");
        int panjang = sc.nextInt();
        this.panjang = panjang;
    }

    public void setLebar() {
        System.out.print("Masukkan lebar : ");
        int lebar = sc.nextInt();
        this.lebar = lebar;
    }

    public void setTinggi() {
        System.out.print("Masukkan tinggi : ");
        int tinggi = sc.nextInt();
        this.tinggi = tinggi;
    }

    @Override
    public int showVolume() {
        return panjang * lebar * tinggi;
    }

    @Override
    public int showLuas() {
        return 2 * ((panjang * lebar) + (panjang * tinggi) + (lebar * tinggi));
    }
}
