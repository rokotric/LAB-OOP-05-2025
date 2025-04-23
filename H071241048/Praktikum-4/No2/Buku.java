package No2;

public class Buku {
    private String judul, durasi, pengarang, genre, sinopsis;
    
    public  Buku(){

    }
    public Buku(String judul,String durasi,String pengarang, String genre, String sinopsis) {
        this.judul = judul;
        this.durasi =durasi;
        this.pengarang = pengarang;
        this.genre = genre;
        this.sinopsis = sinopsis;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }


    void displayInfo(){
        System.out.println("\nJudul buku: "+ getJudul());
        System.out.println("Durasi Peminjaman: "+ getDurasi());
        System.out.println("Nama Pengarang: "+ getPengarang());
        System.out.println("Genre Buku: "+ getGenre());
        System.out.println("Sinopsis Buku: "+ getSinopsis());
    }
}
