import src.service.Library;
import src.model.*;
import src.service.LibraryLogger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.println("9. Hapus Log Aktivitas");
            System.out.print("Pilih menu: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            try {
                switch (choice) {
                    case 1:
                        addItemMenu(library, scanner);
                        break;
                    case 2:
                        addMemberMenu(library, scanner);
                        break;
                    case 3:
                        borrowItemMenu(library, scanner);
                        break;
                    case 4:
                        returnItemMenu(library, scanner);
                        break;
                    case 5:
                        System.out.println("\n" + library.getLibraryStatus());
                        break;
                    case 6:
                        System.out.println("\nLog Aktivitas:\n" + library.getAllLogs());
                        break;
                    case 7:
                        viewBorrowedItemsMenu(library, scanner);
                        break;
                    case 8:
                        System.out.println("Terima kasih!");
                        scanner.close();
                        return;
                    case 9:
                        LibraryLogger.clearLogs(); // tambahan
                        System.out.println("Log aktivitas berhasil dihapus");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private static void addItemMenu(Library library, Scanner scanner) {
        System.out.println("\n--- Tambah Item ---");
        System.out.print("Jenis (1 = Book, 2 = DVD): ");
        int type = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Judul: ");
        String title = scanner.nextLine();

        System.out.print("ID Item: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (library.isItemIdExists(id)) {
            System.out.println("ID item sudah digunakan");
            return;
        }

        if (type == 1) {
            System.out.print("Author: ");
            String author = scanner.nextLine();
            Book book = new Book(title, id, author);
            System.out.println(library.addItem(book));
        } else if (type == 2) {
            System.out.print("Durasi (menit): ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            DVD dvd = new DVD(title, id, duration);
            System.out.println(library.addItem(dvd));
        } else {
            System.out.println("Jenis tidak valid");
        }
    }

    private static void addMemberMenu(Library library, Scanner scanner) {
        System.out.println("\n--- Tambah Anggota ---");
        System.out.print("Nama: ");
        String name = scanner.nextLine();

        System.out.print("ID Member: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (library.isMemberIdExists(id)) {
            System.out.println("ID member sudah digunakan");
            return;
        }

        Member member = new Member(name, id);
        library.addMember(member);
        System.out.println("Member berhasil ditambahkan");
    }

    private static void borrowItemMenu(Library library, Scanner scanner) {
        System.out.println("\n--- Pinjam Item ---");
        System.out.print("ID Member: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID Item: ");
        int itemId = scanner.nextInt();

        System.out.print("Lama pinjam (hari): ");
        int days = scanner.nextInt();
        scanner.nextLine();

        System.out.println(library.borrowItem(memberId, itemId, days));
    }

    private static void returnItemMenu(Library library, Scanner scanner) {
        System.out.println("\n--- Kembalikan Item ---");
        System.out.print("ID Member: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("ID Item: ");
        int itemId = scanner.nextInt();

        System.out.print("Jumlah hari keterlambatan: ");
        int daysLate = scanner.nextInt();
        scanner.nextLine();

        System.out.println(library.returnItemLengkap(memberId, itemId, daysLate));
    }

    private static void viewBorrowedItemsMenu(Library library, Scanner scanner) {
        System.out.println("\n--- Item yang Dipinjam Anggota ---");
        System.out.print("ID Member: ");
        int memberId = scanner.nextInt();
        scanner.nextLine();

        Member member = library.findMemberById(memberId);
        System.out.println(member.getBorrowedItems());
    }
}