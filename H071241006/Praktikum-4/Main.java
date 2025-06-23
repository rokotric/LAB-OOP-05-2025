import java.util.ArrayList;
import java.util.Scanner;

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

        while (!sc.hasNextInt()) {
            System.out.println("Input harus angka 1 atau 2!");
            sc.next();
            System.out.print("> ");
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
                System.out.println("Menu tidak tersedia, pilih lagi!");
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
            boolean isExist = false;
            for (User user : listUser) {
                if (user.getUsername().equals(username)) {
                    isExist = true;
                    break;
                }
            }
            if (isExist) {
                System.out.println("Username sudah digunakan, pilih username lain!");
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

        String fullName;
        while (true) {
            System.out.println("Nama Lengkap");
            System.out.print("> ");
            fullName = sc.nextLine().trim();
            if (fullName.isEmpty()) {
                System.out.println("Nama Lengkap tidak boleh kosong!");
            } else {
                break;
            }
        }

        int age;
        while (true) {
            System.out.println("Umur");
            System.out.print("> ");
            if (!sc.hasNextInt()) {
                System.out.println("Umur harus angka!");
                sc.next();
                continue;
            }
            age = sc.nextInt();
            sc.nextLine();
            if (age <= 0) {
                System.out.println("Umur harus lebih dari 0!");
            } else {
                break;
            }
        }

        String hobby;
        while (true) {
            System.out.println("Hobby");
            System.out.print("> ");
            hobby = sc.nextLine().trim();
            if (hobby.isEmpty()) {
                System.out.println("Hobby tidak boleh kosong!");
            } else {
                break;
            }
        }

        profile.setFullName(fullName);
        profile.setAge(age);
        profile.setHobby(hobby);

        profile.setNickName(StringUtils.generateNickName(fullName));

        listUser.add(user);
        listUserProfile.add(profile);
        System.out.println("-------------------------");
        System.out.println("Berhasil Membuat User Baru!!");
        runApp();
    }

    private static void showDetailUser(Profile profile) {
        System.out.println("-------------------------");
        System.out.println("Profile User");
        System.out.println("Nama Lengkap : " + profile.getFullName());
        System.out.println("Nick Name    : " + profile.getNickName());
        System.out.println("Umur         : " + profile.getAge());
        System.out.println("Hobby        : " + profile.getHobby());
        System.out.println("-------------------------");
    }
}
