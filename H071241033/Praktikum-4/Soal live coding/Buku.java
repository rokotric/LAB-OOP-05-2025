public class Buku {
    String judul;
    int durasi;
    String pengarang;
    String genre;
    String sinopsis;

    public Buku() {
    }
    
    public Buku(String judul, int durasi, String pengarang, String genre, String sinopsis) {
        this.judul = judul;
        this.durasi = durasi;
        this.pengarang = pengarang;
        this.genre = genre;
        this.sinopsis = sinopsis;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }
    public String getJudul() {
        return this.judul;
    }

    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
    public int getDurasi() {
        return this.durasi;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
    public String getPengarang() {
        return this.pengarang;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String getGenre() {
        return this.genre;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getSinopsis() {
        return this.sinopsis;
    }

    public void displayInfo() {
        System.out.println("==== TAMPILKAN INFO ===");
        System.out.println("Judul: " + this.judul);
        System.out.println("Durasi: " + this.durasi);
        System.out.println("Pengarang: " + this.pengarang);
        System.out.println("Genre: " + this.genre);
        System.out.println("Sinopsis: " + this.sinopsis);
    }
}