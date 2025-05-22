package soal;

import soal.bangunDatar.Persegi;
import soal.bangunDatar.PersegiPanjang;
import soal.bangunRuang.Balok;
import soal.bangunRuang.Kubus;

import java.util.Scanner;

public class Main {
    static Kubus kubus = new Kubus();
    static PersegiPanjang persegiPanjang = new PersegiPanjang();
    static Persegi persegi = new Persegi();
    static Balok balok = new Balok();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Balok balok = new Balok();

        System.out.println("===Bangun Ruang===");
        System.out.println("1. Kubus");
        System.out.println("2. Balok");

        System.out.println("===Bangun Datar===");
        System.out.println("3. Persegi");
        System.out.println("4. Persegi Panjang");

        System.out.print("Masukkan pilihan (enter untuk keluar) -> ");
        String pilihan = sc.nextLine();

        if (pilihan.equals("1")) {
            menuKubus();
        } else if (pilihan.equals("2")) {
            menuBalok();
        } else if (pilihan.equals("3")) {
            menuPersgi();
        } else if (pilihan.equals("4")) {
            menuPersegiPanjang();
        } else{
            System.out.println("Pilihan invalid");
        }
    }

    static public void menuKubus(){
        kubus.setSisi();
        System.out.println("Luas alas : " + kubus.showLuas());
        System.out.println("Luas volume : " + kubus.showVolume());
    }

    static public void menuPersgi(){
        persegi.setSisi();
        System.out.println("Luas luas : " + persegi.showLuas());
        System.out.println("Luas keliling : " + persegi.showKeliling());
    }

    static public void menuBalok(){
        balok.setPanjang();
        balok.setLebar();
        balok.setTinggi();
        System.out.println("Luas alas : " + balok.showLuas());
        System.out.println(" volume : " + balok.showVolume());
    }

    static public void menuPersegiPanjang(){
        persegiPanjang.setPanjang();
        persegiPanjang.setLebar();
        System.out.println("Luas alas : " + persegiPanjang.showLuas());
        System.out.println("Luas volume : " + persegiPanjang.showKeliling());
    }
}
