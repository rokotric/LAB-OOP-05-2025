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
        System.out.println("3. Keluar"); // perbaikan-- no 5
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
                break;
            case 3:
                System.exit(0); //perbaikan-- no 5
            default:
                // Mengulang Pemanggilan Menu Utama
                System.out.println("Pilihan tidak valid!"); // perbaikan-- no 
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
        while(username.trim().isEmpty()) { //perbaikan-- no 2
            System.out.println("Username tidak boleh kosong!");
            System.out.print("> ");
            username = sc.next();
        }


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
            if (listUser.get(i).getUsername().equals(username)) {
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

            while(password.trim().isEmpty()) { //perbaikan--  no 2
                System.out.println("Password tidak boleh kosong!");
                System.out.print("> ");
                password = sc.next();
            }


            /*
             * TODO
             * Mengecek apakah password dari User yang login berdasarkan username
             * sama dengan password yang diinput sebelumnya, kemudian simpan
             * hasilnya di variabel isPasswordMatch
             */
            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            // Jika passwordnya sama maka berhasil login
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                /*
                 * TODO
                 * panggil method showDetailUser dan kirimkan data Profile User yang login
                 * 
                 */
                showDetailUser(listUserProfile.get(userIndex));

                runApp(); //perbaikan-- no 1
                //System.exit(0);
            } else {
                // saat password salah akan menampikan password salah
                System.out.println("Password Salah");

                showLoginMenu(); // perbaikan-- no 1
            }
        }else { //perbaikan-- no 1
            System.out.println("Username tidak ditemukan!");
            runApp();
        }

    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        // Menginput username dan password
        // System.out.println("Username");
        // System.out.print("> ");
        // String username = sc.nextLine();
        // System.out.println("Password");
        // System.out.print("> ");
        // String password = sc.nextLine();

        String username; //perbaikan-- no 2
        while(true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine().trim();
            
            // Validasi username tidak kosong
            if(username.isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
                continue;
            }
            
            // Validasi username belum digunakan
            boolean usernameExists = false; // perbaikan-- no 3
            for(User user : listUser) {
                if(user.getUsername().equals(username)) {
                    usernameExists = true;
                    break;
                }
            }
            
            if(usernameExists) {
                System.out.println("Username sudah digunakan!");
            } else {
                break;
            }
        }

        String password; //perbaikan-- no 4
        while(true) {
            System.out.println("Password (minimal 8 karakter)");
            System.out.print("> ");
            password = sc.nextLine().trim();
            
            // Validasi password tidak kosong dan minimal 8 karakter
            if(password.isEmpty()) {
                System.out.println("Password tidak boleh kosong!");
            } else if(password.length() < 8) {
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
        Profile profile = new Profile();

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
        // String hobby = sc.nextLine();

        String fullName; //perbaikan-- no 2
        while(true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine().trim();
            if(!fullName.isEmpty()) break;
            System.out.println("Nama lengkap tidak boleh kosong!");
        }

        int age = 0;
        while(age <= 0) {
            System.out.println("Umur");
            System.out.print("> ");
            try {
                age = sc.nextInt();
                sc.nextLine();
                if(age <= 0) {
                    System.out.println("Umur harus lebih dari 0!");
                }
            } catch(Exception e) {
                System.out.println("Umur harus berupa angka!");
                sc.nextLine();
            }
        }

        String hobby;
        while(true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine().trim();
            if(!hobby.isEmpty()) break;
            System.out.println("Hobby tidak boleh kosong!");
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
        profile.setNickName(StringUtils.nickName(profile.getFullName()));

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
        System.out.println("=========================");
        System.out.println("SELAMAT DATANG !!");
        System.out.println("=========================");
        System.out.println("Nama Lengkap    : " + profile.getFullName());
        System.out.println("Nama Panggilan  : " + profile.getNickName());
        System.out.println("Umur \t\t: " + profile.getAge());
        System.out.println("Hobby \t\t: " + profile.getHobby());
    }
}
