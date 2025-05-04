public class TP2_4_H071241080 {
    public static class Alamat {
        String jalan;
        String kota;
    
        public String toString() {
            return jalan + ", " + kota;
        }
    }
    
    public static class Mahasiswa {
        String nama;
        String nim;
        Alamat alamat;
    
        String getNama() {
            return nama;
        }
    
        String getNim() {
            return nim;
        }
    
        String getAlamat() {
            return alamat.toString();
        }
    }
    
    public static void main(String[] args) {
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalanrea Indah";
        alamat.kota = "Makassar";
    
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Hanifah";
        mahasiswa.nim = "H071241080";
    
        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}

