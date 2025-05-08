package Code;

import Code.Abstract.Kendaraan;
import Code.Interface.IBergerak;
import Code.Interface.IServiceable;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Motor extends Kendaraan implements IBergerak, IServiceable {
    private String jenisMotor;
    private double kapasitasTangki;
    private String tipeSuspensi;

    public Motor(String merek, String model){
        super(merek, model);
    }


    public String getJenisMotor() {
        return jenisMotor;
    }

    public void setJenisMotor(String jenisMotor) {
        this.jenisMotor = jenisMotor;
    }

    public double getKapasitasTangki() {
        return kapasitasTangki;
    }

    public void setKapasitasTangki(double kapasitasTangki) {
        this.kapasitasTangki = kapasitasTangki;
    }

    public String getTipeSuspensi() {
        return tipeSuspensi;
    }

    public void setTipeSuspensi(String tipeSuspensi) {
        this.tipeSuspensi = tipeSuspensi;
    }

    @Override
    public double hitungPajak() {
        double tahunSekarang = LocalDate.now().getYear();
        double usiaKendaraan = tahunSekarang - tahunProduksi;
        if (usiaKendaraan <= 5) {
            return 1_000_000;
        } else if (usiaKendaraan <= 10) {
            return 750_000;
        } else{
            return 500_000;
        }
    }

    @Override
    public String getTipeKendaraan() {
        return "Roda dua";
    }

    @Override
    public boolean mulai() {
        System.out.println("Motor " + model + " bergerak");
        return true;
    }

    @Override
    public boolean berhenti() {
        if(mulai()){
            System.out.println("motor " + model + " berhenti");
        } else{
            System.out.println("motor " + model + " tidak sedang bergerak");
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
        System.out.println("motor " + model + " sedang diperiksa");
        return true;
    }

    @Override
    public void lakukanServis() {
        if(periksaKondisi()){
            System.out.println("motor " + model + " sedang diservis");
        } else{
            System.out.println("Kendaraan tidak dalam pemeriksaan");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        LocalDate hariIni = LocalDate.now();
        LocalDate waktuServis = hariIni.plusDays(30);
        return Date.from(waktuServis.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public double hitungBiayaServis() {
        double pajak = hitungPajak();
        double biayaServis = pajak * 0.1;
        return biayaServis;
    }
}
