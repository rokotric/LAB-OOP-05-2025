package classes;
import interfaces.IBergerak;

public class Perahu extends Kendaraan implements IBergerak {
    private String jenisPerahu;
    private double panjang;
    private double kecepatan;

    public Perahu(String merek, String model) {
        super(merek, model);
    }

    public String getJenisPerahu() { return jenisPerahu; }
    public void setJenisPerahu(String jenisPerahu) {
        this.jenisPerahu = jenisPerahu;
    }

    public double getPanjang() { return panjang; }
    public void setPanjang(double panjang) { this.panjang = panjang; }

    @Override
    public double hitungPajak() {
        double pajak = panjang * 200;
        System.out.println("Pajak untuk perahu " + merek + " " + model + " adalah Rp" + pajak);
        return pajak;
    }

    @Override
    public String getTipeKendaraan() { return "Perahu"; }

    @Override
    public boolean mulai() {
        System.out.println("Perahu " + merek + " " + model + " mulai mengarungi perairan. Angin berhembus tenang.");
        return true;
    }

    @Override
    public boolean berhenti() {
        System.out.println("Perahu berhenti, jangkar diturunkan.");
        return true;
    }

    @Override
    public double getKecepatan() { return kecepatan; }

    @Override
    public void setKecepatan(double kecepatan) {
        this.kecepatan = kecepatan;
    }
}
