import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DFS {
    Visualizer visualizer = new Visualizer();
    int nodeExpanded=0;
    public void search(Node intialNode){
        //Queue<Node> frontier = new LinkedList<Node>();
        Stack<Node> frontier = new Stack<>();
        Hashtable<String, Boolean> inFrontier = new Hashtable<>();
        Hashtable<String, Boolean> explored = new Hashtable<>();
        if(isGoal(intialNode)){
            result(intialNode);
            return;
        }
        frontier.add(intialNode);
        inFrontier.put(intialNode.hash(),true);
        while (!frontier.isEmpty()){
            //Node temp = frontier.poll();
            Node temp = frontier.pop();
            inFrontier.remove(temp.hash());
            explored.put(temp.hash(),true);
            nodeExpanded++;
            ArrayList<Node> children = temp.successor();
            //System.out.println(temp.hash());
            for(int i = 0;i<children.size();i++){
                if(!(inFrontier.containsKey(children.get(i).hash())) && !(explored.containsKey(children.get(i).hash()))) {
                    if (isGoal(children.get(i))) {
                        result(children.get(i));
                        return;
                    }
                    frontier.push(children.get(i));
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
            FileWriter myWriter = new FileWriter("DFS-result.txt");
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

