public class WildAnimall extends BaseEntity {
    public WildAnimall(int power){
        super('W');
        this.power = power;
    }
    public int power;
    public void takeFood(Player player){
        player.changeFood(-power);
    }
    @Override
    public WildAnimall copy(){
        return new WildAnimall(this.power);
    }
}
