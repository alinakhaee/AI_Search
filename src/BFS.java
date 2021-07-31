import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BFS {
    Visualizer visualizer = new Visualizer();
    Node finalState;
    int resultDepth;
    boolean writeInFile;
    int expandedNodes=0;

    public void search(Node intialNode){
        Queue<Node> frontier = new LinkedList<Node>();
        Hashtable<String, Boolean> inFrontier = new Hashtable<>();
        Hashtable<String, Boolean> explored = new Hashtable<>();
        if(isGoal(intialNode)){
            result(intialNode);
            return;
        }
        frontier.add(intialNode);
        inFrontier.put(intialNode.hash(),true);
        while (!frontier.isEmpty()){
            Node temp = frontier.poll();
            inFrontier.remove(temp.hash());
            explored.put(temp.hash(),true);
            ArrayList<Node> children = temp.successor();
            expandedNodes++;
            for(int i = 0;i<children.size();i++){
                if(!(inFrontier.containsKey(children.get(i).hash())) && !(explored.containsKey(children.get(i).hash()))) {
                    if (isGoal(children.get(i))) {
                        result(children.get(i));
                        return;
                    }
                    frontier.add(children.get(i));
                    inFrontier.put(children.get(i).hash(), true);
                }
            }
        }
    }

    public int heuristicSearch(Node initialNode){
        Queue<Node> frontier = new LinkedList<Node>();
        Hashtable<String, Boolean> inFrontier = new Hashtable<>();
        Hashtable<String, Boolean> explored = new Hashtable<>();
        if(isGoal(initialNode)){
            result(initialNode);
            return resultDepth;
        }
        frontier.add(initialNode);
        inFrontier.put(initialNode.hash(),true);
        while (!frontier.isEmpty()){
            Node temp = frontier.poll();
            inFrontier.remove(temp.hash());
            explored.put(temp.hash(),true);
            ArrayList<Node> children = temp.successor();
            for(int i = 0;i<children.size();i++){
                if(!(inFrontier.containsKey(children.get(i).hash())) && !(explored.containsKey(children.get(i).hash()))) {
                    if (isGoal(children.get(i))) {
                        result(children.get(i));
                        return resultDepth;
                    }
                    frontier.add(children.get(i));
                    inFrontier.put(children.get(i).hash(), true);
                }
            }
        }

        return Integer.MAX_VALUE/2;

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
        resultDepth = nodes.size();
        if(writeInFile)
            try {
                FileWriter myWriter = new FileWriter("BFS-result.txt");
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
}
