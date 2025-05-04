
import java.util.Random;
import java.util.Scanner;

class Hero {
    protected String name;
    protected int hp;
    protected int power;

    public Hero(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public void attack(Enemy enemy) {
        System.out.println(name + " menyerang " + enemy.getName() + " dengan kekuatan " + power + "!");
        enemy.takeDamage(power);
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        System.out.println(name + " menerima " + dmg + " damage. Sisa HP: " + hp);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}

class Archer extends Hero {
    public Archer(String name) {
        super(name, 100, 20);
    }
}

class Wizard extends Hero {
    public Wizard(String name) {
        super(name, 80, 25);
    }
}

class Fighter extends Hero {
    public Fighter(String name) {
        this(name, 150, 15);
    }
    public Fighter(String name, int hp, int power) {
        super(name, hp, power);
    }
}

class Enemy {
    private String name;
    private int hp;
    private int power;

    public Enemy(String name, int hp, int power) {
        this.name = name;
        this.hp = hp;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void attack(Hero hero) {
        System.out.println(name + " menyerang balik dengan kekuatan " + power + "!");
        hero.takeDamage(power);
    }

    public void takeDamage(int dmg) {
        hp -= dmg;
        System.out.println(name + " menerima " + dmg + " damage. Sisa HP: " + hp);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}

public class TP5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int[] possibleDamages = {20, 25, 30};
        Hero hero = null;

        System.out.println("Pilih karakter:");
        System.out.println("1. Archer");
        System.out.println("2. Wizard");
        System.out.println("3. Fighter");
        System.out.print("[Pilihan]: ");
        int zee = sc.nextInt();
        sc.nextLine();

        System.out.print("\nMasukkan nama karakter => ");
        String nama = sc.nextLine();

        switch (zee) {
            case 1: hero = new Archer(nama); break;
            case 2: hero = new Wizard(nama);  break;
            case 3: hero = new Fighter(nama); break;
            default:
                System.out.println("Pilihan tidak valid. Program dihentikan.");
                sc.close();
                return;
        }

        int randomIndex = rand.nextInt(possibleDamages.length);
        int monsterPower = possibleDamages[randomIndex];
        Enemy monster = new Enemy("Monster", 100, monsterPower);
        System.out.println("\n=== Pertempuran Dimulai ===");

        int turn = 1;
        boolean running = true;
        while (running && hero.isAlive() && monster.isAlive()) {
            System.out.println("\n--- Turn " + turn + " ---");
            System.out.println("1. Serang");
            System.out.println("2. Keluar");
            System.out.print("Pilihan Anda: ");
            int oln = sc.nextInt();

            switch (oln) {
                case 1:
                    hero.attack(monster);
                    if (!monster.isAlive()) {
                        System.out.println("\nMonster telah dikalahkan! Kamu menang!");
                        running = false;
                        break;
                    }
                    monster.attack(hero);
                    if (!hero.isAlive()) {
                        System.out.println("\n" + hero.name + " telah gugur. Game Over.");
                        running = false;
                    }
                    turn++;
                    break;

                case 2:
                    System.out.println("Keluar dari game. Terima kasih sudah bermain!");
                    running = false;
                    break;

                default:
                    System.out.println("Pilihan tidak valid, silakan coba lagi.");
            }
        }

        sc.close();
    }
}