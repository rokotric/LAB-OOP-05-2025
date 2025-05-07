import classes.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("========== SIMULATOR KENDARAAN ==========\n");

        // MOBIL
        Mobil mobil = new Mobil("Toyota", "Avanza");
        mobil.setJumlahPintu(4);
        mobil.setJumlahKursi(7);
        mobil.setBahanBakar("Bensin Ron 95");
        mobil.setKapasitasMesin(1.5);
        mobil.setKecepatan(80);

        System.out.println(">>> MOBIL <<<");
        System.out.println("Merek          : " + mobil.getMerek());
        System.out.println("Model          : " + mobil.getModel());
        System.out.println("Jumlah Pintu   : " + mobil.getJumlahPintu());
        System.out.println("Jumlah Kursi   : " + mobil.getJumlahKursi());
        System.out.println("Bahan Bakar    : " + mobil.getBahanBakar());
        System.out.println("Kapasitas Mesin: " + mobil.getKapasitasMesin() + " L");
        System.out.println("Kecepatan      : " + mobil.getKecepatan() + " km/h");
        mobil.mulai();
        mobil.hitungPajak();
        mobil.berhenti();
        System.out.println();

        // MOTOR
        Motor motor = new Motor("Honda", "Vario 150");
        motor.setJenisMotor("Skuter");
        motor.setTipeSuspensi("Hydraulic");
        motor.setKapasitasTangki(5);
        motor.setKecepatan(60);

        System.out.println(">>> MOTOR <<<");
        System.out.println("Merek           : " + motor.getMerek());
        System.out.println("Model           : " + motor.getModel());
        System.out.println("Jenis Motor     : " + motor.getJenisMotor());
        System.out.println("Tipe Suspensi   : " + motor.getTipeSuspensi());
        System.out.println("Kapasitas Tangki: " + motor.getKapasitasTangki() + " L");
        System.out.println("Kecepatan       : " + motor.getKecepatan() + " km/h");
        motor.mulai();
        motor.hitungPajak();
        motor.berhenti();
        System.out.println();

        // SEPEDA
        Sepeda sepeda = new Sepeda("Polygon", "Monarch");
        sepeda.setJenisSepeda("Gunung");
        sepeda.setJumlahGear(21);
        sepeda.setUkuranRoda(27);
        sepeda.setKecepatan(20);

        System.out.println(">>> SEPEDA <<<");
        System.out.println("Merek        : " + sepeda.getMerek());
        System.out.println("Model        : " + sepeda.getModel());
        System.out.println("Jenis Sepeda : " + sepeda.getJenisSepeda());
        System.out.println("Jumlah Gear  : " + sepeda.getJumlahGear());
        System.out.println("Ukuran Roda  : " + sepeda.getUkuranRoda() + " inch");
        System.out.println("Kecepatan    : " + sepeda.getKecepatan() + " km/h");
        sepeda.mulai();
        sepeda.hitungPajak();
        sepeda.berhenti();
        System.out.println();

        // PERAHU
        Perahu perahu = new Perahu("Yamaha", "Fisher 2000");
        perahu.setJenisPerahu("Perahu Nelayan");
        perahu.setPanjang(7.5); // meter
        perahu.setKecepatan(25); // km/h

        System.out.println(">>> PERAHU <<<");
        System.out.println("Merek        : " + perahu.getMerek());
        System.out.println("Model        : " + perahu.getModel());
        System.out.println("Jenis Perahu : " + perahu.getJenisPerahu());
        System.out.println("Panjang      : " + perahu.getPanjang() + " meter");
        System.out.println("Kecepatan    : " + perahu.getKecepatan() + " km/h");
        perahu.mulai();
        perahu.hitungPajak();
        perahu.berhenti();
        System.out.println();

        System.out.println("========== SIMULASI SELESAI ==========");
    }
}
