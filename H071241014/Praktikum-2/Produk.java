public class Produk {
    private int idProduk;
    private String nama;
    private int stok;
    private double harga;

    // Konstruktor,adalah method khusus yang dipanggil saat objek dibuat
    public Produk(int idProduk, String nama, int stok, double harga) {
        this.idProduk = idProduk;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    // Method untuk menampilkan informasi produk
    public void tampilkanInfo() {
        System.out.println("ID: " + idProduk);
        System.out.println("Nama: " + nama);
        System.out.println("Stok: " + stok);
        System.out.println("Harga: Rp " + harga);
    }

    // Method untuk mengecek apakah produk tersedia di stok
    public boolean cekKetersediaan() {
        return stok > 0;
    }

    // Getter dan Setter (Opsional)
    public int getIdProduk() {
        return idProduk;
    }

    public void setIdProduk(int idProduk) {
        this.idProduk = idProduk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    // Contoh penggunaan
    public static void main(String[] args) {
        Produk produk1 = new Produk(101, "Laptop", 5, 7500000);
        produk1.tampilkanInfo();
        System.out.println("Tersedia di stok: " + produk1.cekKetersediaan());
    }
}