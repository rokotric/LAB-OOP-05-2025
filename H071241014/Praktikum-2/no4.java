// Kelas Alamat
class Alamat {
    String jalan;
    String kota;

    // Metode untuk mendapatkan alamat dalam satu string
    public String getAlamat() {
        return jalan + ", " + kota;
    }
}

// Kelas Mahasiswa
class Mahasiswa {
    String nama;
    String nim;
    Alamat alamat;

    // Metode untuk mendapatkan nama
    public String getNama() {
        return nama;
    }

    // Metode untuk mendapatkan NIM
    public String getNim() {
        return nim;
    } 
  
    // Metode untuk mendapatkan alamat
    public String getAlamat() {
        return alamat.getAlamat();
    }
}

// Kelas Main untuk menjalankan program
public class no4 {
    public static void main(String[] args) {
        // Membuat objek alamat
        Alamat alamat = new Alamat();
        alamat.jalan = "Tamalarea Indah";
        alamat.kota = "Makassar";

        // Membuat objek mahasiswa
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Farhan";
        mahasiswa.nim = "H071231025";

        // Menampilkan output
        System.out.println("Nama: " + mahasiswa.getNama());
        System.out.println("Nim: " + mahasiswa.getNim());
        System.out.println("Alamat: " + mahasiswa.getAlamat());
    }
}