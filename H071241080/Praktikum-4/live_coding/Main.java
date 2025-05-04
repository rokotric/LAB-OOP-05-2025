package live_coding;

public class Main {
    public static void main(String[] args) {
        Buku buku01 = new Buku();

        buku01.setJudul("Enkapsulasi Java");
        buku01.setDurasi(60);
        buku01.setPengarang("Hanifah");
        buku01.setGenre("edukasi");
        buku01.setSinopsis("buku yang mempelajari tentang enkapsulasi di java");

        buku01.displayInfo();

        System.out.println();

        Buku buku02 = new Buku("Elsa", 65, "Frozen", "misteri", "cerita kehidupan kerajaan elsa");

        System.out.println("Judul "+ buku02.getJudul());
        System.out.println("Durasi "+ buku02.getDurasi() + "menit");
        System.out.println("Pengarang "+ buku02.getPengarang());
        System.out.println("Genre "+ buku02.getGenre());
        System.out.println("Sinopsis "+ buku02.getSinopsis());

        System.out.println();

        SelfUtils.displaySelfData();
    }
}