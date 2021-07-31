import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class AStar {
    Visualizer visualizer = new Visualizer();
    Node finalState;
    int expandedNodes = 0;
    public void search(Node intialNode){
        PriorityQueue<Node> frontier = new PriorityQueue<>(new NodeComparator());
        Hashtable<String, Boolean> inFrontier = new Hashtable<>();
        Hashtable<String, Boolean> explored = new Hashtable<>();
        if(isGoal(intialNode)){
            result(intialNode);
            return;
        }

        intialNode.currentSteps=0;
        intialNode.guessedSteps=heuristic(intialNode);
//        System.out.println("................................." + intialNode.guessedSteps);
        frontier.add(intialNode);
        inFrontier.put(intialNode.hash(),true);
        while (!frontier.isEmpty()){
            //System.out.println(frontier);
            Node temp = frontier.poll();
//            System.out.println("chosen node : " + temp);
            inFrontier.remove(temp.hash());
            explored.put(temp.hash(),true);
            expandedNodes++;
            ArrayList<Node> children = temp.successor();
            for(int i = 0;i<children.size();i++){
                if(!(inFrontier.containsKey(children.get(i).hash())) && !(explored.containsKey(children.get(i).hash()))) {
                    if (isGoal(children.get(i))) {
                        result(children.get(i));
                        return;
                    }
                    children.get(i).currentSteps = children.get(i).parentNode.currentSteps + 1;
                    children.get(i).guessedSteps = heuristic(children.get(i));
//                    System.out.println("guessed steps from " + children.get(i) + " is : " + children.get(i).guessedSteps);
                    frontier.add(children.get(i));
                    inFrontier.put(children.get(i).hash(), true);
                }
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
            FileWriter myWriter = new FileWriter("AStar-result.txt");
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

class NodeComparator implements Comparator<Node>{
    @Override
    public int compare(Node o1, Node o2) {
        if((o1.currentSteps+o1.guessedSteps) > (o2.currentSteps+o2.guessedSteps))
            return 1;
        else if((o1.currentSteps+o1.guessedSteps) < (o2.currentSteps+o2.guessedSteps))
            return -1;
        else
            return 0;
//        return (o1.currentSteps+o1.guessedSteps) - (o2.currentSteps+o2.guessedSteps);
    }
}
