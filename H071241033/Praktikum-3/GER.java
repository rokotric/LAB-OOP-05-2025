import java.util.Random;

public class GER {
    StandUser standUsr;
    Stand stand;
    int dmg;

    public GER() {
        this.stand = new Stand("Crazy Diamond", "Restoration");
        this.standUsr = new StandUser("Higashikata Josuke", 1500, this.stand);
        this.dmg = 189;
    }

    public GER(String user, String stand, String ability, int hp, int dmg) {
        this.stand = new Stand(stand, ability);
        this.standUsr = new StandUser(user, hp, this.stand);
        this.dmg = dmg;
    }

    public void showInfo() {
        System.out.println("Nama   : " + standUsr.getName());
        System.out.println("Stand  : " + stand.getStandName());
        System.out.println("HP     : " + standUsr.getHp());
        System.out.println("Ability: " + stand.getStandAbility());
    }

    public void Requiem(GER enemy) {
        System.out.println("\n>>> Giorno Giovanna menggunakan ultimate ability Gold Experience: Requiem!");
        System.out.println(">>> RETURN TO ZERO... Serangan " + enemy.standUsr.getName() + " tidak pernah terjadi!" );
        System.out.println(">>> HP Giorno Giovanna kembali menjadi 1000");
        System.out.println("\n'Korega... Requiem Da!'\n");
        System.out.println(">>> Gold Experience: Requiem mengaktifkan skill The Infinity Death ke " + enemy.standUsr.getName() + "!");
        System.out.println("...");
        for (int i = 0; i < 5; i++) {
            System.out.println(enemy.standUsr.getName() + " mati");
            System.out.println(enemy.standUsr.getName() + " hidup kembali");
        }
        System.out.println("...");
        System.out.println(">>> " + enemy.standUsr.getName() + " terjebak dalam Death Loop selamanya...\n");
        System.out.println(">>> GOLD EXPERIENCE: REQUIEM MENANG MUTLAK!\n");

    }

    public void attack(GER enemy) {
        System.out.println("\n" + standUsr.getName() + " menyerang " + enemy.standUsr.getName() + " dengan Stand " + stand.getStandName());
        System.out.println("Damage yang diterima " + enemy.standUsr.getName() + ": " + this.dmg);
        int enemyHp = enemy.standUsr.getHp() - this.dmg;
        enemy.standUsr.setHp(enemyHp);
        System.out.println("HP " + enemy.standUsr.getName() + " sekarang: " + enemy.standUsr.getHp());

        Random rand = new Random();
        int randint = rand.nextInt(3);
        
        if (enemy.standUsr.getHp() != 0 && randint == 1) {
            enemyHp = enemy.standUsr.getHp() + this.dmg;
            enemy.standUsr.setHp(enemyHp);
            enemy.standUsr.useAbility();
        }
    }
}