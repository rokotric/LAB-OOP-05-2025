package Code;

import Code.Abstract.Kendaraan;
import Code.Interface.IBergerak;
import Code.Interface.IServiceable;

import java.util.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;


public class Mobil extends Kendaraan implements IBergerak, IServiceable {
    private int jumlahPintu;
    private double kapasitasMesin;
    private int jumlahKursi;
    private String bahanBakar;

    public Mobil(String merek, String model) {
        super(merek, model);
    }

    public int getJumlahPintu() {
        return jumlahPintu;
    }

    public void setJumlahPintu(int jumlahPintu) {
        this.jumlahPintu = jumlahPintu;
    }

    public double getKapasitasMesin() {
        return kapasitasMesin;
    }

    public void setKapasitasMesin(double kapasitasMesin) {
        this.kapasitasMesin = kapasitasMesin;
    }

    public int getJumlahKursi() {
        return jumlahKursi;
    }

    public void setJumlahKursi(int jumlahKursi) {
        this.jumlahKursi = jumlahKursi;
    }

    public String getBahanBakar() {
        return bahanBakar;
    }

    public void setBahanBakar(String bahanBakar) {
        this.bahanBakar = bahanBakar;
    }

    @Override
    public double hitungPajak() {
        double tahunSekarang = LocalDate.now().getYear();
        double usiaKendaraan = tahunSekarang - tahunProduksi;
        if (usiaKendaraan <= 5) {
            return 2_000_000;
        } else if (usiaKendaraan <= 10) {
            return 1_500_000;
        } else{
            return 1_000_000;
        }
    }

    @Override
    public String getTipeKendaraan() {
        return "Mobil";
    }

    @Override
    public boolean mulai() {
        System.out.println(getTipeKendaraan() + " " + model + " bergerak");
        return true;
    }

    @Override
    public boolean berhenti() {
        if(mulai()){
            System.out.println(getTipeKendaraan() + " " + model + " berhenti");
        } else{
            System.out.println(getTipeKendaraan() + " " + model + " tidak sedang bergerak");
        }
        return false;
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
        System.out.println(getTipeKendaraan() + " " + model + " sedang diperiksa");
        return true;
    }

    @Override
    public void lakukanServis() {
        if(periksaKondisi()){
            System.out.println(getTipeKendaraan() + " " + model + " sedang diservis");
        } else{
            System.out.println("Kendaraan tidak dalam pemeriksaan");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        LocalDate hariIni = LocalDate.now();
        LocalDate waktuServis = hariIni.plusDays(60);
        return Date.from(waktuServis.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public double hitungBiayaServis() {
        double pajak = hitungPajak();
        double biayaServis = pajak * 0.1;
        return biayaServis;
    }
}
