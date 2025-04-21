class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat;
 
    String getName() {
        return nama;
    }
 
    String getNIM() {
        return nim;
    }

    String getAlamat() {
        return alamat.getAlamat();
    }


}

class Alamat {
    String jalan;
    String kota;

    String getAlamat() {
        return jalan + ", " + kota;
    }

}

public class TP2_4 {
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Kompleks BKN Jl. Karis 3 No. 1";
        alamat.kota = "Makassar";

        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "As'syiekril Fikryan Sarda";
        mahasiswa.nim = "H071241083";

        System.out.println("=======================================");
        System.out.println("Nama   : " + mahasiswa.getName());
        System.out.println("NIM    : " + mahasiswa.getNIM());
        System.out.println("Alamat : " + mahasiswa.getAlamat());
        System.out.println("=======================================");
    }
    
}