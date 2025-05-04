// TODO: Buat class Planet
// - attribute: name (String), isHabitable (boolean), dangerLevel (int)
// - method: scan()
// - method: terraform()
public class Planet {
    private String name;
    private boolean isHabitable;
    private int dangerLevel;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public boolean isHabitable() {
        return isHabitable;
    }
    public void setHabitable(boolean isHabitable) {
        this.isHabitable = isHabitable;
    }
    public int getDangerLevel() {
        return dangerLevel;
    }
    public void setDangerLevel(int dangerLevel) {
        this.dangerLevel = dangerLevel;
    }

    @Override
    public String toString() {
        return "Planet: " + name + ", Habitable: " + isHabitable + ", Danger Level: " + dangerLevel;
    }


    //const
    public Planet() {
        this.name = "Unknown";
        this.isHabitable = false;
        this.dangerLevel = 5;
    }
    
    public Planet(String name, boolean isHabitable, int dangerLevel) {
        this.name = name;
        this.isHabitable = isHabitable;
        if (dangerLevel >= 1){
            this.dangerLevel  = dangerLevel;
        }
    }
    
    //method
    public void scan() {
        // tampilkan info planet
        System.out.println("\n| [SCAN PLANET]");
        System.out.println("├ Planet Name: " + this.name);
        System.out.println("├ Habitable: " + (this.isHabitable ? "Yes" : "No"));
        System.out.println("└ Danger Level: " + this.dangerLevel);
    }

    public void terraform() {
        // ubah jadi bisa dihuni
        if (!this.isHabitable) {
            this.isHabitable = true;
            
            if (this.dangerLevel >= 2) {
                this.dangerLevel -= 2;
            } else {
                this.dangerLevel = 0;
            }
            System.out.println("├ Planet has been terraformed to be habitable.");
            System.out.println("├ Status Baru: Layak Huni");
            System.out.println("└ Level Bahaya: " + this.dangerLevel);
        } else {
            System.out.println("└ Planet is already habitable.");
        }
    }
}
