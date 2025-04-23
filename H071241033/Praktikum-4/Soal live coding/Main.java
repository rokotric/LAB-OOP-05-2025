public class Main {
    public static void main(String[] args) {
        Buku buku = new Buku();

        buku.setJudul("Attack On Titan");
        buku.setDurasi(60);
        buku.setPengarang("Hanif");
        buku.setGenre("Action");
        buku.setSinopsis("XXXXXXXXXXXXXXXXXXXXXXXXXX\n");

        buku.displayInfo();

        Buku buku2 = new Buku("Pengepungan di Bukit Duri", 120, "Joko", "Action", "xxxxxxxxxxxxxxxxxxxxxxxxx");
        System.out.println("Judul: " + buku2.getJudul());
        System.out.println("Durasi: " + buku2.getPengarang());
        System.out.println("Pengarang: " + buku2.getPengarang());
        System.out.println("Genre: " + buku2.getGenre());
        System.out.println("Sinopsis: " + buku2.getSinopsis() + "\n");

        SelfUtils.displaySelfData();
    }
}