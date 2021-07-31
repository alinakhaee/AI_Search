public class BaseEntity {
    public char name;
    public BaseEntity(char name){
        this.name = name;
    }
    @Override
    public String toString() {
        return Character.toString(name);
    }
    public BaseEntity copy(){
        return new BaseEntity(this.name);
    }
}
