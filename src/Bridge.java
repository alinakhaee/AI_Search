public class Bridge extends BaseEntity{
    public boolean traveresd;
    public Bridge(){
        super('P');
        traveresd = false;
    }
    public Bridge(boolean traveresd){
        super('P');
        this.traveresd = traveresd;
    }
    @Override
    public Bridge copy(){
        return new Bridge(this.traveresd);
    }
}
