public class TP2_2_H071241080 {
        public static void main(String[] args) {
        Produk produk = new Produk("0001", "Roti Aoka", 0, 2000);
        Produk produk2 = new Produk("0002", "Roti coklat", 1, 2000);

        produk.tampilkanInfo();
        produk2.tampilkanInfo();

        if (produk.tersedia()) {
            System.out.println("Produk tersedia");
        } else {
            System.out.println("Produk habis");
        }

        if (produk2.tersedia()) {
            System.out.println("Produk tersedia");
        } else {
            System.out.println("Produk habis");
        }
    }

}


