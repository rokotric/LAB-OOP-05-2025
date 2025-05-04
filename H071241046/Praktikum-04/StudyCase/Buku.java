/**
 * Kerjakan Step by Step dengan menerapkan konsep encapsulation dan di kerjakan di depan asisten
 * 1. Buatlah sebuah kelas bernama Buku.
 * 2. Tambahkan atribut (judul, durasi, pengarang, genre, sinopsis) pada kelas Buku.
 * 3. Buat kelas Main dan tambahkan sebuah method main ke dalamnya.
 * 4. Buat sebuah instance (objek) Buku di dalam method main pada kelas Main dengan menggunakan constructor yang kosong.
 * 5. Gunakan method setter untuk memberikan nilai ke semua atribut yang ada di kelas Buku.
 * 6. Tambahkan behavior displayInfo() pada kelas Buku yang akan menampilkan semua informasi nilai atribut di console.
 * 7. Panggil method displayInfo() setelah method setter pada method main.
 * 8. Buatlah sebuah instance objek Buku kedua, setelah method displayInfo(), dimana di dalam constructor-nya semua atribut di kelas Buku langsung diberikan nilai.
 * 9. Tampilkan semua informasi nilai atribut pada objek Buku kedua menggunakan method getter.
 * 10. Buatlah sebuah class bernama SelfUtils.java.
 * 11. Tambahkan sebuah method static bernama displaySelfData() di dalam kelas SelfUtils.java. Di dalam method tersebut, tampilkan nama dan NIM Anda di console menggunakan sysout.
 * 12. Panggil method SelfUtils.displaySelfData() di bagian paling bawah method main pada kelas Main.
 *
 */

package login_app.StudyCase;


public class Buku {
    String judul;
    String durasi;
    String pengarang;
    String genre;
    String sinopsis;

    public Buku(String judul, String durasi, String pengarang, String genre, String sinopsis) {
        this.judul = judul;
        this.durasi = durasi;
        this.pengarang = pengarang;
        this.genre = genre;
        this.sinopsis = sinopsis;
    }

    public Buku() {
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public void displayInfo(){
        System.out.println("judul : " + judul );
        System.out.println("durasi : " + durasi );
        System.out.println("pengarang : " + pengarang );
        System.out.println("genre : " + genre );
        System.out.println("sinopsis : " + sinopsis );
    }

    public static void main(String[] args) {

        Buku buku01 = new Buku();

        buku01.setJudul("Ayah");
        buku01.setDurasi("1 jam");
        buku01.setPengarang("Andre Hirata");
        buku01.setGenre("Drama");
        buku01.setSinopsis("Dara ayah dan anaknya");

        buku01.displayInfo();



        Buku buku02 = new Buku("1001 doda besar ","2 jam", "Admin", "Tragedi", "sembarang");

        buku02.displayInfo();


        SelfUtils mahassiwa = new SelfUtils();
        mahassiwa.selfDisplayInfo();
    }


}
