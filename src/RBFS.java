import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class RBFS {
    Visualizer visualizer = new Visualizer();
    Node finalState;
    int expandedNodes = 0;
    public void search(Node intialNode){

        intialNode.currentSteps = 0;
        intialNode.guessedSteps = heuristic(intialNode);
        intialNode.f = intialNode.currentSteps + intialNode.guessedSteps;

        rbfs(intialNode, Integer.MAX_VALUE/2);

    }

    public int rbfs(Node node, int fLimit) {
        if(isGoal(node)){
            result(node);
            System.out.println("RBFS expanded nodes : " + expandedNodes);
            System.exit(0);
        }
        PriorityQueue<Node> successors = new PriorityQueue(new NodeFComparator());
        ArrayList<Node> children = node.successor();
        expandedNodes++;
        if(children.size()==0)
            return Integer.MAX_VALUE/2;
        for(Node child : children){
            child.currentSteps = child.parentNode.currentSteps + 1;
            child.guessedSteps = heuristic(child);
            child.f = Math.max(child.currentSteps + child.guessedSteps, node.f);
            successors.add(child);
        }
//        System.out.println("current node : " + node + " children : " + children + " limit : " + fLimit);
        while(true){
            Node best = successors.poll();

            if(isGoal(best)){
                result(best);
                System.out.println("RBFS expanded nodes : " + expandedNodes);
                System.exit(0);
            }
            if(best.f > fLimit)
                return best.f;
            int alternative = successors.size()>0 ?  successors.peek().f : fLimit;
            best.f = rbfs(best, Math.min(fLimit, alternative));
            successors.add(best);
        }
    }
    public boolean isGoal(Node node){
        if (node.map.at(node.player.i,node.player.j).name == 'C'){
            return true;
        }
        else {
            return false;
        }
    }
    public void result(Node node){
        finalState = node;
        Stack<Node>  nodes = new Stack<Node>();
        while (true){
            nodes.push(node);
            if(node.parentNode == null){
                break;
            }
            else {
                node = node.parentNode;
            }
        }
        nodes.pop();
        try {
            FileWriter myWriter = new FileWriter("RBFS-result.txt");
            while (!nodes.empty()){
                Node tempNode = nodes.pop();
                String action = tempNode.priviousAction;
                System.out.println(action+" "+tempNode.player.money+" "+tempNode.player.food);
                myWriter.write(action+"\n");
                //print visualized map for every movement
                visualizer.printMap(tempNode.map, tempNode.player);
            }
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Map relaxMap(Map map){
        ArrayList<BaseEntity> newGame = new ArrayList<BaseEntity>();
        for(int i = 0;i<map.game.size();i++){
            BaseEntity entity = map.game.get(i);
            if(entity.name == 'W' || entity.name == 'B' || entity.name == 'L' )
                newGame.add(new BaseEntity('G'));
            else
                newGame.add(entity.copy());
        }
        Map result = new Map(map.rows, map.cols, newGame);
        return result;
    }

    public int heuristic(Node node){
        Node temp = new Node(node.player, relaxMap(node.map.copy()), null, null);
        BFS bfs = new BFS();
        bfs.writeInFile = false;
        return bfs.heuristicSearch(temp);
    }
}

class NodeFComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        return o1.f - o2.f;
    }
}

class RBFSOutput{
    Node goalNode;
    int newFLimit;
}

