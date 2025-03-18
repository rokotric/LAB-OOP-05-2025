class Alamat{
    String jalan, kota;
    
    String getAlamatStr(){
        return jalan+", "+kota;
    }
}
class Mahasiswa{
    String nama,nim;
    Alamat alamat = new Alamat();

    String getNama() {
        return nama;
    }
    String getNim() {
        return nim;
    }
    String getAlamat(){
        return alamat.getAlamatStr();
    }
}

public class TP2_4_H071201048 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Pallangga";
        alamat.kota = "Gowa";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Farhan Kebab";
        mahasiswa.nim = "H071241048";

        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}
