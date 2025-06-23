import java.util.Date;

public interface Iserviceable {
    boolean periksaKondisi();
    void lakukanServis();
    Date getWaktuServisBerikutnya();
    double hitungBiayaServis();

}