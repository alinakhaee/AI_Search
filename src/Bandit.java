public class Bandit extends BaseEntity {
    public Bandit(int power){
        super('B');
        this.power = power;
    }
    public int power;
    public void takeMoney(Player player){
        player.changeMoney(-power);
    }
    @Override
    public Bandit copy(){
        return new Bandit(this.power);
    }
}
