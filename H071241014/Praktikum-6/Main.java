public class Main {
    public static void main(String[] args) {
        
        Bajaj b1 = new Bajaj("suzuki","daffa");
        

        b1.setJumlahPenumpang(8);
        b1.mulai();
        b1.berhenti();
        b1.setKecepatan(100);
        b1.setTahunProduksi(2009);
        b1.hitungPajak();
        
        
        System.out.println("Jumlah Penumpang     : " + b1.getJumlahPenumpang());
        System.out.println("Status Saat Mulai    : " + b1.mulai());
        System.out.println("Status Saat Berhenti : " + b1.berhenti());
        System.out.println("Kecepatan Bajaj      : " + b1.getKecepatan() + " km/jam");
        System.out.println("Tahun Produksi       : " + b1.getTahunProduksi());
        System.out.println("Pajak Kendaraan      : Rp" + b1.hitungPajak());
        System.out.println("Tipe Kendaraan       : " + b1.getTipeKendaraan());





    }

    
}