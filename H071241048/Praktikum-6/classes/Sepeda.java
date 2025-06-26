package classes;
import interfaces.IBergerak;
import interfaces.IServiceable;
import java.util.Date;


public class Sepeda extends Kendaraan implements IBergerak, IServiceable {
    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;
    private double kecepatan;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisSepeda() { return jenisSepeda; }
    public void setJenisSepeda(String jenis) { this.jenisSepeda = jenis; }

    public int getJumlahGear() { return jumlahGear; }
    public void setJumlahGear(int jumlah) { this.jumlahGear = jumlah; }

    public int getUkuranRoda() { return ukuranRoda; }
    public void setUkuranRoda(int ukuran) { this.ukuranRoda = ukuran; }

    @Override
    public double hitungPajak() {
        System.out.println("Sepeda tidak dikenakan pajak.");
        return 0; // Sepeda tidak dikenakan pajak
    }

    @Override
    public String getTipeKendaraan() { return "Sepeda"; }

    @Override
    public boolean mulai() {
        System.out.println("Mengayuh sepeda " + merek + " " + model + " dengan semangatt ");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Sepeda berhenti dengan menarik tuas rem. Jangan lupa istirahat.");
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
        System.out.println("Pemeriksaan sepeda: Pelumasan rantai, penyetelan rem dan roda.");
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        return new Date(System.currentTimeMillis() + 7776000000L); // 90 hari
    }

    @Override
    public double hitungBiayaServis() {
        return 25000;
    }
}


