class Archer extends Hero {
    public Archer(String name, int attackPower) {
        super(name, attackPower);
    }
 
    @Override
    public void attack() {
        System.out.println(getName() + " menembakkan panah dengan kekuatan " + getAttackPower()+"!");
    }
}