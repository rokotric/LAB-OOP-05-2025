package Code;

import Code.Abstract.Kendaraan;
import Code.Interface.IBergerak;
import Code.Interface.IServiceable;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Sepeda extends Kendaraan implements IBergerak, IServiceable {

    private String jenisSepeda;
    private int jumlahGear;
    private int ukuranRoda;

    public Sepeda(String merek, String model) {
        super(merek, model);
    }

    public String getJenisSepeda() {
        return jenisSepeda;
    }

    public void setJenisSepeda(String jenisSepeda) {
        this.jenisSepeda = jenisSepeda;
    }

    public int getJumlahGear() {
        return jumlahGear;
    }

    public void setJumlahGear(int jumlahGear) {
        this.jumlahGear = jumlahGear;
    }

    public int getUkuranRoda() {
        return ukuranRoda;
    }

    public void setUkuranRoda(int ukuranRoda) {
        this.ukuranRoda = ukuranRoda;
    }

    @Override
    public double hitungPajak() {
        return 0;
    }

    @Override
    public String getTipeKendaraan() {
        return "Roda dua";
    }

    @Override
    public boolean mulai() {
        System.out.println("Sepeda " + model + " bergerak");
        return true;
    }

    @Override
    public boolean berhenti() {
        if(mulai()){
            System.out.println("Sepeda " + model + " berhenti");
        } else{
            System.out.println("Sepeda " + model + " tidak sedang bergerak");
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
        System.out.println("Sepeda " + model + " sedang diperiksa");
        return true;
    }

    @Override
    public void lakukanServis() {
        if(periksaKondisi()){
            System.out.println("Sepeda " + model + " sedang diservis");
        } else{
            System.out.println("Sepeda tidak dalam pemeriksaan");
        }
    }

    @Override
    public Date getWaktuServisBerikutnya() {
        LocalDate hariIni = LocalDate.now();
        LocalDate waktuServis = hariIni.plusDays(90);
        return Date.from(waktuServis.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    @Override
    public double hitungBiayaServis() {
        return 200_000;
    }
}
