package Code.CostumClass;

import Code.Abstract.Kendaraan;
import Code.Interface.IBergerak;

import java.time.LocalDate;

public class PetePete extends Kendaraan implements IBergerak {
    String namaSupir;
    int kapasitasPenumpang = 10;
    int jumlahPenumpangSaatIni;
    int tarif;
    boolean sedangBeoperasi;

    public PetePete(String merek, String model) {
        super(merek, model);
    }

    public String getNamaSupir() {
        return namaSupir;
    }

    public void setNamaSupir(String namaSupir) {
        this.namaSupir = namaSupir;
    }

    public int getJumlahPenumpangSaatIni() {
        return jumlahPenumpangSaatIni;
    }

    public void setJumlahPenumpangSaatIni(int jumlahPenumpangSaatIni) {
        this.jumlahPenumpangSaatIni = jumlahPenumpangSaatIni;
    }

    public int getTarif() {
        return tarif;
    }

    public void setTarif(int tarif) {
        this.tarif = tarif;
    }

    public boolean isSedangBeoperasi() {
        return sedangBeoperasi;
    }

    public void setSedangBeoperasi(boolean sedangBeoperasi) {
        this.sedangBeoperasi = sedangBeoperasi;
    }

    public int getKapasitasPenumpang() {
        return kapasitasPenumpang;
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
        return "Roda empat";
    }

    @Override
    public boolean mulai() {
        System.out.println("Pete-pete " + model + " bergerak");
        return true;
    }

    @Override
    public boolean berhenti() {
        if(mulai()){
            System.out.println("Pete-pete " + model + " berhenti");
        } else{
            System.out.println("Pete-pete " + model + " tidak sedang bergerak");
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
}
