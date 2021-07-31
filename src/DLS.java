import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DLS {
    Visualizer visualizer = new Visualizer();
    int expandedNodes = 0;
    public boolean search(Node intialNode, int limit){
        expandedNodes = 0;
        //Queue<Node> frontier = new LinkedList<Node>();
        Stack<Node> frontier = new Stack<>();
        Hashtable<String, Boolean> inFrontier = new Hashtable<>();
        Hashtable<String, Integer> inFrontierDepth = new Hashtable<>();
        Hashtable<String, Boolean> explored = new Hashtable<>();
        if(isGoal(intialNode)){
            result(intialNode);
            return true;
        }
        frontier.add(intialNode);
        inFrontier.put(intialNode.hash(),true);
        inFrontierDepth.put(intialNode.hash(), 0);
        while (!frontier.isEmpty()){
            //Node temp = frontier.poll();
            Node temp = frontier.pop();
            inFrontier.remove(temp.hash());
            int depth = inFrontierDepth.get(temp.hash());
            inFrontierDepth.remove(temp.hash());
            explored.put(temp.hash(),true);
            if(depth>=limit){
                continue;
            }
            ArrayList<Node> children = temp.successor();
            expandedNodes++;
//            System.out.println(temp.hash());
            for(int i = 0;i<children.size();i++){
                if(!(inFrontier.containsKey(children.get(i).hash())) && !(explored.containsKey(children.get(i).hash()))) {
                    if (isGoal(children.get(i))) {
                        result(children.get(i));
                        return true;
                    }
                    frontier.push(children.get(i));
                    inFrontierDepth.put(children.get(i).hash(), depth+1);
                    inFrontier.put(children.get(i).hash(), true);
                }
            }
        }
        result(null);
        return false;
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
        if(node == null){
            try {
                FileWriter myWriter = new FileWriter("DLS-result(IDS).txt");
                myWriter.close();
            }  catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            } finally {
                return;
            }
        }
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
            FileWriter myWriter = new FileWriter("DLS-result(IDS).txt");
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

