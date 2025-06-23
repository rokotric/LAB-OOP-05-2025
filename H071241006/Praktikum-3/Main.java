public class Main {
    public static void main(String[] args) {
        Senjata pistol = new Senjata("pistol", 30);
        Senjata panah = new Senjata("panah", 20);
        

        Pahlawan pahlawan1 = new Pahlawan("Pahlawan A", 100, pistol);
        Pahlawan pahlawan2 = new Pahlawan("Pahlawan B", 100, panah);

        pahlawan1.serang(pahlawan2);
        pahlawan2.serang(pahlawan1);

        pahlawan1.terimaSerangan(5);
        pahlawan2.terimaSerangan(10);

    }
}
