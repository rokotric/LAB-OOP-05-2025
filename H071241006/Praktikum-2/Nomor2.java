public class Nomor2 {
    String id;
    String nama;
    int stok;
    double harga;

    public void tampilkanData() {
        System.out.println("ID Produk   : " + id);
        System.out.println("Nama Produk : " + nama);
        System.out.println("Stok        : " + stok);
        System.out.println("Harga       : Rp " + harga);
    }

    public void cekKetersediaan() {
        if (stok > 0) {
            System.out.println("Produk tersedia di stok.");
        } else {
            System.out.println("Produk habis/tidak tersedia.");
        }
    }

    public static void main(String[] args) {
        Nomor2 produk1 = new Nomor2();
        Nomor2 produk2 = new Nomor2();


        produk1.id = "P001";
        produk1.nama = "Teh Botol";
        produk1.stok = 5;
        produk1.harga = 4000;

        produk2.id = "P002";
        produk2.nama = "Teh kotak";
        produk2.stok = 3;
        produk2.harga = 5000;

        produk1.tampilkanData();
        produk1.cekKetersediaan();
        produk2.tampilkanData();
        produk2.cekKetersediaan();


    }
}
