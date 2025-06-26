package classes;
import interfaces.IBergerak;
import interfaces.IServiceable;
import java.util.Date;

public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;

    public Mobil(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPintu() { return jumlahPintu; }
    public void setJumlahPintu(int jumlah) { this.jumlahPintu = jumlah; }

    public double getKapasitasMesin() { return kapasitasMesin; }
    public void setKapasitasMesin(double kapasitas) { this.kapasitasMesin = kapasitas; }

    public int getJumlahKursi() { return jumlahKursi; }
    public void setJumlahKursi(int jumlah) { this.jumlahKursi = jumlah; }

    public String getBahanBakar() { return bahanBakar; }
    public void setBahanBakar(String bahanBakar) { this.bahanBakar = bahanBakar; }

    @Override
    public double hitungPajak() {
        double pajak = kapasitasMesin * 500;
        System.out.println("Pajak untuk mobil " + merek + " " + model + " adalah Rp" + pajak);
        return pajak;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    @Override
    public boolean mulai() {
        System.out.println("Mesin mobil " + merek + " " + model + " dinyalakan. Siap berangkat!");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Mobil " + merek + " " + model + " berhenti dan mesin dimatikan.");
        return true;
    }

    @Override
    public double getKecepatan() {
        return kecepatan;
    }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }

    @Override
    public boolean periksaKondisi() {
        return true;
    }

    @Override
    public void lakukanServis() {
        System.out.println("Melakukan servis berkala untuk mobil " + merek + " " + model + ". Ganti oli, periksa rem, cek mesin dan lain-lain.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 2592000000L); // 30 hari
    }

    @Override
    public double hitungBiayaServis() {
        return 1000000;
    }
}
