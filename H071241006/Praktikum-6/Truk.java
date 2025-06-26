import java.util.Date;

public class Truk extends Kendaraan implements Ibergerak, Iserviceable {
    private double kapasitasMuatan;  // dalam ton
    private int jumlahRoda;
    private double kecepatan;

    public Truk(String merek, String model) {
        super(merek, model);
    }

    public void setKapasitasMuatan(double kapasitas) {
        this.kapasitasMuatan = kapasitas;
    }
    public double getKapasitasMuatan() {
        return kapasitasMuatan;
    }

    public void setJumlahRoda(int roda) {
        this.jumlahRoda = roda;
    }
    
    public int getJumlahRoda() {
        return jumlahRoda;
    }
    

    @Override
    public double hitungPajak() {
        return kapasitasMuatan * 200000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Truk";
    }

    @Override
    public boolean mulai() {
        kecepatan = 5;
        return true;
    }

    @Override
    public boolean berhenti() {
        kecepatan = 0;
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
        System.out.println("Truk diservis.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(); 
    }

    @Override
    public double hitungBiayaServis() {
        return 1000000; 
    }
}