import Code.CostumClass.PetePete;

public class Main {

    public static void main(String[] args) {

        PetePete petePete = new PetePete("Suzuki", "Suzuki Carry");

        petePete.setNamaSupir("Supri");
        System.out.println("Supir : " + petePete.getNamaSupir());

        petePete.setJumlahPenumpangSaatIni(8);
        System.out.println("penumpang : " + petePete.getJumlahPenumpangSaatIni());

        System.out.println("Kapasitas Pete-pete = " + petePete.getKapasitasPenumpang());

        petePete.setTarif(2_000);
        System.out.println("Tarif : Rp." + petePete.getTarif());

        petePete.setSedangBeoperasi(true);
        System.out.println("Pete pete beroperasi? : " + petePete.isSedangBeoperasi());

        petePete.setTahunProduksi(2010);
        System.out.println("Pajak : Rp." + petePete.hitungPajak());

        System.out.println("Tipe kendaraan : " + petePete.getTipeKendaraan());

        petePete.mulai();

        petePete.berhenti();

        petePete.setKecepatan(80);
        System.out.println("Kecepatan : " + petePete.getKecepatan() + " km/jam");

    }
}
