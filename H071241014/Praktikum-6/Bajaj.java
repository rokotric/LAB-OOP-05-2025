
public class Bajaj extends Kendaraan implements IBergerak {
    private int jumlahPenumpang;
    private double kecepatan;

    public Bajaj(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPenumpang() {
        return jumlahPenumpang;
    }

    public void setJumlahPenumpang(int jumlahPenumpang) {
        this.jumlahPenumpang = jumlahPenumpang;
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
    public double hitungPajak() {
        return 200000;
    }

    @Override
    public String getTipeKendaraan() {
        return "Bajaj";
    }
}
