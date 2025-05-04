// public class SenjataPB {
//     String namasenjata;
//     int damage;

//     // Constructor default
//     public SenjataPB() {
//         this.namasenjata = "Kriss S.V";
//         this.damage = 15;
//     }
//     // Constructor dengan parameter
//     public SenjataPB(String namasenjata, int damage) {
//         this.namasenjata = namasenjata;
//         this.damage =damage;
//     }
// }
public class SenjataPB {
    String namasenjata;
    int damage;
    int peluru;
    int maxPeluru;

    public SenjataPB() {
        this.namasenjata = "Pistol";
        this.damage = 10;
        this.maxPeluru = 12;
        this.peluru = maxPeluru;
    }

    public SenjataPB(String namasenjata, int damage, int maxPeluru) {
        this.namasenjata = namasenjata;
        this.damage = damage;
        this.maxPeluru = maxPeluru;
        this.peluru = maxPeluru;
    }
}
