public class GraphTest { // Test File
    public static void main(String[] args) {
        MoneyGame myGame = new MoneyGame();

        myGame.addNode("n1", 0);
        myGame.addNode("n2", 0);
        myGame.addNode("n3", 0);
        myGame.addNode("n4", 0);
        myGame.addNode("n5", -999999);

        myGame.addEdge("n2", "n3");
        myGame.addEdge("n5", "n1");
        myGame.addEdge("n4", "n5");
        myGame.addEdge("n4", "n3");
        myGame.addEdge("n2", "n3");
        myGame.addEdge("n3", "n1");

        System.out.println("Can the game be won: " + myGame.isWinnable());
        System.out.println("Graph: " + "\n" + myGame);
    }
}
