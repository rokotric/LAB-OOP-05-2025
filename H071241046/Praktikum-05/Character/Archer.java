package Character;

public class Archer extends Hero {

    public Archer(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void serang(){
        System.out.println("Archer menyerang dengan kekuatan " + attackPower);
    }
}
