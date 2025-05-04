

public class Main {
    public static void main(String[] args) {
        Senjata pedang = new Senjata("Pedang", 20);
        Senjata tombak = new Senjata("Tombak", 15);

        Gladiator ril = new Gladiator("Ril", 100, pedang);
        Gladiator rul = new Gladiator("Rul", 200, tombak);

        ril.bertarung(rul);
        ril.latihan();
    }
}