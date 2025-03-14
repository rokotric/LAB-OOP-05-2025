public class Soal02 {
    String nama;
    String ID;
    int harga;
    boolean stock;

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public void setStock(boolean stock) {
        this.stock = stock;
    }

    void cekProduk(){
        System.out.println("Info Barang");
        System.out.println("Nama : " + nama);
        System.out.println("ID : " + ID);
        System.out.println("Harga : Rp." + (String.format("%,d", harga)));
        System.out.println("Stock : " + stock);
    }

    String cekStock(){
        if(stock == true){
            return "Barang tersedia";
        } else{
            return "barang habis";
        }
    }

    public static void main(String[] args) {
        Soal02 pulpen = new Soal02();

        pulpen.setNama("Pulpen Snowman");
        pulpen.setID("12321");
        pulpen.setHarga(5000);
        pulpen.setStock(true);

        pulpen.cekProduk();

        System.out.println(pulpen.cekStock());
    }
}
