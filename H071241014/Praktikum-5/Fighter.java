class Fighter extends Hero {
    public Fighter(String name, int attackPower) {
        super(name, attackPower); // Memanggil konstruktor dari kelas induk Hero
    }

    @Override
    public void attack() {
        System.out.println(getName() + " menyerang dengan pukulan kuat sebesar " + getAttackPower() + "!");
    }
}