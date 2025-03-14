public class Soal04 {

    public static void main(String[] args) {
        var alamat = new Alamat();
        alamat.jalan = "Jln. PK 7";
        alamat.kota = "Makassar";

        var mahasiswa = new Mahasiswa();
        mahasiswa.alamat = alamat;
        mahasiswa.nama = "Abdurrahaman Dzaky Safrullah";
        mahasiswa.NIM = "H071241046";

        System.out.println(mahasiswa.getNama());
        System.out.println(mahasiswa.getNIM());
        System.out.println(mahasiswa.getAlamat());

    }


    static class Alamat{
        static String jalan;
        static String kota;
        String getAlamat(){
            return jalan + ", " + kota;
        }
    }

    static class Mahasiswa{
        String nama;
        String NIM;
        Alamat alamat = new Alamat();


        public String getNama() {
            return nama;
        }

        public String getNIM() {
            return NIM;
        }

        public String getAlamat(){
            return new Alamat().getAlamat();
        }
    }

}
