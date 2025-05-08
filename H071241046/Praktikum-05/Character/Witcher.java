package Character;

public class Witcher extends Hero {

    public Witcher(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void serang(){
        System.out.println("Witcher menyerang dengan kekuatan " + attackPower);
    }
}
