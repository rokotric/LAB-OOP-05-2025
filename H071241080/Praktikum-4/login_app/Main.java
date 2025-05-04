package login_app;

import java.util.ArrayList;
import java.util.Scanner;
import login_app.models.Profile;
import login_app.models.User;
import login_app.utils.StringUtils;

public class Main {
    private static ArrayList<User> listUser = new ArrayList<>(); //simpan data dalam arraylist
    private static ArrayList<Profile> listUserProfile = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        runApp();
    }

    private static void runApp() {
        System.out.println("===============================");
        System.out.println("Aplikasi Login Sederhana");
        System.out.println("===============================");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.print("> ");

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
                runApp();
        }
    }

    private static void showLoginMenu() {
        System.out.println("===============================");
        System.out.println("Login");
        System.out.println("Masukkan Username:");
        System.out.print("> ");

        String username = sc.nextLine();
        // todo 6
        int userIndex = -1;
        for (int i = 0; i < listUser.size(); i++) {
            if (listUser.get(i).getUsername().equals(username)) {
                userIndex = i;
                break;
            }
        }

        if (userIndex != -1) {
            System.out.println("Password:");
            System.out.print("> ");
            String password = sc.nextLine();

            // todo 7
            boolean isPasswordMatch = listUser.get(userIndex).isPasswordMatch(password);
            if (isPasswordMatch) {
                System.out.println("Berhasil Login");
                System.out.println("===============================");
                System.out.println("  SELAMAT DATANG!!");
                System.out.println("===============================");
                // todo 8
                showDetailUser(listUserProfile.get(userIndex));
                System.exit(0);
            } else {
                System.out.println("Password Salah!");
                runApp();
            }
        } else {
            System.out.println("Oops! Username tidak ditemukan.");
            runApp();
        }
    }

    private static void showRegisterMenu() {
        System.out.println("===============================");
        System.out.println("REGISTER");

        String username;
        while (true) {
        System.out.println("Username:");
        System.out.print("> ");
        String inputUsername = sc.nextLine().trim(); // variabel baru 

        if (inputUsername.isEmpty()) {
            System.out.println("Username tidak boleh kosong.");
        } else if (listUser.stream().anyMatch(u -> u.getUsername().equals(inputUsername))) {
            System.out.println("Username sudah digunakan.");
        } else {
            username = inputUsername;  
            break;
        }
        }


        String password;
        while (true) {
            System.out.println("Password (min 8 karakter):");
            System.out.print("> ");
            password = sc.nextLine().trim();
            if (password.length() < 8) {
                System.out.println("Password minimal 8 karakter.");
            } else {
                break;
            }
        }

        // todo 9
        User user = new User(username, password);

        // todo 10
        Profile profile = new Profile();
        String fullName;
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine().trim();
            if (!fullName.isEmpty()) break;
            System.out.println("Nama tidak boleh kosong.");
        }
        profile.setFullName(fullName);

        System.out.println("Umur");
        System.out.print("> ");
        int age = sc.nextInt();
        sc.nextLine();
        profile.setAge(age);

        String hobby;
        while (true) {
            System.out.println("Hobi");
            System.out.print("> ");
            hobby = sc.nextLine().trim();
            if (!hobby.isEmpty()) break;
            System.out.println("Hobi tidak boleh kosong.");
        }
        profile.setHobby(hobby);

        // todo 11
        profile.setNickName(StringUtils.generateNickName(fullName));

        listUser.add(user);
        listUserProfile.add(profile);

        System.out.println("===============================");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("Detail User");
        System.out.println(profile);
    }
}