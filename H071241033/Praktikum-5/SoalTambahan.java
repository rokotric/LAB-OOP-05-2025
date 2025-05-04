import java.util.Scanner;

class Bangun {
    void tampil() {
        System.out.println("Ini adalah bangun.");
    }
}

class BangunDatar extends Bangun {
    double luas() { return 0; }
    double keliling() { return 0; }
}

class Persegi extends BangunDatar {
    double sisi;

    Persegi(double sisi) {
        this.sisi = sisi;
    }

    double luas() {
        return sisi * sisi;
    }

    double keliling() {
        return 4 * sisi;
    }

    void tampil() {
        System.out.println("Luas persegi: " + luas());
        System.out.println("Keliling persegi: " + keliling());
    }
}

class PersegiPanjang extends BangunDatar {
    double panjang, lebar;

    PersegiPanjang(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    double luas() {
        return panjang * lebar;
    }

    double keliling() {
        return 2 * (panjang + lebar);
    }

    void tampil() {
        System.out.println("Luas persegi panjang: " + luas());
        System.out.println("Keliling persegi panjang: " + keliling());
    }
}

class BangunRuang extends Bangun {
    double volume() { return 0; }
}

class Kubus extends BangunRuang {
    double sisi;

    Kubus(double sisi) {
        this.sisi = sisi;
    }

    double volume() {
        return sisi * sisi * sisi;
    }

    void tampil() {
        System.out.println("Volume kubus: " + volume());
    }
}

class Balok extends BangunRuang {
    double p, l, t;

    Balok(double p, double l, double t) {
        this.p = p;
        this.l = l;
        this.t = t;
    }

    double volume() {
        return p * l * t;
    }

    void tampil() {
        System.out.println("Volume balok: " + volume());
    }
}


public class SoalTambahan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== BANGUN RUANG =====");
        System.out.println("1. KUBUS\n2. BALOK");
        System.out.println("===== BANGUN DATAR =====");
        System.out.println("3. PERSEGI\n4. PERSEGI PANJANG");
        System.out.print("Pilihan: ");
        int pilihan = sc.nextInt();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan sisi kubus: ");
                new Kubus(sc.nextDouble()).tampil();
                break;
            case 2:
                System.out.print("Masukkan panjang: ");
                double p = sc.nextDouble();
                System.out.print("Masukkan lebar: ");
                double l = sc.nextDouble();
                System.out.print("Masukkan tinggi: ");
                double t = sc.nextDouble();
                new Balok(p, l, t).tampil();
                break;
            case 3:
                System.out.print("Masukkan sisi persegi: ");
                new Persegi(sc.nextDouble()).tampil();
                break;
            case 4:
                System.out.print("Masukkan panjang: ");
                p = sc.nextDouble();
                System.out.print("Masukkan lebar: ");
                l = sc.nextDouble();
                new PersegiPanjang(p, l).tampil();
                break;
            default:
                System.out.println("Pilihan tidak tersedia.");
        }

        sc.close();
    }
}
