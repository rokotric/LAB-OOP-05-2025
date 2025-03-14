class Gudang{
    String id,nama;
    boolean stok;
    int harga;

    void cekProduk(){
        System.out.println("ID : "+id);
        System.out.println("Nama Produk : "+nama);
        System.out.print("Stok : ");
        System.out.println(stok ? "Ada" : "Tidak Ada");
        System.out.println("Harga : "+ harga);
    }

    String cekStok(){
        if(stok){
            return "Untuk produk "+nama+" tersedia";
        }else{
            return "Untuk produk "+nama+" sayangnya sedang tidak tersedia";
        }
    }
}


public class TP2_2_H071201048 {
    public static void main(String[] args) {
        Gudang makanan = new Gudang();
        makanan.id = "M01";
        makanan.nama = "indomie";
        makanan.stok = true;
        makanan.harga = 3000;

        makanan.cekProduk();
        System.out.println("\n"+makanan.cekStok()+"\n");

        Gudang minuman = new Gudang();
        minuman.id = "MN01";
        minuman.nama = "Kopi";
        minuman.stok = false;
        minuman.harga = 2000;
        
        minuman.cekProduk();
        System.out.println("\n"+minuman.cekStok());
    }
}
