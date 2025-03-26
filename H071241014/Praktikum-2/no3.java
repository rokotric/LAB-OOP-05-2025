class Cuboid {
    double height;
    double width;
    double length;

    double getVolume() {
        // Menghitung volume balok
        return height * width *length;
       
        
        
    }
}

public class no3 {
    public static void main(String[] args) {
        Cuboid cuboid = new Cuboid();
        
        //mengisi nilai atribut sesuai dengan output yang diharapkan
        cuboid.height = 10;
        cuboid.width = 15;
        cuboid.length = 30; 
        System.out.printf("Volume = %.2f", cuboid.getVolume());
    }
}