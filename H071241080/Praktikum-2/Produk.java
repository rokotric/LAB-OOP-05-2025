public class Produk {
    String id;
    String nama;
    int stok;
    double harga;

    public Produk(String id, String nama, int stok, double harga) {
        this.id = id;
        this.nama = nama;
        this.stok = stok;
        this.harga = harga;
    }

    public String getId() {
        return id;
    }
    public String getNama() {
        return nama;
    }
    public int getStok() {
        return stok;
    }
    public double getHarga() {
        return harga;
    }

    public void tampilkanInfo() {
        System.out.println("ID Produk   : " + id);
        System.out.println("Nama Produk : " + nama);
        System.out.println("Stok        : " + stok);
        System.out.println("Harga       : Rp" + harga);
    }
    
    boolean tersedia() {
        return stok > 0;
    }

}
