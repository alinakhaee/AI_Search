import java.util.ArrayList;

public class Map {
    public final int rows;
    public final int cols;
    public ArrayList<BaseEntity> game;
    public Map(int rows,int cols){
        this.rows = rows;
        this.cols = cols;
        this.game = new ArrayList<BaseEntity>();
    }
    public Map(int rows,int cols,ArrayList<BaseEntity> game){
        this.rows = rows;
        this.cols = cols;
        this.game = game;
    }
    public void changeEntity(int i, int j, BaseEntity baseEntity){ game.set((i*cols)+j, baseEntity);}
    public void addEntity(int i,int j,BaseEntity baseEntity){
        game.add((i*cols)+j,baseEntity);
    }
    public BaseEntity at(int i,int j){
        return game.get((i*cols)+j);
    }
    public Map copy(){
        ArrayList<BaseEntity> newGame = new ArrayList<BaseEntity>();
        for(int i = 0;i<game.size();i++){
            newGame.add(game.get(i).copy());
        }
        Map result = new Map(this.rows,this.cols,newGame);
        return result;
    }
    public void print(){
        for(int i = 0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(at(i,j).name+ " ");
            }
            System.out.println();
        }
    }
}
