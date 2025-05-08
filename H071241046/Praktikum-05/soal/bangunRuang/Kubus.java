package soal.bangunRuang;

import soal.BangunRuang;

import javax.swing.*;
import java.util.Scanner;

public class Kubus extends BangunRuang {
    Scanner sc = new Scanner(System.in);
    int sisi;

    public void setSisi() {
        System.out.print("Masukkan sisi : ");
        int sisi = sc.nextInt();
        this.sisi = sisi;
    }

    @Override
    public int showVolume() {
        return sisi * sisi * sisi;
    }

    @Override
    public int showLuas() {
        return 6 * sisi * sisi;
    }
}
