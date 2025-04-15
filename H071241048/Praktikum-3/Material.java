public class Material {
    private String materialName;
    private int addedProtection;
    private int addedDurability;

    public String getMaterialName() {
        return materialName;
    }
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }
    public int getAddedProtection() {
        return addedProtection;
    }
    public void setAddedProtection(int addedProtection) {
        this.addedProtection = addedProtection;
    }
    public int getAddedDurability() {
        return addedDurability;
    }
    public void setAddedDurability(int addedDurability) {
        this.addedDurability = addedDurability;
    }

    //const
    public Material(String materialName, int addedProtection, int addedDurability) {
        this.materialName = materialName;
        this.addedProtection = addedProtection;
        this.addedDurability = addedDurability;
    }
    

    //meth
    public void applyToSuit(Spacesuit suit) {
        // tambah durability & protection ke suit
        suit.setDurability(suit.getDurability() + this.addedDurability);
        suit.setProtectionLevel(suit.getProtectionLevel() + this.addedProtection);
        System.out.println("└ Material " + this.materialName + " digunakan. +" + addedDurability + " Durability, +" + addedProtection + " Protection.");

    }
    

}
