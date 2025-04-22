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
        runApp();
    }

    private static void runApp() {
        System.out.println("-------------------------");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("-------------------------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

        if (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.println("Input tidak valid. Harus angka!");
            runApp();
            return;
        }

        int selectMenu = sc.nextInt();
        sc.nextLine();
        switch (selectMenu) {
            case 1:
                showLoginMenu();
                break;
            case 2:
                showRegisterMenu();
                break;
            default:
                System.out.println("Menu tidak ditemukan.");
                runApp();
        }
    }

    private static void showLoginMenu() {
        System.out.println("-------------------------");
        System.out.println("Login");
        System.out.println("Masukkan Username");
        System.out.print("> ");
        String username = sc.next();

        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            System.out.println("Password");
            System.out.print("> ");
            String password = sc.next();

            boolean isPasswordMatch = listUser.get(userIndex).getPassword().equals(password);

            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                System.out.println("Password Salah");
                runApp();
            }
        } else {
            System.out.println("Username tidak ditemukan");
            runApp();
        }
    }

    private static void showRegisterMenu() {
        System.out.println("-------------------------");
        System.out.println("REGISTER");

        String username;
        while (true) {
            System.out.println("Username");
            System.out.print("> ");
            username = sc.nextLine().trim();

            if (username.isEmpty()) {
                System.out.println("Username tidak boleh kosong!");
                continue;
            }

            boolean isUsernameUsed = false;

            for (User u : listUser) {
                if (u.getUsername().equals(username)) {
                    isUsernameUsed = true;
                    break;
                }
            }

            if (isUsernameUsed) {
                System.out.println("Username sudah digunakan!");
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

        User user = new User(username, password);
        Profile profile = new Profile();

        System.out.println("Nama Lengkap");
        System.out.print("> ");
        String fullName = sc.nextLine();

        int age = 0;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                sc.nextLine();
                if (age < 0) {
                    System.out.println("Umur tidak valid.");
                } else {
                    break;
                }
            } else {
                System.out.println("Input umur harus angka!");
                sc.nextLine();
            }
        }

        System.out.println("Hobby");
        System.out.print("> ");
        String hobby = sc.nextLine();

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);
        profile.setNickName(StringUtils.getNickName(fullName));

        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Detail Profil");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nickname     : " + profile.getNickName());
        System.out.println("Umur         : " + profile.getAge());
        System.out.println("Hobby        : " + profile.getHobby());
        System.out.println("-------------------------");
    }
}
