public class Spacesuit {
    private String material;
    private int durability;
    private int protectionLevel;

    public String getMaterial() {
        return material;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
    public int getProtectionLevel() {
        return protectionLevel;
    }
    public void setProtectionLevel(int protectionLevel) {
        this.protectionLevel = protectionLevel;
    }

    @Override
    public String toString() {
        return "Material: " + material + ", Durability: " + durability + ", Protection: " + protectionLevel;
    }


    //conts
    public Spacesuit() {
        this.material = "Standard";
        this.durability = 100;
        this.protectionLevel = 5;
    }
    
    public Spacesuit(String material, int durability, int protectionLevel) {
        this.material = material;
        this.durability = durability;
        this.protectionLevel = protectionLevel;
    }
    
    // method
    public void takeDamage(int damage) {
        // kurangi durability
        this.durability -= damage;
        if (this.durability < 0) {
            this.durability = 0;
        }
    }
    
    public void repair(int amount) {
        // tambah durability
        this.durability += amount;
        if (this.durability > 100) {
            this.durability = 100;
        }
    }
    
    public void boostProtection(int amount) {
        // tambah protection
        this.protectionLevel += amount;
        if (this.protectionLevel > 10) {
            this.protectionLevel = 10;
        }
    }
    

}