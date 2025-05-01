class Wizard extends Hero {
    public Wizard(String name, int attackPower) {
        super(name, attackPower);
    }

    @Override
    public void attack() {
        System.out.println(getName() + " mengeluarkan sihir dengan kekuatan " + getAttackPower() + "!");
    }
}