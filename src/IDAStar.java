import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class IDAStar {
    Visualizer visualizer = new Visualizer();
    Node finalState;
    int expandedNodes = 0;
    int cutoff;
    public void search(Node intialNode){
        int round = 0;
        PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
        Hashtable<String, Boolean> inFrontier = new Hashtable<>();
        Hashtable<String, Boolean> explored = new Hashtable<>();
        if(isGoal(intialNode)){
            result(intialNode);
            return;
        }

        intialNode.currentSteps=0;
        intialNode.guessedSteps=heuristic(intialNode);
        //System.out.println(bfs.resultDepth);
        cutoff = intialNode.currentSteps + intialNode.guessedSteps;
        frontier.add(intialNode);
        inFrontier.put(intialNode.hash(),true);
        while (!frontier.isEmpty()){
//            System.out.println("round : " + (++round));
//            System.out.println("frontier is : " + frontier);
            Node temp = frontier.poll();
            frontier.clear();
            inFrontier.clear();
            explored.clear();
            cutoff = temp.currentSteps + temp.guessedSteps;
//            System.out.println("cutoff : " + cutoff);
            Stack<Node> additionalFrontier = new Stack<>();
            additionalFrontier.push(intialNode);
            Hashtable<String, Boolean> additionalInFrontier = new Hashtable<>();
            additionalInFrontier.put(intialNode.hash(),true);
            Hashtable<String, Boolean> additionalExplored = new Hashtable<>();
            while (!additionalFrontier.isEmpty()){
                Node node = additionalFrontier.pop();
                additionalInFrontier.remove(node.hash());
//                additionalExplored.put(temp.hash(),true);
                if(node.currentSteps + node.guessedSteps > cutoff){
//                    System.out.println("node gets higher than cutoff : " + node);
                    frontier.add(node);
                    continue;
                }
                ArrayList<Node> children = node.successor();
                expandedNodes++;
//                System.out.println("node expanded : " + node);
//                System.out.println(children);
                for(int i = 0;i<children.size();i++){
                    if(!(additionalInFrontier.containsKey(children.get(i).hash())) && !(additionalExplored.containsKey(children.get(i).hash()))) {
                        if (isGoal(children.get(i))) {
                            result(children.get(i));
                            return;
                        }
                        children.get(i).currentSteps = children.get(i).parentNode.currentSteps + 1;
                        children.get(i).guessedSteps = heuristic(children.get(i));
                        additionalFrontier.push(children.get(i));
                        additionalInFrontier.put(children.get(i).hash(), true);
                    }
                }
//                System.out.println(additionalFrontier);
            }
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
            FileWriter myWriter = new FileWriter("IDAStar-result.txt");
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