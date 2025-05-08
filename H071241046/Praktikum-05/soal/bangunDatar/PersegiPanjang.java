package soal.bangunDatar;

import soal.BangunDatar;

import javax.swing.*;
import java.util.Scanner;

public class PersegiPanjang extends BangunDatar {
    Scanner sc = new Scanner(System.in);
    int panjang;
    int lebar;

    public void setPanjang() {
        System.out.print("Masukkan Panjang : ");
        int panjang = sc.nextInt();
        this.panjang = panjang;
    }

    public void setLebar() {
        System.out.print("Masukkan lebar : ");
        int lebar = sc.nextInt();
        this.lebar = lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    @Override
    public int showLuas() {
        return panjang * lebar;
    }

    @Override
    public int showKeliling() {
        return (lebar * 2) + (panjang * 2);
    }
}
