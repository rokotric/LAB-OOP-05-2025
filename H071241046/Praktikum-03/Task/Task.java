package Task;

public class Task {
    private String deskripsi;
    private boolean selesai;
    private String kategori;

    public Task(String deskripsi, String kategori) {
        this.deskripsi = deskripsi;
        this.kategori = kategori;
        this.selesai = false;
    }

    public void selesaikan() {
        this.selesai = true;
    }

    public boolean isSelesai() {
        return selesai;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public String toString() {
        return deskripsi + " [" + kategori + "] - " + (selesai ? "Selesai" : "Belum selesai");
    }
}

