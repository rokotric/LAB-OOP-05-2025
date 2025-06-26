package classes;
import interfaces.IBergerak;
import interfaces.IServiceable;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;
    private double kecepatan;

    public Motor(String merek, String model) {
        super(merek, model);
    }

    public String getJenisMotor() { return jenisMotor; }
    public void setJenisMotor(String jenis) { this.jenisMotor = jenis; }

    public double getKapasitasTangki() { return kapasitasTangki; }
    public void setKapasitasTangki(double kapasitas) { this.kapasitasTangki = kapasitas; }

    public String getTipeSuspensi() { return tipeSuspensi; }
    public void setTipeSuspensi(String tipe) { this.tipeSuspensi = tipe; }

    @Override
    public double hitungPajak() {
        double pajak = kapasitasTangki * 300;
        System.out.println("Pajak untuk motor " + merek + " " + model + " adalah Rp" + pajak);
        return pajak;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }

    @Override
    public boolean mulai() {
        System.out.println("Motor " + merek + " " + model + " dinyalakan dengan suara khas. Vrooom!");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Motor " + merek + " " + model + " berhenti. Pastikan standar samping diturunkan.");
        return true;
    }

    @Override
    public double getKecepatan() { return kecepatan; }

    @Override
    public void setKecepatan(double kecepatan) { this.kecepatan = kecepatan; }

    @Override
    public boolean periksaKondisi() { return true; }

    @Override
    public void lakukanServis() {
        System.out.println("Servis motor: Ganti oli, periksa kebersihan mesin, cek rem dan tekanan ban.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 2592000000L); // 30 hari
    }

    @Override
    public double hitungBiayaServis() {
        return 50000;
    }
}
