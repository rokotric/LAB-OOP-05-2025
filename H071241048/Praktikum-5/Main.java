import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Hero hero = null;

        System.out.println("=== Pilih Karakter ===");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("Pilihan Anda: ");
        int choice = input.nextInt();

        switch (choice) {
            case 1:
                hero = new Archer("Pemanah", 80, 15);
                break;
            case 2:
                hero = new Wizard("Penyihir", 70, 20);
                break;
            case 3:
                hero = new Fighter("Fighter"); 
                break;
            default:
                System.out.println("Pilihan tidak valid. Keluar...");
                System.exit(0);
        }

        int menuChoice = 0;
        do {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilih aksi: ");
            menuChoice = input.nextInt();

            switch (menuChoice) {
                case 1:
                    hero.attack();
                    break;
                case 2:
                    System.out.println("Keluar dari game. Sampai jumpa....");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (menuChoice != 2);

        input.close();
    }
}

class Hero {
    String name;
    int health, attackPower;

    public Hero(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
    
    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}

class Fighter extends Hero {
    Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    Fighter(String name) {
        this(name, 100, 18); 
    }

}

class Archer extends Hero {
    Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    Archer(String name) {
        this(name, 100, 15); 
    }
}    

class Wizard extends Hero {
    Wizard(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    Wizard(String name) {
        this(name, 100, 20); 
    }
}       

