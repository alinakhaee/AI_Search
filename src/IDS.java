public class IDS {
    int expandedNodes = 0;
    public void search(Node initialNode, int limit){
        DLS dls = new DLS();
        for(int i=0 ; i<=limit ; i++){
            if(dls.search(initialNode, i)){
                expandedNodes += dls.expandedNodes;
                return;
            }
            expandedNodes += dls.expandedNodes;
        }
    }
}
