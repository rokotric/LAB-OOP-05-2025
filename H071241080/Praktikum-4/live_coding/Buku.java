package live_coding;

public class Buku {
    private String judul;
    private int durasi;
    private String pengarang;
    private String genre;
    private String sinopsis;
    
    public String getJudul() {
        return judul;
    }
    public int getDurasi() {
        return durasi;
    }
    public String getPengarang() {
        return pengarang;
    }
    public String getGenre() {
        return genre;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setDurasi(int durasi) {
        this.durasi = durasi;
    }
    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    
    public Buku() {}
    
    public Buku(String judul, int durasi, String pengarang, String genre, String sinopsis){
        this.judul = judul;
        this.durasi = durasi;
        this.pengarang = pengarang;
        this.genre = genre;
        this.sinopsis = sinopsis;
    }

    public void displayInfo() {
        System.out.println("Judul: " + judul);
        System.out.println("Durasi: " + durasi + " menit");
        System.out.println("Pengarang: " + pengarang);
        System.out.println("Genre: " + genre);
        System.out.println("Sinopsis: " + sinopsis);
    }
}