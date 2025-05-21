

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
        return kapasitasMesin * 1000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    @Override
    public boolean mulai() {
        return true;
    }

    @Override
    public boolean berhenti() {
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
        System.out.println("Servis mobil dilakukan.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date();
    }

    @Override
    public double hitungBiayaServis() {
        return 50000;
    }
}
