package login_app;

public class Profile {
   private String nama;
   private int umur;
   private String hobi;
   private String nickName;
   
   public Profile() {
      
   }
   
   public Profile(String nama, int umur, String hobi, String nickName) {
      this.nama = nama;
      this.umur = umur;
      this.hobi = hobi;
      this.nickName = nickName;
      
   }
   
   public String getNickName() {
      return nickName;
   }

   public void setNickName(String nickName) {
      this.nickName = nickName;
   }
  

   public String getNama() {
    return nama;
   }

   public int getUmur() {
    return umur;
   }

   public String getHobi() {
    return hobi;
   }

   public void setNama(String nama) {
      this.nama = nama;
   }

   public void setUmur(int umur) {
      this.umur = umur;
   }

   public void setHobi(String hobi) {
      this.hobi = hobi;
   }
   
  
   
}