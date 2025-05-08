package Character;

public class Fighter extends Hero{

    public Fighter(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    public void serang(){
        System.out.println("Fighter menyerang dengan kekuatan " + attackPower);
    }
}
