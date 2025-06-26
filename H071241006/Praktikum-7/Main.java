import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int itemCounter = 1;
        int memberCounter = 1;

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
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine(); // konsumsi newline

            try {
                switch (pilihan) {
                    case 1 -> {
                        System.out.print("Jenis item (1: Buku, 2: DVD): ");
                        int jenis = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Judul: ");
                        String title = scanner.nextLine();
                        if (jenis == 1) {
                            System.out.print("ID Item: ");
                            int inputItemId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Penulis: ");
                            String author = scanner.nextLine();
                            Book book = new Book(title, itemCounter, author);
                            library.addItem(book);
                            System.out.println("Judul: " + title);
                            System.out.println("ID Item: " + itemCounter);
                            System.out.println("Penulis: " + author);
                        } else if (jenis == 2) {
                            System.out.println("ID Item: ");
                            int inputItemId = scanner.nextInt();
                            scanner.nextLine();
                            System.out.print("Durasi (menit): ");
                            int duration = scanner.nextInt();
                            scanner.nextLine();
                            DVD dvd = new DVD(title, itemCounter, duration);
                            library.addItem(dvd);
                            System.out.println("Judul: " + title);
                            System.out.println("ID Item: " + itemCounter);
                            System.out.println("Durasi: " + duration + " menit");
                        } else {
                            System.out.println("Jenis tidak valid.");
                            continue;
                        }
                        System.out.println("Item berhasil ditambahkan");
                        itemCounter++;
                    }
                    case 2 -> tambahAnggota(scanner, library, memberCounter++);
                    case 3 -> pinjamItem(scanner, library);
                    case 4 -> kembalikanItem(scanner, library);
                    case 5 -> System.out.println(library.getLibraryStatus());
                    case 6 -> {
    String logs = library.getAllLogs();
    if (logs.isBlank()) {
        System.out.println("Tidak ada log aktivitas");
    } else {
        System.out.println(logs);
    }
}

                    case 7 -> lihatPinjaman(scanner, library);
                    case 8 -> {
                        System.out.println("Keluar...");
                        return;
                    }
                    default -> System.out.println("Pilihan tidak valid.");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void tambahItem(Scanner scanner, Library library, int id) {
        System.out.print("Judul: ");
        String title = scanner.nextLine();
        System.out.print("Jenis (1 = Buku, 2 = DVD): ");
        int jenis = scanner.nextInt();
        scanner.nextLine();
        if (jenis == 1) {
            System.out.print("Author: ");
            String author = scanner.nextLine();
            library.addItem(new Book(title, id, author));
        } else if (jenis == 2) {
            System.out.print("Durasi (menit): ");
            int duration = scanner.nextInt();
            scanner.nextLine();
            library.addItem(new DVD(title, id, duration));
        } else {
            System.out.println("Jenis tidak valid.");
        }
    }

    private static void tambahAnggota(Scanner scanner, Library library, int Id) {
    System.out.print("Nama Anggota: ");
    String name = scanner.nextLine();

    System.out.print("ID Anggota: ");
    int id = scanner.nextInt();
    scanner.nextLine();

    library.addMember(new Member(name, id));
    System.out.println("Anggota berhasil ditambahkan:");
    System.out.println("Nama: " + name);
    System.out.println("ID: " + id);
}


    private static void pinjamItem(Scanner scanner, Library library) {
        System.out.print("ID Anggota: ");
        int memberId = scanner.nextInt();
        System.out.print("ID Item: ");
        int itemId = scanner.nextInt();
        System.out.print("Durasi pinjam (hari): ");
        int days = scanner.nextInt();
        scanner.nextLine();
        Member member = library.findMemberById(memberId);
        LibraryItem item = library.findById(itemId);
        String msg = member.borrow(item, days);
        library.getLogger().logActivity(item.getDescription() + " dipinjam oleh " + member.getName());
        System.out.println(msg);
    }

    private static void kembalikanItem(Scanner scanner, Library library) {
        System.out.print("ID Anggota: ");
        int memberId = scanner.nextInt();
        System.out.print("ID Item: ");
        int itemId = scanner.nextInt();
        System.out.print("Terlambat (hari): ");
        int late = scanner.nextInt();
        scanner.nextLine();
        Member member = library.findMemberById(memberId);
        LibraryItem item = library.findById(itemId);
        String msg = member.returnItem(item, late);
        library.getLogger().logActivity(item.getDescription() + " dikembalikan oleh " + member.getName());
        System.out.println(msg);
    }

    private static void lihatPinjaman(Scanner scanner, Library library) {
        System.out.print("ID Anggota: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Member member = library.findMemberById(id);
        System.out.println(member.getBorrowedItems());
    }
}
