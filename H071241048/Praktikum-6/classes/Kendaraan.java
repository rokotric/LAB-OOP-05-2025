package classes;
public abstract class Kendaraan {
    protected String id;
    protected String merek;
    protected String model;
    protected int tahunProduksi;
    protected String warna;

    public Kendaraan(String merek, String model) {
        this.id = generateId();
        this.merek = merek;
        this.model = model;
    }

    private String generateId() {
        return "KND-" + System.currentTimeMillis();
    }

    public String getId() { return id; }
    public String getMerek() { return merek; }
    public String getModel() { return model; }
    public int getTahunProduksi() { return tahunProduksi; }
    public void setTahunProduksi(int tahun) { this.tahunProduksi = tahun; }
    public String getWarna() { return warna; }
    public void setWarna(String warna) { this.warna = warna; }

    public abstract double hitungPajak();
    public abstract String getTipeKendaraan();
}
