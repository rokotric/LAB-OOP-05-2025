class Product {

    String nama;
    int ID;
    double harga;
    int stok;

    Product(String nama, int ID, double harga, int stok) {
        this.nama = nama;
        this.ID = ID;
        this.harga = harga;
        this.stok = stok <= 0 ? 0 : stok;
    }

    String getName() {
        return nama;
    }

    int getID() {
        return ID;
    }


    double getHarga() {
        return harga;
    }

    String formatHarga(double harga) {
        String fHarga = String.format("%,.0f", harga);
        return fHarga.replace(",", ".");

    }

    int getStok() {
        return stok;
    }

    boolean isTersedia() {
        return stok > 0;
    }

    void infoProduk() {
        System.out.println("========================================");
        System.out.println("Nama Produk  : " + nama);
        System.out.println("ID Produk    : " + ID);
        System.out.println("Harga Produk : " + formatHarga(harga));
        System.out.println("Stock Produk : " + stok);
        System.out.println("========================================");
        
        if(isTersedia()) {
            System.out.println(stok + " STOK PRODUK TERSEDIA!");
        } else {
            System.out.println("STOK PRODUK TIDAK TERSEDIA!");
        }
        System.out.println("========================================");

    }
}

public class TP2_2 {

    public static void main(String[] args) {
        
        Product laptop = new Product("Asus Vivobook",2, 91000000, -1);
        Product mouse = new Product("Mouse",3, 100000, 2);

        laptop.infoProduk();
        mouse.infoProduk();
    }
    
}
