

public abstract class Kendaraan {
    protected String id;
    protected String merek;
    protected String model;
    protected int tahunProduksi;
    protected String warnaa;

    public Kendaraan(String merek, String model) {
        this.merek = merek;
        this.model = model;
        this.id = merek + "-" + model;
    }

    public String getId() { return id; }
    public String getMerek() { return merek; }
    public String getModel() { return model; }
    public int getTahunProduksi() { return tahunProduksi; }
    public void setTahunProduksi(int tahun) { this.tahunProduksi = tahun; }
    public String getWarna() { return warnaa; }
    public void setWarna(String warna) { this.warnaa = warna; }

    public abstract double hitungPajak();
    public abstract String getTipeKendaraan();
}
