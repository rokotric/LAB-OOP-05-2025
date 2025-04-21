// public class Main {
//     public static void main(String[] args) {
//         SenjataPB senjata1 = new SenjataPB("AUG A3", 20);
//         SoldierPB didit = new SoldierPB("Free Rebels", 100, "Daffa", senjata1);

//         SoldierPB lawan = new SoldierPB(); // pakai constructor default

//         didit.tampilkanStatus();
//         lawan.tampilkanStatus();

//         didit.serang(lawan);

//         lawan.tampilkanStatus();
//     }
// }
public class Main {
    public static void main(String[] args) {
        // Membuat senjata
        SenjataPB ak47 = new SenjataPB("AK-47", 25, 30);
        SenjataPB p90 = new SenjataPB("P90", 20, 50);

        // Membuat dua prajurit
        SoldierPB prajurit1 = new SoldierPB("CT-Force", 100, "Rizky", ak47);
        SoldierPB prajurit2 = new SoldierPB("Free Rebels", 100, "Joko", p90);

        // Menampilkan status awal
        prajurit1.tampilkanStatus();
        prajurit2.tampilkanStatus();

        // Prajurit1 menyerang prajurit2
        prajurit1.serang(prajurit2);

        // Prajurit2 membalas dan menyerang balik
        prajurit2.serang(prajurit1);

        // Prajurit2 bersembunyi
        prajurit2.sembunyi();

        // Prajurit1 mencoba menyerang lagi (akan gagal karena musuh bersembunyi)
        prajurit1.serang(prajurit2);

        // Prajurit2 keluar dari persembunyian dan reload
        prajurit2.keluarSembunyi();
        prajurit2.reload();

        // Prajurit2 menggunakan medkit untuk menyembuhkan diri
        prajurit2.gunakanMedkit();

        // Prajurit1 berpindah posisi
        prajurit1.pindahPosisi("Tower Tengah");

        // Prajurit2 mengganti senjata
        SenjataPB sniper = new SenjataPB("AWP", 90, 5);
        prajurit2.gantiSenjata(sniper);

        // Menampilkan status akhir
        prajurit1.tampilkanStatus();
        prajurit2.tampilkanStatus();
    }
}
