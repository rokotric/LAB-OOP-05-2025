public class Main {
    public static void main(String[] args) {
        // Membuat objek Mobil
        Truk truk1 = new Truk("Toyota", "Avanza");
    
        truk1.setKapasitasMuatan(10);
        truk1.setJumlahRoda(4);
        truk1.setTahunProduksi(2022);
        truk1.setWarna("Hitam");
        truk1.setKecepatan(5); 
        // default sebelum mulai

        // Menampilkan informasi dari getter
        System.out.println("=== INFORMASI MOBIL ===");
        System.out.println("Merek           : " + truk1.getMerek());
        System.out.println("Model           : " + truk1.getModel());
        System.out.println("Tahun Produksi  : " + truk1.getTahunProduksi());
        System.out.println("Warna           : " + truk1.getWarna());
        
        System.out.println("\n=== PERILAKU MOBIL ===");
        System.out.println("Mulai?          : " + truk1.mulai());
        System.out.println("Kecepatan       : " + truk1.getKecepatan() + " km/jam");
        System.out.println("Berhenti?       : " + truk1.berhenti());
        System.out.println("Kecepatan Setelah Berhenti: " + truk1.getKecepatan() + " km/jam");

        System.out.println("\n=== SERVIS MOBIL ===");
        System.out.println("Kondisi Baik?   : " + truk1.periksaKondisi());
        truk1.lakukanServis();
        System.out.println("Waktu Servis Berikutnya : " + truk1.getWaktuServisBerikutnya());
        System.out.println("Biaya Servis    : Rp" + truk1.hitungBiayaServis());

        System.out.println("\n=== LAINNYA ===");
        System.out.println("Pajak           : Rp" + (truk1.hitungPajak()));
        System.out.println("Tipe Kendaraan  : " + truk1.getTipeKendaraan());
    }
}   



