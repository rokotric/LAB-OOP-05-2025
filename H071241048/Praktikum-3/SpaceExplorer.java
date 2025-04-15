public class SpaceExplorer {
    private String name;
    private int oxygenLevel;
    private int stamina;
    private Spacesuit suit;
    private Planet currentPlanet;
    private ToolKit toolKit;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getOxygenLevel() {
        return oxygenLevel;
    }
    public void setOxygenLevel(int oxygenLevel) {
        this.oxygenLevel = oxygenLevel;
    }
    public int getStamina() {
        return stamina;
    }
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
    public Spacesuit getSuit() {
        return suit;
    }
    public void setSuit(Spacesuit suit) {
        this.suit = suit;
    }
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }
    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }
    public ToolKit getToolKit() {
        return toolKit;
    }
    public void setToolKit(ToolKit toolKit) {
        this.toolKit = toolKit;
    } 
    

    // Default constructor
    public SpaceExplorer() {
        this.name = "Unknown";
        this.oxygenLevel = 100;
        this.stamina = 100;
        this.suit = new Spacesuit();
        this.currentPlanet = new Planet();
        this.toolKit = new ToolKit();
    }

    // Constructor dengan parameter
    public SpaceExplorer(String name, int oxygenLevel, int stamina, Spacesuit suit, Planet planet) {
        this.name = name;
        this.oxygenLevel = oxygenLevel;
        this.stamina = stamina;
        this.suit = suit;
        this.currentPlanet = planet;
        this.toolKit = new ToolKit();
    }

    //Method
    public void explorePlanet(String name) {
        // kurangi stamina & oxygen, ubah nama planet
        this.oxygenLevel -= 10;
        this.stamina -= 10;
        this.currentPlanet.setName(name);
    }
    
    public void shareOxygen(SpaceExplorer other) {
        // transfer oxygen ke objek lain
        if (this.oxygenLevel >= 10) {
            this.oxygenLevel -= 10;
            other.oxygenLevel += 10;
            System.out.println(this.name + " membagikan oksigen ke " + other.name);
        } else {
            System.out.println("Oksigen tidak cukup untuk dibagikan.");
        }
    }
    
    public void reportStatus() {
        // tampilkan semua atribut
        final String LABEL = "\u001B[96m";
        

        System.out.println(LABEL+"╔══════════════════════════════════════════════════════════════════════╗");
        System.out.printf(LABEL+"║ %-18s: %-48s ║\n", "Nama", this.name);
        System.out.printf(LABEL+"║ %-18s: %-48d ║\n", "Level Oksigen", this.oxygenLevel);
        System.out.printf(LABEL+"║ %-18s: %-48d ║\n", "Stamina", this.stamina);
        System.out.printf(LABEL+"║ %-18s: %-48s ║\n", "Baju Luar Angkasa", this.suit.toString().replace("Material: ", ""));
        System.out.printf(LABEL+"║ %-18s: %-48s ║\n", "Planet", this.currentPlanet.getName());
        System.out.printf(LABEL+"║ %-18s: %-45s ║\n", "Toolkit", this.toolKit.toString());
        System.out.println(LABEL+"╚══════════════════════════════════════════════════════════════════════╝"+ "\u001B[0m" );
    }
    
    public void upgradeSuit(Material material) {
        // pakai material untuk upgrade suit
        material.applyToSuit(this.suit);

    }
    
    public void useTool(String toolName) {
        // pakai alat dari toolKit
        boolean found = false;
        for (String tool : this.toolKit.getTools()) {
            if (tool.equalsIgnoreCase(toolName)) {
                found = true;
                switch (toolName) {
                    case "Oxygen Tank":
                        this.oxygenLevel += 20;
                        if (this.oxygenLevel > 100) {
                            this.oxygenLevel = 100;
                        }
                        System.out.println("└ Oksigen bertambah 20.");
                        break;
                    case "Nano Repair":
                        this.suit.repair(20);
                        System.out.println("└ Suit diperbaiki sebanyak 20.");
                        break;
                    case "Scanner":
                        this.currentPlanet.scan();
                        break;
                    case "First Aid Kit":
                        this.stamina += 20;
                        if (this.stamina > 100) {
                            this.stamina = 100;
                        }
                        System.out.println("└ Menggunakan First Aid Kit. Stamina bertambah 20.");
                        break;
                    default:
                        System.out.println("└ Alat digunakan: " + toolName);
                }
    
                break;
            }
        }
        if (!found) {
            System.out.println("└ Tool " + toolName + " tidak tersedia");
        }
    }
    

    
}
class ToolKit {
    private String[] tools = {"Scanner", "Nano Repair", "Oxygen Tank", "First Aid Kit"}; // alat-alat yang tersedia

    
    public String[] getTools() {
        return tools;
    }
    public void setTools(String[] tools) {
        this.tools = tools;
    }


    @Override
    public String toString() {
        return String.join(", ", tools);
    }


    public String getToolInfo(String name) {
        // cari alat berdasarkan nama
        for (String tool : this.tools) {
            if (tool.equalsIgnoreCase(name)) {
                return tool;
            }
        }
        return null;
    }
}