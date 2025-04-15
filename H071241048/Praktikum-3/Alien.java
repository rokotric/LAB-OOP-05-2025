public class Alien {
    private String speciesName;
    private int dangerLevel;
    private Planet currentPlanet;

    public String getSpeciesName() {
        return speciesName;
    }
    public void setSpeciesName(String speciesName) {
        this.speciesName = speciesName;
    }
    public int getDangerLevel() {
        return dangerLevel;
    }
    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }
    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    //const
    public Alien() {
        this.speciesName = "Unknown";
        this.dangerLevel = 3;
        this.currentPlanet = new Planet();
    }
    
    public Alien(String speciesName, int dangerLevel, Planet planet) {
        this.speciesName = speciesName;
        this.dangerLevel = dangerLevel;
        this.currentPlanet = planet;
    }
    
    // method
    public void attack(SpaceExplorer target) {
        // serang penjelajah
        int damage = this.dangerLevel * 10;
        target.setStamina(target.getStamina() - damage);
        System.out.println("\n\u001B[35m ======== SERANGAN ========");
        System.out.println(this.speciesName + " menyerang " + target.getName() + " dengan kekuatan " + damage);
        System.out.println("Stamina " + target.getName() + " tersisa: " + target.getStamina() + "\u001B[0m");
    }
    
    public void increasePlanetDanger() {
        // tambah dangerLevel pada planet
        if (this.currentPlanet != null) {
            this.currentPlanet.setDangerLevel(this.currentPlanet.getDangerLevel() + this.dangerLevel);
            System.out.println("Planet " + currentPlanet.getName() + " menjadi lebih berbahaya!");
        } else {
            System.out.println("Alien tidak berada di planet manapun.");
        }
    }
    
}
