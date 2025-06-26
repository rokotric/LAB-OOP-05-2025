// Import library untuk input dan penanganan kesalahan input
import java.util.InputMismatchException;
import java.util.Scanner;

// Kelas utama program
public class Main {
    public static void main(String[] args) {

        // === INISIALISASI OBJEK DAN VARIABEL ===
        Scanner sc = new Scanner(System.in);        // Untuk membaca input dari pengguna
        Library lib = new Library();                // Objek perpustakaan yang menyimpan item dan anggota
        int itemCounter = 1, memberCounter = 1;     // Untuk memberi ID unik pada item dan anggota

        // === MENU UTAMA BERULANG (LOOP TANPA HENTI) ===
        while (true) {
            // Tampilkan daftar menu
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih opsi: ");

            int opsi;
            try {
                opsi = sc.nextInt();  // Membaca opsi menu
                sc.nextLine();        // Mengonsumsi newline
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                sc.nextLine(); // Bersihkan buffer
                continue;      // Ulang kembali ke menu
            }

            // === PENGOLAHAN OPSI MENU ===
            try {
                switch (opsi) {

                    // === MENU 1: Tambah Item (Buku atau DVD) ===
                    case 1 -> {
                        System.out.print("Jenis item (1: Buku, 2: DVD): ");
                        int jenis = sc.nextInt(); sc.nextLine(); // Ambil jenis item
                        
                        if (jenis == 1) {
                            // Input data buku
                            System.out.print("Judul: ");
                            String judul = sc.nextLine();
                            System.out.print("Penulis: ");
                            String penulis = sc.nextLine();

                            // Tambah ke perpustakaan
                            lib.addItem(new Book(judul, itemCounter++, penulis));
                            System.out.println("Buku berhasil ditambahkan.");
                        } else if (jenis == 2) {
                            // Input data DVD
                            System.out.print("Judul: ");
                            String judul = sc.nextLine();
                            System.out.print("Durasi (menit): ");
                            int durasi = sc.nextInt(); sc.nextLine();

                            // Tambah ke perpustakaan
                            lib.addItem(new DVD(judul, itemCounter++, durasi));
                            System.out.println("DVD berhasil ditambahkan.");
                        } else {
                            System.out.println("Jenis item tidak dikenal.");
                        }
                    }

                    // === MENU 2: Tambah Anggota Baru ===
                    case 2 -> {
                        System.out.print("Nama Anggota: ");
                        String nama = sc.nextLine(); // Input nama
                        System.out.println(lib.addMember(new Member(nama, memberCounter++)));
                    }

                    // === MENU 3: Pinjam Item ===
                    case 3 -> {
                        try {
                            // Input data peminjaman
                            System.out.print("ID Item: ");
                            int idItem = sc.nextInt();
                            System.out.print("ID Anggota: ");
                            int idAnggota = sc.nextInt();
                            System.out.print("Jumlah hari peminjaman: ");
                            int hari = sc.nextInt(); sc.nextLine();

                            // Cari item dan anggota
                            LibraryItem item = lib.findItemById(idItem);
                            Member m = lib.findMemberById(idAnggota);

                            if (item == null) {
                                System.out.println("Item dengan ID tersebut tidak ditemukan.");
                                continue;
                            }
                            if (m == null) {
                                System.out.println("Anggota dengan ID tersebut tidak ditemukan.");
                                continue;
                            }

                            // Proses peminjaman
                            String hasil = m.borrow(item, hari);
                            lib.getLogger().logActivity(item.getDescription() + " dipinjam oleh " + m.getName());
                            System.out.println(hasil);
                        } catch (InputMismatchException e) {
                            System.out.println("Input tidak valid. Harap masukkan angka.");
                            sc.nextLine(); // Bersihkan buffer
                        }
                    }

                    // === MENU 4: Kembalikan Item ===
                    case 4 -> {
                        try {
                            // Input data pengembalian
                            System.out.print("ID Item: ");
                            int idItem = sc.nextInt();
                            System.out.print("ID Anggota: ");
                            int idAnggota = sc.nextInt();
                            System.out.print("Jumlah hari keterlambatan: ");
                            int terlambat = sc.nextInt(); sc.nextLine();

                            // Cari item dan anggota
                            LibraryItem item = lib.findItemById(idItem);
                            Member m = lib.findMemberById(idAnggota);

                            if (item == null) {
                                System.out.println("Item dengan ID tersebut tidak ditemukan.");
                                continue;
                            }
                            if (m == null) {
                                System.out.println("Anggota dengan ID tersebut tidak ditemukan.");
                                continue;
                            }

                            // Proses pengembalian
                            String hasil = m.returnItem(item, terlambat);
                            lib.getLogger().logActivity(item.getDescription() + " dikembalikan oleh " + m.getName());
                            System.out.println(hasil);
                        } catch (InputMismatchException e) {
                            System.out.println("Input tidak valid. Harap masukkan angka.");
                            sc.nextLine();
                        }
                    }

                    // === MENU 5: Tampilkan Status Perpustakaan ===
                    case 5 -> {
                        System.out.println(lib.getLibraryStatus());
                    }

                    // === MENU 6: Tampilkan Log Aktivitas ===
                    case 6 -> {
                        System.out.println(lib.getLogger().getLogs());
                    }

                    // === MENU 7: Tampilkan Item yang Dipinjam Anggota ===
                    case 7 -> {
                        try {
                            System.out.print("ID Anggota: ");
                            int idAnggota = sc.nextInt(); sc.nextLine();

                            Member m = lib.findMemberById(idAnggota);
                            if (m == null) {
                                System.out.println("Anggota dengan ID tersebut tidak ditemukan.");
                            } else {
                                System.out.println(m.getBorrowedItems());
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Input tidak valid. Harap masukkan angka.");
                            sc.nextLine();
                        }
                    }

                    // === MENU 8: Keluar dari Program ===
                    case 8 -> {
                        System.out.println("Keluar dari sistem.");
                        return; // Keluar dari program
                    }

                    // === OPSI TIDAK VALID ===
                    default -> System.out.println("Opsi tidak valid. Silakan pilih antara 1 hingga 8.");
                }

            // === PENANGANAN KESALAHAN UMUM ===
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            }
        }
    }
}
