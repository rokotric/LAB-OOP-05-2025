package soal.bangunDatar;

import soal.BangunDatar;

import java.util.Scanner;

public class Persegi extends BangunDatar {

    Scanner sc = new Scanner(System.in);
    int sisi;

    public void setSisi() {
        System.out.print("Masukkan sisi : ");
        int sisi = sc.nextInt();
        this.sisi = sisi;
    }

    @Override
    public int showLuas() {
        return sisi * sisi;
    }

    @Override
    public int showKeliling() {
        return 4 * sisi;
    }
}
