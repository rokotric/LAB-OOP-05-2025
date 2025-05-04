package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>();
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Memanggil method runApp();
        runApp();
    }

    private static void runApp() {
        // Menu Utama Aplikasi
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        // Menginput pilihan menu
        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                // Membuka Halaman Login
                showLoginMenu();
                break;
            case 2:
                // Membuka Halaman Register
                showRegisterMenu();
            default:
                // Mengulang Pemanggilan Menu Utama
                runApp();
        }
    }

    private static void showLoginMenu() {
        // Halaman Login
        System.out.println("-------------------------");
        System.out.println("Login");
        // Menginput Username dan Menyimpannya di attribute username;
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.next();
        // Membuat variabel userIndex yang mana nanti akan menampung index dari user
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            /*
             * TODO
             * Buatlah sebuah perkondisian (IF) yang akan
             * Mengecek apakah user index ke i dari listUser memiliki username yang sama
             * dengan username yang
             * diinput.
             * Jika ada ganti userIndex dengan Index dari User Tersebut, kemudian hentikan
             * perulangan
             */
            if (username != null && username.equals(listUser.get(i).getUsername())) {
                userIndex = i;
                break;
            }
        }
        // Saat userIndex tidak sama dengan -1 atau userIndexnya ditemukan
        if (userIndex != -1) {
            // Menginput Password
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();
            
            /*
             * TODO
             * Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */
            boolean isPasswordMatch = false;
            if (password != null && password.equals(listUser.get(userIndex).getPassword())) {
                isPasswordMatch = true;
            }

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                /*
                 * TODO
                 * panggil method showDetailUser dan kirimkan data Profile User yang login
                 */
                showDetailUser(listUser.get(userIndex).getProfile());
                System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");
            }
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password (diperbaiki✅)
        String username;
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
                continue;
            }
            boolean usernameExists = false;
            for (User u : listUser) {
                if (u.getUsername().equals(username)) {
                    usernameExists = true;
                    break;
                }
            }
            if (usernameExists) {
                System.out.println("Username sudah digunakan. Coba lagi!");
            } else {
                break;
            }
        }
    
        String password;
        while (true) {
            System.out.println("Password");
            System.out.print("> ");
            password = sc.nextLine();

            if (password.isEmpty()) {
                System.out.println("Password tidak boleh kosong!");
            } else if (password.length() < 8) {
                System.out.println("Password minimal 8 karakter!");
            } else {
                break;
            }
        }
        /*
         * TODO
         * Buatlah atau Instance objek User baru, dan tambahkan
         * username dan password yang diinput sebelumnya secara langsung
         * saat instance User
         */
        User user = new User(username, password);

        /*
         * TODO
         * Buatlah atau Instance objek Profile baru
         */
        Profile profile = new Profile(  );

        // Menginput Data Profile
        // System.out.println("Nama Lengkap");
        // System.out.print("> ");
        // String fullName = sc.nextLine();
        // System.out.println("Umur");
        // System.out.print("> ");
        // int age = sc.nextInt();
        // sc.nextLine();
        // System.out.println("Hobby");
        // System.out.print("> ");
        // String hobby = sc.nextLine();\

        // (diperbaiki✅)
        String fullName;
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine().trim();
            if (fullName.isEmpty()) {
                System.out.println("Nama tidak boleh kosong!");
            } else {
                break;
            }
        }
    
        int age = -1;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            try {
                age = Integer.parseInt(sc.nextLine());
                if (age < 0) {
                    System.out.println("Umur harus positif!");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    
        String hobby;
        while (true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine().trim();
            if (hobby.isEmpty()) {
                System.out.println("Hobi tidak boleh kosong!");
            } else {
                break;
            }
        }

        /*
         * TODO
         * Berikan nilai fullName, age, dan hobby ke objek profile yang telah
         * di Instance sebelumnya. Nilai ini diperoleh dari data profile yang
         * diinput sebelumnya
         */
        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);


        /*
         * TODO
         * Berikan nilai nickName ke objek profile,
         * Nilai ini diperoleh menggunakan static method yang dibuat di class
         * StringUtils, dengan mengirimkan fullName yang diinput sebelumnya
         */
        profile.setNickName(StringUtils.generateNickName(fullName));
        user.setProfile(profile);

        // Menambahkan user yang dibuat ke list user
        listUser.add(user);
        // Menambahkan profile user yang dibuat ke list profile
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        /*
         * TODO *
         * Tampilkan semua data profile user yang login
         */
        System.out.println("\n====================");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("====================");
        System.out.println("Nama Lengkap: " + profile.getFullName());
        System.out.println("Nama Panggilan: " + profile.getNickName());
        System.out.println("Umur: " + profile.getAge());
        System.out.println("Hobi: " + profile.getHobby());
    }
}