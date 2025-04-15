public class Main {
    public static void main(String[] args) {

        //  BUAT OBJEK
        Planet sagaras = new Planet("SagaraS", false, 5);
        Planet nebula = new Planet("Nebula", false, 8);
        Planet bumi = new Planet("Bumi", true, 1);

        Spacesuit suitAli = new Spacesuit("Titanium", 90, 7);
        Spacesuit suitSeli = new Spacesuit("NanoFiber", 85, 6);
        Spacesuit suitRaib = new Spacesuit("CarbonWeave", 95, 5);

        SpaceExplorer ali = new SpaceExplorer("Ali", 100, 85, suitAli, sagaras);
        SpaceExplorer seli = new SpaceExplorer("Seli", 90, 90, suitSeli, nebula);
        SpaceExplorer raib = new SpaceExplorer("Raib", 75, 95, suitRaib, bumi);

        Material titaniumPlus = new Material("Titanium+", 3, 10);
        Material nanoShield = new Material("NanoShield", 2, 15);

        Alien lumpu = new Alien("Lumpu", 4, nebula);

        // STATUS AWAL
        System.out.println("\n======================= STATUS AWAL PENJELAJAH =======================");
        ali.reportStatus();
        seli.reportStatus();
        raib.reportStatus();
        System.out.println("=================================================================\n");

        //  PETUALANGAN DIMULAI
        System.out.println("---> Ali memutuskan menjelajah ke planet Nebula yang berbahaya...");
        ali.explorePlanet("Nebula");

        System.out.println("\n---> Seli melihat Raib kehabisan oksigen dan segera membantunya...");
        seli.shareOxygen(raib);

        System.out.println("\n---> Raib memperbaiki suit-nya dengan alat 'Nano Repair'...");
        raib.useTool("Nano Repair");

        System.out.println("\n---> Ali menemukan material langka 'NanoShield' dan menggunakannya...");
        ali.upgradeSuit(nanoShield);

        System.out.println("\n---> Raib juga melakukan upgrade suit dengan 'Titanium+' yang kuat...");
        raib.upgradeSuit(titaniumPlus);

        System.out.println("\n---> Raib melakukan scan terhadap planet Bumi:");
        raib.getCurrentPlanet().scan();

        System.out.println("\n---> Raib memulai proses terraform planet Bumi:");
        raib.getCurrentPlanet().terraform();

        System.out.println("\n---> Planet Bumi setelah terraform:");
        raib.getCurrentPlanet().scan();

        // ANCAMAN MUNCUL
        System.out.println("\n---> ALIEN 'Lumpu' muncul dan menyerang Seli di planet Nebula!");
        lumpu.attack(seli);

        System.out.println("\n---> Bahaya meningkat! Lumpu membuat planet Nebula jadi makin berbahaya...");
        lumpu.increasePlanetDanger();

        System.out.println("\n---> Seli menggunakan alat 'First Aid Kit' untuk memulihkan stamina...");
        seli.useTool("First Aid Kit");


        //  STATUS AKHIR
        System.out.println("\n======================= STATUS AKHIR PENJELAJAH =======================");
        ali.reportStatus();
        seli.reportStatus();
        raib.reportStatus();

        System.out.println("\n---> Misi selesai. Penjelajahan antariksa hari ini penuh tantangan dan kerja sama.\n");
        System.out.println("=================================================================");
    }
}
