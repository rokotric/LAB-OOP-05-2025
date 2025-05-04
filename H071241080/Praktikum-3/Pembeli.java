package Tuprak_3;

public class Pembeli {
    String nama;
    Produk produkDibeli; // dari class Produk
    int jumlahBeli;

    public Pembeli() {
        this.nama = "Pelanggan";
        this.produkDibeli = null;
        this.jumlahBeli = 0;
    }

    public Pembeli(String nama, Produk produk, int jumlah) {
        this.nama = nama;
        this.produkDibeli = produk;
        this.jumlahBeli = jumlah;
    }

    public void lakukanPembelian() {
        System.out.println(nama + " ingin membeli " + jumlahBeli + " " + produkDibeli.nama);
        if (produkDibeli.kurangiStok(jumlahBeli)) {
            double total = jumlahBeli * produkDibeli.harga;
            System.out.println("Transaksi berhasil. Total: Rp" + total);
        } else {
            System.out.println("Transaksi gagal.");
        }
    }

    public void bandingkanBelanja(Pembeli lain) {
        double total1 = this.jumlahBeli * this.produkDibeli.harga;
        double total2 = lain.jumlahBeli * lain.produkDibeli.harga;

        if (total1 > total2) {
            System.out.println(this.nama + " belanja lebih mahal dari " + lain.nama);
        } else if (total1 < total2) {
            System.out.println(this.nama + " belanja lebih murah dari " + lain.nama);
        } else {
            System.out.println(this.nama + " dan " + lain.nama + " belanja dengan total yang sama.");
        }
    }
}
