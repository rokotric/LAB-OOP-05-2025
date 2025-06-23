public class Senjata {
    private String nama;
    private int kekuatan;

    public Senjata() {
        this.nama = "pistol";
        this.kekuatan = 30;
    }

    public Senjata(String nama, int kekuatan) {
        this.nama = nama;
        this.kekuatan = kekuatan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getKekuatan() {
        return kekuatan;
    }

    public void setKekuatan(int kekuatan) {
        this.kekuatan = kekuatan;
    }

    public void serang() {
        System.out.println("Senjata " + nama + " menyerang dengan kekuatan " + kekuatan);
    }
}
