import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class BDS {
    int expandedNodes=0;
    Visualizer visualizer = new Visualizer();
    public void search(Node intialNode, Node finalNode){
        Queue<Node> frontier = new LinkedList<Node>();
        Hashtable<String, Boolean> inFrontier = new Hashtable<>();
        Hashtable<String, Boolean> explored = new Hashtable<>();
        LinkedList<Node> exploredList = new LinkedList<>();

        Queue<Node> reverseFrontier = new LinkedList<Node>();
        Hashtable<String, Boolean> inReverseFrontier = new Hashtable<>();
        Hashtable<String, Boolean> reverseExplored = new Hashtable<>();
        LinkedList<Node> reverseExploredList = new LinkedList<>();

        if(intialNode.hash().equals(finalNode.hash())){
            result(intialNode);
            return;
        }

        frontier.add(intialNode);
        inFrontier.put(intialNode.hash(),true);
        reverseFrontier.add(finalNode);
        inReverseFrontier.put(finalNode.hash(), true);

        while (!frontier.isEmpty() && !reverseFrontier.isEmpty()){
            Node temp = frontier.poll();
            inFrontier.remove(temp.hash());
            explored.put(temp.hash(),true);
            exploredList.add(temp);
            ArrayList<Node> children = temp.successor();
            expandedNodes++;
            for(int i = 0;i<children.size();i++){
                if(!(inFrontier.containsKey(children.get(i).hash())) && !(explored.containsKey(children.get(i).hash()))) {
//                    if (children.get(i).hash().equals(finalNode.hash())) {
//                        result(children.get(i));
//                        return;
//                    }
                    frontier.add(children.get(i));
                    inFrontier.put(children.get(i).hash(), true);
                }
            }

            Set<String> fridgeSharedNodes = new HashSet<String>();
            fridgeSharedNodes.addAll(inFrontier.keySet());
            fridgeSharedNodes.retainAll(inReverseFrontier.keySet());
            if(!fridgeSharedNodes.isEmpty()){
                System.out.println(fridgeSharedNodes);
                String intersectionNode = (String) fridgeSharedNodes.toArray()[0];
                Node nodeInFront = searchInList(intersectionNode, (LinkedList<Node>) frontier);
                Node nodeInReverse = searchInList(intersectionNode, (LinkedList<Node>) reverseFrontier);
                System.out.println("forward search :");
                result(nodeInFront);
                System.out.println("reverse search");
                reverseResult(nodeInReverse);
                return;
            }

            Node reverseTemp = reverseFrontier.poll();
            inReverseFrontier.remove(reverseTemp.hash());
            reverseExplored.put(reverseTemp.hash(), true);
            reverseExploredList.add(reverseTemp);
            ArrayList<Node> reverseChildren = reverseTemp.reverseSuccessor();
            expandedNodes++;
            for(int i = 0;i<reverseChildren.size();i++){
                if(!(inReverseFrontier.containsKey(reverseChildren.get(i).hash())) && !(reverseExplored.containsKey(reverseChildren.get(i).hash()))) {
                    reverseFrontier.add(reverseChildren.get(i));
                    inReverseFrontier.put(reverseChildren.get(i).hash(), true);
                }
            }

            fridgeSharedNodes = new HashSet<String>();
            fridgeSharedNodes.addAll(inFrontier.keySet());
            fridgeSharedNodes.retainAll(inReverseFrontier.keySet());
            if(!fridgeSharedNodes.isEmpty()){
                System.out.println(fridgeSharedNodes);
                String intersectionNode = (String) fridgeSharedNodes.toArray()[0];
                Node nodeInFront = searchInList(intersectionNode, (LinkedList<Node>) frontier);
                Node nodeInReverse = searchInList(intersectionNode, (LinkedList<Node>) reverseFrontier);
                System.out.println("forward search :");
                result(nodeInFront);
                System.out.println("reverse search");
                reverseResult(nodeInReverse);
                return;
            }
        }

        Set<String> exploredSharedNodes = explored.keySet();
        exploredSharedNodes.retainAll(reverseExplored.keySet());
        System.out.println("exploooooored shared nodes : " + exploredSharedNodes);
        if(!exploredSharedNodes.isEmpty()){
            String intersectionNode = (String) exploredSharedNodes.toArray()[exploredSharedNodes.size()-1];
            Node nodeInFront = searchInList(intersectionNode, exploredList);
            Node nodeInReverse = searchInList(intersectionNode, reverseExploredList);
            System.out.println("forward search :");
            result(nodeInFront);
            System.out.println("reverse search");
            reverseResult(nodeInReverse);
            return;
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
            FileWriter myWriter = new FileWriter("BDS-result.txt");
            myWriter.write("from initial node to intersection node :\n");
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

    public void reverseResult(Node node){
        Stack<Node>  nodes = new Stack<>();
        while (true){
            nodes.push(node);
            if(node.parentNode == null){
                break;
            }
            else {
                node = node.parentNode;
            }
        }
        Node finalNode = nodes.pop();
        System.out.println("final state " + finalNode.player.money + " " + finalNode.player.food);
        visualizer.printMap(finalNode.map, finalNode.player);
        try {
            FileWriter myWriter = new FileWriter("BDS-result.txt",true);
            myWriter.write("****************************************************\n");
            myWriter.write("from goal state to intersection node :\nfinal state\n");
            while (!nodes.isEmpty()){
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

    private Node searchInList(String node, LinkedList<Node> list){
        for(Node item : list)
            if(item.hash().equals(node))
                return item;
        return null;
    }
}
