public class Main {
    public static void main(String[] args) {
        
        Bajaj b1 = new Bajaj("suzuki","daffa");
        

        b1.setJumlahPenumpang(8);
        b1.mulai();
        b1.berhenti();
        b1.setKecepatan(100);
        b1.setTahunProduksi(2009);
        b1.hitungPajak();
        
        
        System.out.println(b1.getJumlahPenumpang());
        System.out.println(b1.mulai());
        System.out.println(b1.berhenti());
        System.out.println(b1.getKecepatan());
        System.out.println(b1.getTahunProduksi());
        System.out.println(b1.hitungPajak());
        System.out.println(b1.getTipeKendaraan());
        





    }

    
}


