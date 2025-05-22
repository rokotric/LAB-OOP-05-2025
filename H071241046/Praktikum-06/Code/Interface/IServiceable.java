package Code.Interface;

import java.util.Date;

public interface IServiceable {
    boolean periksaKondisi();
    void lakukanServis();
    Date getWaktuServisBerikutnya();
    double hitungBiayaServis();
}
