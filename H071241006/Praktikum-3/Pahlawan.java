public class Pahlawan {
    private String nama;
    private int kesehatan;
    private Senjata senjata;

    public Pahlawan() {
        this.nama = "Pahlawan";
        this.kesehatan = 100;
        this.senjata = new Senjata(); 
    }

    public Pahlawan(String nama, int kesehatan, Senjata senjata) {
        this.nama = nama;
        this.kesehatan = kesehatan;
        this.senjata = senjata;
    }

    public void serang(Pahlawan musuh) {
        System.out.println(this.nama + " menyerang " + musuh.nama);
        this.senjata.serang();
        musuh.terimaSerangan(this.senjata.getKekuatan());
    }

    public void terimaSerangan(int kekuatan) {
        this.kesehatan -= kekuatan;
        if (this.kesehatan <= 0) {
            this.kesehatan = 0;
            System.out.println(this.nama + " telah kalah!");
        } else {
            System.out.println(this.nama + " terserang! Kesehatan sekarang: " + this.kesehatan);
        }
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public Senjata getSenjata() {
        return senjata;
    }

    public void setSenjata(Senjata senjata) {
        this.senjata = senjata;
    }
}
