package Tuprak_3;

public class Produk {
    String nama;
    double harga;
    int stok;

    public Produk() {
        this.nama = "Tidak diketahui";
        this.harga = 0.0;
        this.stok = 0;
    }

    public Produk(String nama, double harga, int stok) {
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampilkanInfo() {
        System.out.println("Produk: " + nama);
        System.out.println("Harga: Rp" + harga);
        System.out.println("Stok: " + stok);
    }

    public boolean kurangiStok(int jumlah) {
        if (stok >= jumlah) {
            stok -= jumlah;
            return true;
        } else {
            System.out.println("Stok tidak cukup untuk " + nama);
            return false;
        }
    }
}
