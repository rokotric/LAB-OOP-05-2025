// public class SoldierPB {
//     String team;
//     int darah;
//     String nama;
//     SenjataPB senjata;
//     // Constructor default
//     public SoldierPB() {
//         this.team = "CT-Force";
//         this.darah = 100;
//         this.nama = "Didit";
//         this.senjata = new SenjataPB(); // Senjata default
//     }
//     // Constructor dengan parameter
//     public SoldierPB(String team, int darah, String nama, SenjataPB senjata) {
//         this.team = team;
//         this.darah = darah;
//         this.nama = nama;
//         this.senjata = senjata;
//     }
//     // Method 1: Menyerang prajurit lain
//     public void serang(SoldierPB musuh) {
//         musuh.darah -= this.senjata.damage;
//         if (musuh.darah < 0) musuh.darah = 0;
//         System.out.println(this.nama + " menyerang " + musuh.nama + 
//                            " dengan " + this.senjata.namasenjata + 
//                            " (Damage: " + this.senjata.damage + ")");
//         System.out.println("Darah " + musuh.nama + " sekarang: " + musuh.darah);
//     }
//     // Method 2: Menampilkan status prajurit
//     public void tampilkanStatus() {
//         System.out.println("===== STATUS PRAJURIT =====");
//         System.out.println("Nama  : " + this.nama);
//         System.out.println("Tim   : " + this.team);
//         System.out.println("Darah : " + this.darah);
//         System.out.println("Senjata: " + this.senjata.namasenjata + 
//                            " (Damage: " + this.senjata.damage + ")");
//         System.out.println("===========================\n");
//     }
// }
public class SoldierPB {
    String team;
    int darah;
    String nama;
    SenjataPB senjata;
    boolean bersembunyi = false;

    // Constructor default
    public SoldierPB() {
        this.team = "CT-Force";
        this.darah = 100;
        this.nama = "Didit";
        this.senjata = new SenjataPB(); // Senjata default
    }

    // Constructor dengan parameter
    public SoldierPB(String team, int darah, String nama, SenjataPB senjata) {
        this.team = team;
        this.darah = darah;
        this.nama = nama;
        this.senjata = senjata;
    }

    // Method 1: Menyerang prajurit lain
    public void serang(SoldierPB musuh) {
        if (this.senjata.peluru <= 0) {
            System.out.println(this.nama + " kehabisan peluru! Harus reload dulu.");
            return;
        }

        this.senjata.peluru--;

        if (musuh.bersembunyi) {
            System.out.println(musuh.nama + " sedang bersembunyi! Serangan gagal.");
        } else {
            musuh.darah -= this.senjata.damage;
            if (musuh.darah < 0) musuh.darah = 0;

            System.out.println(this.nama + " menyerang " + musuh.nama +
                " dengan " + this.senjata.namasenjata +
                " (Damage: " + this.senjata.damage + ")");
            System.out.println("Darah " + musuh.nama + " sekarang: " + musuh.darah);
        }
    }

    // Method 2: Menampilkan status prajurit
    public void tampilkanStatus() {
        System.out.println("===== STATUS PRAJURIT =====");
        System.out.println("Nama   : " + this.nama);
        System.out.println("Tim    : " + this.team);
        System.out.println("Darah  : " + this.darah);
        System.out.println("Senjata: " + this.senjata.namasenjata +
            " (Damage: " + this.senjata.damage + ", Peluru: " + this.senjata.peluru + ")");
        System.out.println("Status Sembunyi: " + (this.bersembunyi ? "Ya" : "Tidak"));
        System.out.println("===========================\n");
    }

    // Method 3: Ganti senjata
    public void gantiSenjata(SenjataPB senjataBaru) {
        this.senjata = senjataBaru;
        System.out.println(this.nama + " mengganti senjata menjadi " + senjataBaru.namasenjata);
    }

    // Method 4: Reload peluru
    public void reload() {
        this.senjata.peluru = this.senjata.maxPeluru;
        System.out.println(this.nama + " sedang reload... Peluru penuh kembali.");
    }

    // Method 5: Bersembunyi
    public void sembunyi() {
        this.bersembunyi = true;
        System.out.println(this.nama + " sedang bersembunyi!");
    }

    // Method 6: Keluar dari persembunyian
    public void keluarSembunyi() {
        this.bersembunyi = false;
        System.out.println(this.nama + " keluar dari tempat persembunyian!");
    }

    // Method 7: Gunakan medkit (menambah darah)
    public void gunakanMedkit() {
        if (this.darah >= 100) {
            System.out.println(this.nama + " sudah dalam kondisi maksimal.");
            return;
        }

        int heal = 30;
        this.darah += heal;
        if (this.darah > 100) this.darah = 100;

        System.out.println(this.nama + " menggunakan medkit. Darah bertambah " + heal + ". Total: " + this.darah);
    }

    // Method 8: Pindah posisi
    public void pindahPosisi(String lokasi) {
        System.out.println(this.nama + " berpindah ke posisi: " + lokasi);
    }
}
