import java.util.Date;

public class Mobil extends Kendaraan implements Ibergerak, Iserviceable {
    private int jumlahPintu; //ATRIBUT
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;
    private double kecepatan;

    public Mobil(String merek, String model) {
        super(merek, model);
    }// Constructor dari class Mobil, menerima merek dan model, lalu melemparkannya ke constructor Kendaraan menggunakan super().

    public int getJumlahPintu(){
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlah) {
        this.jumlahPintu = jumlah; 
    }

    public double getKapasitasMesin(){
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitas) { 
        this.kapasitasMesin = kapasitas; 
    }

    public int JumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int kursi) { 
        this.jumlahKursi = kursi; 
    }

    public String BahanBakar(){
        return bahanBakar;
    }

    public void setBahanBakar(String bahan) { 
        this.bahanBakar = bahan; 
    }


    // @Override
    public double hitungPajak() {
        return kapasitasMesin * 100000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    @Override
    public boolean mulai() { 
        kecepatan = 10; 
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
        System.out.println("Mobil diservis."); 
    }

    @Override
    public Date getWaktuServisBerikutnya() { 
        return new Date(); 
    }

    @Override
    public double hitungBiayaServis() { 
        return 75000;
    }
}


    
