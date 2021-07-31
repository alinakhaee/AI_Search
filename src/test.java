public class test {
    public static void main(String[] args) {
        Visualizer visualizer = new Visualizer();

        //HARD CODE WAY
//        //initialization of the map
//        //G for normal ground
//        //S for swamp
//        //K for key
//        //C for castle
//        //L for Loot
//        //B for bandit
//        //W for wildAnimals
//        //P for bridge
//        Player player = new Player(0,1,100,100);
//        //indexes start from zero
//        System.out.println("player position: "+player.i+" "+player.j);
//        Map map = new Map(7,6);
//        map.addEntity(0,0,new Bandit(50));
//        map.addEntity(0,1,new BaseEntity('G'));
//        map.addEntity(0,2,new BaseEntity('S'));
//        map.addEntity(0,3,new Bandit(150));
//        map.addEntity(0,4,new BaseEntity('G'));
//        map.addEntity(0,5,new BaseEntity('G'));
//        map.addEntity(1,0,new BaseEntity('S'));
//        map.addEntity(1,1,new Bridge());
//        map.addEntity(1,2,new BaseEntity('G'));
//        map.addEntity(1,3,new BaseEntity('S'));
//        map.addEntity(1,4,new Bridge());
//        map.addEntity(1,5,new Bandit(50));
//        map.addEntity(2,0,new Loot(50,50));
//        map.addEntity(2,1,new BaseEntity('G'));
//        map.addEntity(2,2,new WildAnimall(150));
//        map.addEntity(2,3,new BaseEntity('G'));
//        map.addEntity(2,4,new BaseEntity('G'));
//        map.addEntity(2,5,new BaseEntity('G'));
//        map.addEntity(3,0,new BaseEntity('G'));
//        map.addEntity(3,1,new WildAnimall(50));
//        map.addEntity(3,2,new Loot(50,50));
//        map.addEntity(3,3,new BaseEntity('G'));
//        map.addEntity(3,4,new Bandit(150));
//        map.addEntity(3,5,new BaseEntity('S'));
//        map.addEntity(4,0,new BaseEntity('G'));
//        map.addEntity(4,1,new Bandit(50));
//        map.addEntity(4,2,new BaseEntity('G'));
//        map.addEntity(4,3,new BaseEntity('G'));
//        map.addEntity(4,4,new BaseEntity('C'));
//        map.addEntity(4,5,new WildAnimall(200));
//        map.addEntity(5,0,new BaseEntity('S'));
//        map.addEntity(5,1,new BaseEntity('G'));
//        map.addEntity(5,2,new Loot(100,100));
//        map.addEntity(5,3,new BaseEntity('G'));
//        map.addEntity(5,4,new BaseEntity('S'));
//        map.addEntity(5,5,new BaseEntity('G'));
//        map.addEntity(6,0,new Bandit(100));
//        map.addEntity(6,1,new BaseEntity('K'));
//        map.addEntity(6,2,new BaseEntity('S'));
//        map.addEntity(6,3,new BaseEntity('G'));
//        map.addEntity(6,4,new BaseEntity('S'));
//        map.addEntity(6,5,new BaseEntity('S'));

//        //test 1
//        Map map = new Map(7,6);
//        Player player = new Player(2,5,100,100);
//        map.addEntity(0,0,new Bandit(50));
//        map.addEntity(0,1,new BaseEntity('G'));
//        map.addEntity(0,2,new BaseEntity('S'));
//        map.addEntity(0,3,new Bandit(150));
//        map.addEntity(0,4,new BaseEntity('G'));
//        map.addEntity(0,5,new BaseEntity('G'));
//        map.addEntity(1,0,new BaseEntity('S'));
//        map.addEntity(1,1,new Bridge());
//        map.addEntity(1,2,new BaseEntity('G'));
//        map.addEntity(1,3,new BaseEntity('S'));
//        map.addEntity(1,4,new Bridge());
//        map.addEntity(1,5,new Bandit(25));
//        map.addEntity(2,0,new Loot(50,50));
//        map.addEntity(2,1,new  BaseEntity('G'));
//        map.addEntity(2,2,new WildAnimall(150));
//        map.addEntity(2,3,new BaseEntity('G'));
//        map.addEntity(2,4,new BaseEntity('G'));
//        map.addEntity(2,5,new BaseEntity('G'));
//        map.addEntity(3,0,new BaseEntity('G'));
//        map.addEntity(3,1,new WildAnimall(50));
//        map.addEntity(3,2,new Bandit(100));
//        map.addEntity(3,3,new BaseEntity('G'));
//        map.addEntity(3,4,new Bandit(150));
//        map.addEntity(3,5,new BaseEntity('S'));
//        map.addEntity(4,0,new BaseEntity('G'));
//        map.addEntity(4,1,new Bandit(50));
//        map.addEntity(4,2,new BaseEntity('G'));
//        map.addEntity(4,3,new Bandit(99));
//        map.addEntity(4,4,new BaseEntity('C'));
//        map.addEntity(4,5,new WildAnimall(200));
//        map.addEntity(5,0,new BaseEntity('S'));
//        map.addEntity(5,1,new BaseEntity('G'));
//        map.addEntity(5,2,new Loot(100,100));
//        map.addEntity(5,3,new BaseEntity('G'));
//        map.addEntity(5,4,new BaseEntity('S'));
//        map.addEntity(5,5,new BaseEntity('G'));
//        map.addEntity(6,0,new Bandit(100));
//        map.addEntity(6,1,new BaseEntity('K'));
//        map.addEntity(6,2,new BaseEntity('S'));
//        map.addEntity(6,3,new BaseEntity('G'));
//        map.addEntity(6,4,new BaseEntity('S'));
//        map.addEntity(6,5,new BaseEntity('S'));

//        //test 2
//        Player player = new Player(4,4,5,105);
//        Map map = new Map(5,5);
//        map.addEntity(0,0,new BaseEntity('G'));
//        map.addEntity(0,1,new BaseEntity('G'));
//        map.addEntity(0,2,new BaseEntity('G'));
//        map.addEntity(0,3,new Bandit(50));
//        map.addEntity(0,4,new BaseEntity('C'));
//        map.addEntity(1,0,new BaseEntity('S'));
//        map.addEntity(1,1,new BaseEntity('K'));
//        map.addEntity(1,2,new Bridge());
//        map.addEntity(1,3,new BaseEntity('S'));
//        map.addEntity(1,4,new Bandit(100));
//        map.addEntity(2,0,new Loot(50,50));
//        map.addEntity(2,1,new  WildAnimall(50));
//        map.addEntity(2,2,new BaseEntity('G'));
//        map.addEntity(2,3,new BaseEntity('G'));
//        map.addEntity(2,4,new Bandit(100));
//        map.addEntity(3,0,new WildAnimall(100));
//        map.addEntity(3,1,new BaseEntity('G'));
//        map.addEntity(3,2,new BaseEntity('S'));
//        map.addEntity(3,3,new BaseEntity('S'));
//        map.addEntity(3,4,new BaseEntity('G'));
//        map.addEntity(4,0,new BaseEntity('G'));
//        map.addEntity(4,1,new Bridge());
//        map.addEntity(4,2,new BaseEntity('G'));
//        map.addEntity(4,3,new BaseEntity('G'));
//        map.addEntity(4,4,new BaseEntity('G'));

        //test 3
//        Player player = new Player(2,2,5,105);
//        Map map = new Map(5,5);
//        map.addEntity(0,0,new WildAnimall(100));
//        map.addEntity(0,1,new Bridge());
//        map.addEntity(0,2,new BaseEntity('G'));
//        map.addEntity(0,3,new Loot(100,100));
//        map.addEntity(0,4,new BaseEntity('S'));
//        map.addEntity(1,0,new BaseEntity('G'));
//        map.addEntity(1,1,new BaseEntity('G'));
//        map.addEntity(1,2,new BaseEntity('S'));
//        map.addEntity(1,3,new BaseEntity('G'));
//        map.addEntity(1,4,new Bandit(100));
//        map.addEntity(2,0,new WildAnimall(200));
//        map.addEntity(2,1,new Bridge());
//        map.addEntity(2,2,new BaseEntity('G'));
//        map.addEntity(2,3,new Bridge());
//        map.addEntity(2,4,new Bandit(100));
//        map.addEntity(3,0,new BaseEntity('S'));
//        map.addEntity(3,1,new BaseEntity('S'));
//        map.addEntity(3,2,new BaseEntity('S'));
//        map.addEntity(3,3,new Bandit(500));
//        map.addEntity(3,4,new BaseEntity('K'));
//        map.addEntity(4,0,new BaseEntity('C'));
//        map.addEntity(4,1,new WildAnimall(100));
//        map.addEntity(4,2,new BaseEntity('G'));
//        map.addEntity(4,3,new BaseEntity('G'));
//        map.addEntity(4,4,new Bridge());

        //test 4
//        Player player = new Player(0,0,105,5);
//        Map map = new Map(5,5);
//        map.addEntity(0,0,new BaseEntity('G'));
//        map.addEntity(0,1,new Bridge());
//        map.addEntity(0,2,new Bandit(100));
//        map.addEntity(0,3,new Loot(50,100));
//        map.addEntity(0,4,new WildAnimall(100));
//        map.addEntity(1,0,new BaseEntity('S'));
//        map.addEntity(1,1,new  Loot(100,100));
//        map.addEntity(1,2,new Bridge());
//        map.addEntity(1,3,new Bandit(100));
//        map.addEntity(1,4,new Loot(100,100));
//        map.addEntity(2,0,new BaseEntity('K'));
//        map.addEntity(2,1,new WildAnimall(100));
//        map.addEntity(2,2,new BaseEntity('S'));
//        map.addEntity(2,3,new BaseEntity('S'));
//        map.addEntity(2,4,new Loot(500,500));
//        map.addEntity(3,0,new BaseEntity('G'));
//        map.addEntity(3,1,new BaseEntity('G'));
//        map.addEntity(3,2,new WildAnimall(800));
//        map.addEntity(3,3,new Bandit(100));
//        map.addEntity(3,4,new BaseEntity('S'));
//        map.addEntity(4,0,new Bandit(100));
//        map.addEntity(4,1,new Bandit(100));
//        map.addEntity(4,2,new Loot(100,100));
//        map.addEntity(4,3,new WildAnimall(100));
//        map.addEntity(4,4,new BaseEntity('C'));

//        //test 5
//        Player player = new Player(0,4,5,105);
//        Map map = new Map(5,5);
//        map.addEntity(0,0,new WildAnimall(100));
//        map.addEntity(0,1,new Bandit(100));
//        map.addEntity(0,2,new BaseEntity('C'));
//        map.addEntity(0,3,new BaseEntity('S'));
//        map.addEntity(0,4,new BaseEntity('G'));
//        map.addEntity(1,0,new Bandit(100));
//        map.addEntity(1,1,new  BaseEntity('S'));
//        map.addEntity(1,2,new BaseEntity('S'));
//        map.addEntity(1,3,new BaseEntity('S'));
//        map.addEntity(1,4,new Bridge());
//        map.addEntity(2,0,new BaseEntity('G'));
//        map.addEntity(2,1,new Loot(100,100));
//        map.addEntity(2,2,new BaseEntity('S'));
//        map.addEntity(2,3,new Loot(100,100));
//        map.addEntity(2,4,new BaseEntity('G'));
//        map.addEntity(3,0,new Bridge());
//        map.addEntity(3,1,new WildAnimall(100));
//        map.addEntity(3,2,new Loot(100,100));
//        map.addEntity(3,3,new BaseEntity('G'));
//        map.addEntity(3,4,new Bandit(100));
//        map.addEntity(4,0,new Loot(100,100));
//        map.addEntity(4,1,new BaseEntity('G'));
//        map.addEntity(4,2,new Bridge());
//        map.addEntity(4,3,new WildAnimall(100));
//        map.addEntity(4,4,new BaseEntity('K'));

////        test 6
//        Player player = new Player(3,2,150,100);
//        Map map = new Map(5,5);
//        map.addEntity(0,0,new BaseEntity('G'));
//        map.addEntity(0,1,new BaseEntity('K'));
//        map.addEntity(0,2,new BaseEntity('G'));
//        map.addEntity(0,3,new BaseEntity('S'));
//        map.addEntity(0,4,new BaseEntity('C'));
//        map.addEntity(1,0,new BaseEntity('G'));
//        map.addEntity(1,1,new  Loot(25,100));
//        map.addEntity(1,2,new Bandit(50));
//        map.addEntity(1,3,new BaseEntity('S'));
//        map.addEntity(1,4,new Loot(50,50));
//        map.addEntity(2,0,new Bandit(50));
//        map.addEntity(2,1,new BaseEntity('S'));
//        map.addEntity(2,2,new BaseEntity('G'));
//        map.addEntity(2,3,new BaseEntity('G'));
//        map.addEntity(2,4,new WildAnimall(100));
//        map.addEntity(3,0,new BaseEntity('G'));
//        map.addEntity(3,1,new WildAnimall(50));
//        map.addEntity(3,2,new BaseEntity('G'));
//        map.addEntity(3,3,new Bandit(100));
//        map.addEntity(3,4,new BaseEntity('G'));
//        map.addEntity(4,0,new BaseEntity('G'));
//        map.addEntity(4,1,new BaseEntity('G'));
//        map.addEntity(4,2,new Bridge());
//        map.addEntity(4,3,new WildAnimall(100));
//        map.addEntity(4,4,new BaseEntity('G'));

//        //test 7
//        Player player = new Player(0,4,220,140);
//        Map map = new Map(5,5);
//        map.addEntity(0,0,new BaseEntity('C'));
//        map.addEntity(0,1,new Bandit(250));
//        map.addEntity(0,2,new BaseEntity('G'));
//        map.addEntity(0,3,new Bridge());
//        map.addEntity(0,4,new BaseEntity('G'));
//        map.addEntity(1,0,new WildAnimall(200));
//        map.addEntity(1,1,new  BaseEntity('S'));
//        map.addEntity(1,2,new BaseEntity('G'));
//        map.addEntity(1,3,new BaseEntity('G'));
//        map.addEntity(1,4,new BaseEntity('S'));
//        map.addEntity(2,0,new Bridge());
//        map.addEntity(2,1,new BaseEntity('G'));
//        map.addEntity(2,2,new Bandit(100));
//        map.addEntity(2,3,new BaseEntity('G'));
//        map.addEntity(2,4,new BaseEntity('G'));
//        map.addEntity(3,0,new BaseEntity('G'));
//        map.addEntity(3,1,new BaseEntity('G'));
//        map.addEntity(3,2,new Loot(100,100));
//        map.addEntity(3,3,new WildAnimall(60));
//        map.addEntity(3,4,new BaseEntity('G'));
//        map.addEntity(4,0,new BaseEntity('K'));
//        map.addEntity(4,1,new BaseEntity('S'));
//        map.addEntity(4,2,new BaseEntity('G'));
//        map.addEntity(4,3,new BaseEntity('G'));
//        map.addEntity(4,4,new BaseEntity('G'));

//        // test final 1
//        Player player = new Player(0,4,220,140);
//
//        Map map = new Map(5,5);
//
//        map.addEntity(0,0,new BaseEntity('C'));
//        map.addEntity(0,1,new Bandit(450));
//        map.addEntity(0,2,new Bridge());
//        map.addEntity(0,3,new Bridge());
//        map.addEntity(0,4,new BaseEntity('G'));
//        map.addEntity(1,0,new WildAnimall(200));
//        map.addEntity(1,1,new  BaseEntity('S'));
//        map.addEntity(1,2,new BaseEntity('G'));
//        map.addEntity(1,3,new BaseEntity('G'));
//        map.addEntity(1,4,new BaseEntity('S'));
//        map.addEntity(2,0,new Bridge());
//        map.addEntity(2,1,new BaseEntity('G'));
//        map.addEntity(2,2,new Bandit(100));
//        map.addEntity(2,3,new BaseEntity('G'));
//        map.addEntity(2,4,new BaseEntity('G'));
//        map.addEntity(3,0,new BaseEntity('G'));
//        map.addEntity(3,1,new BaseEntity('G'));
//        map.addEntity(3,2,new Loot(100,100));
//        map.addEntity(3,3,new WildAnimall(60));
//        map.addEntity(3,4,new Bandit(400));
//        map.addEntity(4,0,new BaseEntity('K'));
//        map.addEntity(4,1,new BaseEntity('S'));
//        map.addEntity(4,2,new BaseEntity('G'));
//        map.addEntity(4,3,new BaseEntity('G'));
//        map.addEntity(4,4,new WildAnimall(6000));

        //test final 2
        Player player = new Player(0,4,1,1);
        Map map = new Map(5,5);
        map.addEntity(0,0,new BaseEntity('S'));
        map.addEntity(0,1,new WildAnimall(1000));
        map.addEntity(0,2,new BaseEntity('S'));
        map.addEntity(0,3,new Bridge());
        map.addEntity(0,4,new BaseEntity('G'));
        map.addEntity(1,0,new Loot(100,100));
        map.addEntity(1,1,new Loot(100,100));
        map.addEntity(1,2,new BaseEntity('G'));
        map.addEntity(1,3,new Loot(1000,1000));
        map.addEntity(1,4,new Bandit(50));
        map.addEntity(2,0,new WildAnimall(1000));
        map.addEntity(2,1,new BaseEntity('S'));
        map.addEntity(2,2,new Bandit(100));
        map.addEntity(2,3,new BaseEntity('S'));
        map.addEntity(2,4,new BaseEntity('K'));
        map.addEntity(3,0,new BaseEntity('G'));
        map.addEntity(3,1,new BaseEntity('S'));
        map.addEntity(3,2,new Bridge());
        map.addEntity(3,3,new BaseEntity('S'));
        map.addEntity(3,4,new BaseEntity('S'));
        map.addEntity(4,0,new BaseEntity('S'));
        map.addEntity(4,1,new BaseEntity('G'));
        map.addEntity(4,2,new BaseEntity('G'));
        map.addEntity(4,3,new WildAnimall(1000));
        map.addEntity(4,4,new BaseEntity('C'));

        //MANUAL WAY
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Player (i, j, money, food) : ");
//        Player player = new Player(scanner.nextInt(),scanner.nextInt(),scanner.nextInt(),scanner.nextInt());
//        System.out.print("Map (rows, columns) : ");
//        Map map = new Map(scanner.nextInt(),scanner.nextInt());
//        for(int i=0 ; i<map.rows ; i++)
//            for(int j=0 ; j<map.cols ; j++)
//                map.addEntity(i, j, new BaseEntity('G'));
//
//        while (true){
//            System.out.print("Entity (i, j, type, [power, money], [food]) (-1 to end) : ");
//            int i = scanner.nextInt();
//            if(i == -1)
//                break;
//            int j = scanner.nextInt();
//            char type = scanner.next().toUpperCase().charAt(0);
//            if(type == 'G' || type == 'S'|| type == 'C' || type == 'K')
//                map.changeEntity(i, j, new BaseEntity(type));
//            else if(type == 'P')
//                map.changeEntity(i, j, new Bridge());
//            else if(type == 'B')
//                map.changeEntity(i, j, new Bandit(scanner.nextInt()));
//            else if(type == 'W')
//                map.changeEntity(i, j, new WildAnimall(scanner.nextInt()));
//            else if(type == 'L')
//                map.changeEntity(i, j, new Loot(scanner.nextInt(), scanner.nextInt()));
//        }

        //print method prints the map
        map.print();
        visualizer.printMap(map, player);
        Node node = new Node(player,map,null,null);
        BFS bfs = new BFS();
        bfs.writeInFile = true;
        DFS dfs = new DFS();
        IDS ids = new IDS();
        BDS bds = new BDS();
        AStar aStar = new AStar();
        IDAStar idaStar = new IDAStar();
        RBFS rbfs = new RBFS();
        System.out.println("**************************************************** BFS ****************************************************");
        bfs.search(node);
        System.out.println("BFS expanded nodes : " + bfs.expandedNodes);
//
//        System.out.println("**************************************************** DFS ****************************************************");
//        dfs.search(node);
//        System.out.println("DFS expanded nodes : " + dfs.nodeExpanded);

//        System.out.println("**************************************************** IDS ****************************************************");
//        ids.search(node, 30);
//        System.out.println("IDS expanded nodes : " + ids.expandedNodes);

//        System.out.println("**************************************************** BDS ****************************************************");
//        Node finalState = bfs.finalState;
//        finalState.parentNode = null;
//        bds.search(node, finalState);
//        System.out.println("BDS expanded nodes : " + bds.expandedNodes);
//
//        System.out.println("**************************************************** A* ****************************************************");
//        aStar.search(node);
//        System.out.println("A* expanded nodes : " + aStar.expandedNodes);
//
//        System.out.println("**************************************************** IDA* ****************************************************");
//        idaStar.search(node);
//        System.out.println("IDA* expanded nodes : " + idaStar.expandedNodes);
//
        System.out.println("**************************************************** RBFS ****************************************************");
        rbfs.search(node);
        System.out.println(rbfs.expandedNodes);
    }
}
