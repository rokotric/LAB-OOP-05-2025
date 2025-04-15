
public class StandUser {
    String userName;
    Stand stand;
    int hp;
    
    public StandUser(String name, int hp, Stand stand) {
        this.userName = name;
        this.hp = hp;
        this.stand = stand;
    }
    public void useAbility() {
        System.out.println(">>> '" + stand.name + "!'");
        System.out.println(">>> " + stand.name +" menggunakan ability " + stand.standAbility);
        System.out.println(">>> HP " + this.userName + " kembali menjadi: " + this.hp);
    }

    public String getName() {
        return this.userName;
    }
    
    public void setHp(int hp) {
        this.hp = Math.max(hp, 0);
    }
    public int getHp() {
        return this.hp;
    }

}