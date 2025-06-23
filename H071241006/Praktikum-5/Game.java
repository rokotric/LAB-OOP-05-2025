import java.util.Scanner;

class Hero {
    protected String name;
    protected int health;
    protected int attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower);
    }
}

class Archer extends Hero {
    public Archer(String name) {
        super(name, 80, 15); 
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower);
    }
}

class Wizard extends Hero {
    public Wizard(String name) {
        super(name, 70, 20); 
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower);
    }
}

class Fighter extends Hero {
    public Fighter(String name) {
        this(name, 100); 
    }

    public Fighter(String name, int health) {
        super(name, health, 10); 
    }

    @Override
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower);
    }
}

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hero hero = null;

        System.out.println("=== Pilih Karakter ===");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Pilihan: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        String name = scanner.nextLine();

        switch (choice) {
            case 1:
                hero = new Archer(name);
                break;
            case 2:
                hero = new Wizard(name);
                break;
            case 3:
                hero = new Fighter(name);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
                return;
        }

        int menu;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    hero.attack();
                    break;
                case 2:
                    System.out.println("Keluar dari permainan");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }

        } while (menu != 2);

        scanner.close();
    }
}
