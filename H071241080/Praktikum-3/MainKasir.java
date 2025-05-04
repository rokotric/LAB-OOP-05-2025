package Tuprak_3;

public class MainKasir {
    public static void main(String[] args) {
        Produk indomie = new Produk("Indomie Goreng", 3500, 4);
        Produk telur = new Produk("Telur Ayam", 2500, 4);

        Pembeli budi = new Pembeli("Budi", indomie, 3);
        Pembeli rani = new Pembeli("Rani", telur, 4);

        budi.lakukanPembelian();
        System.out.println();
        rani.lakukanPembelian();
        System.out.println();

        budi.bandingkanBelanja(rani);
    }
}