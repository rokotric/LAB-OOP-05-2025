package No2;

public class Main {
    public static void main(String[] args) {
        Buku buku = new Buku();
        buku.setDurasi("2 hari");
        buku.setGenre("Horor");
        buku.setJudul("Bumi");
        buku.setPengarang("Tere liye");
        buku.setSinopsis("Berkelana di dunia lain");

        buku.displayInfo();

        Buku buku1 = new Buku("Matahari","3 minggu", "tere liye","komedi","Berjalan jalan di matahari bos");
        buku1.displayInfo();

        SelfUtils.displaySelfData();
    }
}
