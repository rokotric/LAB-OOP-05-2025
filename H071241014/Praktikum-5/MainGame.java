import java.util.Scanner;

public class MainGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero character = null;

        System.out.println("Selamat datang di Game Battle!");
        System.out.println("Pilih karakter Anda:");
        System.out.println("1. Pemanah (Archer)");
        System.out.println("2. Penyihir (Wizard)");
        System.out.println("3. Petarung (Fighter)");
        System.out.print("Pilihan: ");

        int pilihanKarakter = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Masukkan nama karakter: ");
        String nama = scanner.nextLine();

        switch (pilihanKarakter) {
            case 1:
                character = new Archer(nama, 20);
                break;
            case 2:
                character = new Wizard(nama, 25);
                break;
            case 3:
                character = new Fighter(nama, 30);
                break;
            default:
                System.out.println("Pilihan tidak valid. Keluar dari program.");
                scanner.close(); // Tambahkan penutupan scanner sebelum keluar
                System.exit(0);
        }

        int menu;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    if (character != null) { // Tambahkan pengecekan null untuk mencegah NullPointerException
                        character.attack();
                    }
                    break;
                case 2:
                    System.out.println("Terima kasih sudah bermain!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (menu != 2);

        scanner.close();
    }
}