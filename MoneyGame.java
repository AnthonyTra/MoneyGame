public class MoneyGame {
    private Graph<Integer> myGraph = new Graph<>();

    /**
     * Default constructor for the MoneyGame class.
     */
    public MoneyGame() {}

    /**
     * Will add a node to the graph.
     *
     * @param id a string that keeps track of the node we would like to add.
     * @param element a value we would like to add to our graph.
     */
    void addNode(String id, int element) {
        myGraph.addNode(id, element); // Calls the addNode method in the Project3Graph class.
    }

    /**
     * Will add an edge between the two specified nodes.
     * If one (or both) of the edges do not exist in the graph it will do nothing.
     *
     * @param id1 a string that keeps track of the first node.
     * @param id2 a string that keeps track of the second node.
     */
    void addEdge(String id1, String id2) {
        myGraph.addEdge(id1, id2); // Calls the addEdge method in the Project3Graph class.
    }

    /**
     * Will calculate the sum of all the node's values.
     *
     * @return an integer value of the sum of all the node's values.
     */
    int sum() {
        int sum = 0;
        for(int i = 0; i < myGraph.collection.length; i++) {
            // Loop through the vertex array and add each od the vertex's value.
            sum += myGraph.getNode(myGraph.collection[i].id);
        }
        return sum; // Returns the sum of all the node's values.
    }

    /**
     * Will compare the sum and genus to see if the game is winnable or not.
     *
     * @return will return true if the game can be won, and false otherwise.
     */
    boolean isWinnable() {
        return sum() >= myGraph.genus(); // Compares the sum of the all the nodes and the genus of the graph.
    }

    /**
     * Will return a String that represents the graph.
     *
     * @return Will return a String that represents the graph and each node in the graph,
     *         including the value of that node, and the other nodes that it is connected to.
     */
    public String toString() {
        return myGraph.toString(); // Calls the toString method in the Project3Graph class.
    }

}
