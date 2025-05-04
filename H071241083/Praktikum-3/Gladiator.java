public class Gladiator {

    String name;
    int stamina;
    Senjata senjata;

    public Gladiator(String name, int stamina, Senjata senjata) {
        this.name = name;
        this.stamina = stamina;
        this.senjata = senjata;
    }

    public Gladiator() {
    }

    public void latihan() {
        this.stamina += 50;

        System.out.println(name + " telah melakukan latihan, stamina bertambah menjadi " + stamina);
    }

    public void bertarung(Gladiator lawan) {
        lawan.stamina -= this.senjata.kekuatan;

        System.out.println(name + " telah bertarung " + stamina);
    }
}