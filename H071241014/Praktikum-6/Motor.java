

import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private boolean memilikiBoxBelakang;
    private double kapasitasMesin;
    private double kecepatan;

    public Motor(String merek, String model) {
        super(merek, model);
    }

    public boolean isMemilikiBoxBelakang() {
        return memilikiBoxBelakang;
    }

    public void setMemilikiBoxBelakang(boolean memilikiBoxBelakang) {
        this.memilikiBoxBelakang = memilikiBoxBelakang;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
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
        System.out.println("Servis motor dilakukan.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date();
    }

    @Override
    public double hitungBiayaServis() {
        return 25000;
    }

    @Override
    public double hitungPajak() {
        return kapasitasMesin * 500;
    }

    @Override
    public String getTipeKendaraan() {
        return "Motor";
    }
}
