public interface GraphADT <T> {
    /**
     * Will add a node to the graph.
     *
     * @param id a string that keeps track of the node we would like to add.
     * @param value a value we would like to add to our graph.
     */
    void addNode(String id, T value);

    /**
     * Will add an edge between the two specified nodes.
     * If one (or both) of the edges do not exist in the graph it will do nothing.
     *
     * @param id1 a string that keeps track of the first node.
     * @param id2 a string that keeps track of the second node.
     */
    void addEdge(String id1, String id2);

    /**
     * Will set the specified existing node's value.
     * If the specified node does not exist in the graph it will do nothing.
     *
     * @param id a string that keeps track of the existing node in the graph.
     * @param value a generic type variable that we would like to set in the graph.
     */
    void setNode(String id, T value);

    /**
     * Will return the value of the specified node.
     *
     * @param id a string that keeps track of the node we would like to get in the graph.
     *
     * @return Will return a value of generic type T of the specified node,
     *         if the specified node does not exist in the graph it will return null.
     */
    T getNode(String id);

    /**
     * Will return an array of Strings that is populated with each of the node ids in the graph.
     *
     * @return Will return an array of Strings that is populated with each of the node ids in the graph,
     *         if there are no nodes in the graph it returns an empty String array.
     */
    String[] getNodeIds();

    /**
     * Will remove the specified node from the graph (and all of the edges connected to it).
     * If the specified node does not exist in the graph it will do nothing.
     *
     * @param id a string that keeps track of the node we would like to remove in the graph.
     */
    void removeNode(String id);

    /**
     * Will remove the edge between the two specified nodes.
     * If one (or both) of the edges do not exist in the graph,
     * or there is not an edge already between them, it will do nothing.
     *
     * @param id1 a string that keeps track of the first node.
     * @param id2 a string that keeps track of the second node.
     */
    void removeEdge(String id1, String id2);

    /**
     * Will get the number of nodes in the graph.
     *
     * @return Will return an integer value of how many nodes are on the graph.
     */
    int countNodes();

    /**
     * Will get the number of edges in the graph.
     *
     * @return Will return an integer value of how many edges are on the graph.
     */
    int countEdges();

    /**
     * Will get the value of the genus.
     *
     * @return Will return an integer value of the genus.
     */
    int genus();

    /**
     * Will return a String that represents the graph.
     *
     * @return Will return a String that represents the graph and each node in the graph,
     *         including the value of that node, and the other nodes that it is connected to.
     */
    String toString();
}
