public class Visualizer {

    //color unicode
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String	REVERSE_VIDEO		= "\u001B[7m";
    public static final String ANSI_BRIGHT_BLACK  = "\u001B[90m";
    public static final String ANSI_BRIGHT_RED    = "\u001B[91m";
    public static final String ANSI_BRIGHT_GREEN  = "\u001B[92m";
    public static final String ANSI_BRIGHT_YELLOW = "\u001B[93m";
    public static final String ANSI_BRIGHT_BLUE   = "\u001B[94m";
    public static final String ANSI_BRIGHT_PURPLE = "\u001B[95m";
    public static final String ANSI_BRIGHT_CYAN   = "\u001B[96m";
    public static final String ANSI_BRIGHT_WHITE  = "\u001B[97m";

    //objects unicode
    private static final String swamp = "\uD83D\uDCA9";
    private static final String wildAnimal = "\uD83E\uDD8A";
    private static final String bandit = "\uD83E\uDDDB";
    private static final String Player = "\uD83D\uDE00";
    private static final String bridge = "\uD83C\uDF09";
    private static final String key = "\uD83D\uDDDD";
    private static final String castle = "\uD83C\uDFF0";
    private static final String L = "\uD83E\uDDF0";

    //print visualized map
    public void printMap(Map map, Player player) {
        for (int i = 0; i <= map.rows * 2; i++) {
            for (int j = 0; j <= map.cols * 2; j++) {
                if (i % 2 == 0) {
                        System.out.print("--");
                } else {
                    if (j % 2 != 0) {
                        if (map.at((i - 1) / 2, (j - 1) / 2).name == 'S')
                            System.out.print(ANSI_YELLOW + swamp + "\t");
                        else if (map.at((i - 1) / 2, (j - 1) / 2).name == 'W')
                            System.out.print(ANSI_BRIGHT_RED + wildAnimal + "\t");
                        else if (map.at((i - 1) / 2, (j - 1) / 2).name == 'B')
                            System.out.print(ANSI_BRIGHT_BLACK + bandit + "\t");
                        else if (player.i == (i - 1) / 2 && player.j == (j - 1) / 2)
                            System.out.print(ANSI_PURPLE + Player + "\t");
                        else if (map.at((i - 1) / 2, (j - 1) / 2).name == 'C')
                            System.out.print(ANSI_YELLOW + castle + "\t");
                        else if (map.at((i - 1) / 2, (j - 1) / 2).name == 'K')
                            System.out.print(ANSI_PURPLE + key + "\t");
                        else if (map.at((i - 1) / 2, (j - 1) / 2).name == 'L')
                            System.out.print(ANSI_BLUE + L);
                        else if (map.at((i - 1) / 2, (j - 1) / 2).name == 'P')
                            System.out.print(ANSI_CYAN + bridge + "\t");
                        else
                            System.out.print(" " + "\t");
                    } else {
                        System.out.print(ANSI_BLACK + "|");
                    }
                }
            }
            System.out.println(ANSI_RESET);
        }
    }

}
