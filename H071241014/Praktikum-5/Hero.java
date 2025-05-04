class Hero {
    private String name; // Tambahkan deklarasi variabel name
    private int attackPower;

    public Hero(String name, int attackPower) { // Perbaiki parameter konstruktor
        this.name = name;
        this.attackPower = attackPower;
    }

    public String getName() { // Tambahkan getter untuk name
        return name;
    }

    public int getAttackPower() { // Tambahkan getter untuk attackPower
        return attackPower;
    }

    public void attack() {
        System.out.println(name + " menyerang dengan kekuatan " + attackPower + "!");
    }
}