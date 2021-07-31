public class Player {
    public int i;
    public int j;
    public int money;
    public int food;
    public boolean haskey;
    public Player(int i,int j,int money,int food){
        this.i = i;
        this.j = j;
        this.money = money;
        this.food = food;
        this.haskey = false;
    }
    public Player(int i,int j,int money,int food,boolean haskey){
        this.i = i;
        this.j = j;
        this.money = money;
        this.food = food;
        this.haskey = haskey;
    }
    //amount can be negetive and positive
    public void changeMoney(int amount){
        money += amount;
    }
    //amount can be negetive and positive
    public void changeFood(int amount){
        food += amount;
    }
}
