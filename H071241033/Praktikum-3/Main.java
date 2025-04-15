import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        int dmg1 = rand.nextInt(100, 400);
        int dmg2 = rand.nextInt(100, 400);
        GER giorno = new GER("Giorno Giovanna", "Gold Experience", "Create and Manipulate Life", 1000, dmg1);
        GER diavolo = new GER("Diavolo", "King Crimson", "Reality Alteration", 1500, dmg2);
        GER def = new GER();

        System.out.println("==========================");
        giorno.showInfo();
        System.out.println("==========================");
        diavolo.showInfo();
        System.out.println("==========================\n");

        while (true) {
            giorno.attack(diavolo);
            if (diavolo.standUsr.getHp() <= 0) {
                System.out.println("\n>>> " + giorno.standUsr.getName() + " berhasil mengalahkan " + diavolo.standUsr.getName() + " dan Stand " + diavolo.stand.getStandName() + "!\n");
                break;
            }
            diavolo.attack(giorno);
            if (giorno.stand.getStandName().equals("Gold Experience") && giorno.standUsr.getHp() <= 100) {
                giorno.Requiem(diavolo);
                break;
            }
        }
    }
}