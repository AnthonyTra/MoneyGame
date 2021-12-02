public class Graph <T> implements GraphADT <T> {

    protected class Vertex<T> {
        T object;
        String id;
        Vertex[] connections;

        /**
         * Default constructor for the vertex private class.
         *
         * @param object a generic type T variable to store the value of our vertex in.
         * @param id a string variable to identify our graph by.
         */
        Vertex(T object, String id) {
            this.object = object;
            this.id = id;
            connections = new Vertex[0];
        }
    }

    Vertex[] collection; // An array to keep our vertex's in.

    /**
     * Constructor for the class.
     */
    public Graph() {
        collection = new Vertex[0];
    }

    /**
     * Will add a node to the graph.
     *
     * @param id a string that keeps track of the node we would like to add.
     * @param value a value we would like to add to our graph.
     */
    @Override
    public void addNode(String id, T value) {
        if (!repeatedNode(id)) {
            return;
        }
        Vertex<T> temp = new Vertex<>(value, id); // Creates new vertex.
        int n = collection.length + 1; // Size of new array.
        Vertex[] tmp = new Vertex[n]; // Create a new temp array with an increased size of 1.

        // Copy old vertexes into new array.
        for (int i = 0; i < collection.length; i++) {
            tmp[i] = collection[i];
        }

        tmp[n - 1] = temp; // Add new vertex into new array.
        collection = tmp; // Set old array equal to the new array.
    }

    private Boolean repeatedNode(String id) {
        for (Vertex vertex : collection) { // Loop through the vertex's.
            if (vertex.id.equals(id)) { // Compares the id we are trying to create and the graph's id's.
                return false; // If any id's in the collection match the one we are trying to create, then return false.
            }
        }
        return true; // Return true if no repeated node.
    }

    /**
     * Will add an edge between the two specified nodes.
     * If one (or both) of the edges do not exist in the graph it will do nothing.
     *
     * @param id1 a string that keeps track of the first node.
     * @param id2 a string that keeps track of the second node.
     */
    @Override
    public void addEdge(String id1, String id2) {
        Vertex<T> tempOne = null; // Variable to keep our 1st vertex in.
        Vertex<T> tempTwo = null; // Variable to keep our 2nd vertex in.
        int k = 0;
        int h = 0;
        int m = 0;

        while (k < collection.length) { // Loop through the vertex array.
            if (collection[k].id.equals(id1)) {
                tempOne = collection[k]; // If the vertex is found then set our counter variable to the 1st vertex.
                h = k; // Variable to keep track of where this vertex is in the array.
            } else if (collection[k].id.equals(id2)) {
                tempTwo = collection[k]; // If the vertex is found then set our counter variable to the 2nd vertex.
                m = k; // Variable to keep track of where this vertex is in the array.
            }
            k++;
        }

        if (!validateIds(tempOne, tempTwo, h, m)) {
            return; // If the validation test doesn't pass, then return.
        }

        // Add second edge to the first vertex.
        if (collection[h].id.equals(id1)) {
            int n = collection[h].connections.length + 1; // Create new length for our array.
            Vertex[] tmp = new Vertex[n]; // Create new temporary array.
            for (int j = 0; j < collection[h].connections.length; j++) {
                tmp[j] = collection[h].connections[j]; // Loop through the for loop and copy the array.
            }
            tmp[n - 1] = tempTwo; // Copy the new element to the temporary array.
            collection[h].connections = tmp; // Set old array equal to the temporary one.
        }

        // Add first edge to the second vertex.
        if (collection[m].id.equals(id2)) {
            int n = collection[m].connections.length + 1; // Create new length for our array.
            Vertex[] tmp = new Vertex[n]; // Create new temporary array.
            for (int j = 0; j < collection[m].connections.length; j++) {
                tmp[j] = collection[m].connections[j]; // Loop through the for loop and copy the array.
            }
            tmp[n - 1] = tempOne; // Copy the new element to the temporary array.
            collection[m].connections = tmp; // Set old array equal to the temporary one.
        }
    }

    /**
     * Validates the vertex's to make sure that both vertex's are not null or repeated edges.
     *
     * @param tempOne a generic type T variable of our first vertex.
     * @param tempTwo a generic type T variable of our second vertex.
     * @param h an int variable of where our first vertex is in the connections array.
     * @param m an int variable of where our second vertex is in the connections array.
     *
     * @return a Boolean variable of whether our vertex's are valid or not.
     */
    private Boolean validateIds(Vertex<T> tempOne, Vertex<T> tempTwo, int h, int m) {
        if (tempOne == null || tempTwo == null) {
            return false; // Returns false if one of the vertex's is null.
        }
        return repeatedEdge(tempOne, tempTwo, h, m); // Returns false if there is a repeated edge we are trying to add.
        // Returns true if all the tests pass.
    }

    /**
     * Validates the vertex's connections array to make sure there are no repeated edges.
     *
     * @param one a generic type T variable of our first vertex.
     * @param two a generic type T variable of our second vertex.
     * @param compOne an int variable of where our first vertex is in the connections array.
     * @param compTwo an int variable of where our second vertex is in the connections array.
     *
     * @return a Boolean variable of whether are edges repeat or not.
     */
    private Boolean repeatedEdge(Vertex<T> one, Vertex<T> two, int compOne, int compTwo) {
        for(int i = 0; i < collection[compOne].connections.length; i++) {
            // If our second vertex is in our first vertex's connections array then return false.
            if(collection[compOne].connections[i].id.equals(two.id)) {
                return false;
            }
        }
        for(int i = 0; i < collection[compTwo].connections.length; i++) {
            // If our first vertex is in our second vertex's connections array then return false.
            if (collection[compTwo].connections[i].id.equals(one.id)) {
                return false;
            }
        }
        return true; // Return true if it passes all the tests.
    }

    /**
     * Will set the specified existing node's value.
     * If the specified node does not exist in the graph it will do nothing.
     *
     * @param id a string that keeps track of the existing node in the graph.
     * @param value a generic type variable that we would like to set in the graph.
     */
    @Override
    public void setNode(String id, T value) {
        for (Vertex vertex : collection) { // Loop through our vertex's to find the vertex we want to change.
            if (vertex.id.equals(id)) {
                vertex.object = value; // Set the old value of our vertex to the new value we want.
                return; // Return once it changes the value.
            }
        }
    }

    /**
     * Will return the value of the specified node.
     *
     * @param id a string that keeps track of the node we would like to get in the graph.
     * @return Will return a value of generic type T of the specified node,
     * if the specified node does not exist in the graph it will return null.
     */
    @Override
    public T getNode(String id) {
        for (Vertex vertex : collection) { // Loop through our vertex's to find the vertex we want to retrieve.
            if (vertex.id.equals(id)) {
                return (T) vertex.object; // Return the value of our vertex we want to find if it is found.
            }
        }
        return null; // Return null if the vertex is not in the array.
    }

    /**
     * Will return an array of Strings that is populated with each of the node ids in the graph.
     *
     * @return Will return an array of Strings that is populated with each of the node ids in the graph,
     * if there are no nodes in the graph it returns an empty String array.
     */
    @Override
    public String[] getNodeIds() {
        String[] nodeIds = new String[collection.length]; // Create a string array to store our node id's in.
        for(int i = 0; i < collection.length; i++) {
           nodeIds[i] = collection[i].id; // Add each vertex's id into the string array.
        }
        return nodeIds; // Return the string array of ids.
    }

    /**
     * Will remove the specified node from the graph (and all of the edges connected to it).
     * If the specified node does not exist in the graph it will do nothing.
     *
     * @param id a string that keeps track of the node we would like to remove in the graph.
     */
    @Override
    public void removeNode(String id) {
        int k = 0; // Counter variable.
        Vertex<T> tempOne = null; // Variable to keep our vertex we want to remove in.

        while (k < collection.length) {
            // If it finds the vertex we want, then set the temporary variable equal to the object of the vertex we found.
            if(collection[k].id.equals(id)) {
                tempOne = collection[k]; //
            }
            k++;
        }

        if(tempOne == null) { // If our vertex's object is null, then return.
            return;
        }

        int h = 0;
        int n = collection.length - 1; // Size of new array.
        Vertex[] tmp = new Vertex[n]; // Create a new temp array with an increased size of 1.

        for(int i = 0; i < collection.length - 1; i++) {
            // Copy everything over from the old array except the node we are trying to remove.
            if(!collection[i].id.equals(id)) {
                tmp[i] = collection[h];
            }
            // Skip the variable we are trying to remove.
            else if(collection[i].id.equals(id)) {
                h = i + 1;
                tmp[i] = collection[h];
            }
            h++;
        }
        // Calls this method to remove the node from all of the connections array of each vertex.
        removeConnectionFromAll(tempOne);
        collection = tmp; // Set the old collections array to the temporary one.
    }

    /**
     * Will remove the specified node from all of the vertex's connections array.
     *
     * @param tempOne a generic type T variable of the vertex,
     *                we are trying to remove from all of the connections array.
     */
    private void removeConnectionFromAll(Vertex<T> tempOne) {
        for(int i = 0; i < collection.length; i++) { // Loops through the array of vertexes.

            // Loops through the vertex's connections array one by one.
            for(int j = 0; j < collection[i].connections.length; j++) {

                // Checks If the removed edge is connected to one of the other vertexes, creates new array if it is.
                if(collection[i].connections[j].equals(tempOne)) {

                    int h = 0; // Counter variable
                    int n = collection[i].connections.length - 1; // Create new length for the temporary array.
                    Vertex[] tmp = new Vertex[n]; // Create the temporary array.

                    for(int k = 0; k < n; k++) { // Loops through the new size for the matched vertex's connections array.

                        if(!collection[i].connections[k].equals(tempOne)) { // Checks if the removed edge is on a certain element.
                            tmp[k] = collection[i].connections[h]; // If it is not the removed edge, them assign it to the temp array.
                        }
                        // If it is the removed edge assign the variable after it to the array.
                        else if(collection[i].connections[k].equals(tempOne)) {
                            h = k + 1; // Update counter variable to the spot after the edge we are trying to remove.
                            tmp[k] = collection[i].connections[h]; // Assign the variable after the removed edge to the array.
                        }
                        h++; // Increment h
                    }
                    collection[i].connections = tmp; // Assign the vertex's connections array to the temporary one.
                }
            }
        }
    }

    /**
     * Will remove the edge between the two specified nodes.
     * If one (or both) of the edges do not exist in the graph,
     * or there is not an edge already between them, it will do nothing.
     *
     * @param id1 a string that keeps track of the first node.
     * @param id2 a string that keeps track of the second node.
     */
    @Override
    public void removeEdge(String id1, String id2) {
        int k = 0;
        int m = 0;
        int h = 0;
        Vertex<T> tempOne = null; // Variable to keep our 1st vertex in.
        Vertex<T> tempTwo = null; // Variable to keep our 2nd vertex in.

        while (k < collection.length) { // Loop through the vertex array.
            if (collection[k].id.equals(id1)) {
                tempOne = collection[k]; // If the vertex is found then set our counter variable to the 1st vertex.
                h = k; // Variable to keep track of where this vertex is in the array.
            } else if (collection[k].id.equals(id2)) {
                tempTwo = collection[k]; // If the vertex is found then set our counter variable to the 2nd vertex.
                m = k; // Variable to keep track of where this vertex is in the array.
            }
            k++;
        }

        if(tempOne == null || tempTwo == null) {
            return; // If one of the vertex's are empty, then return.
        }
        else if(collection[h].connections.length == 0 || collection[m].connections.length == 0) {
            return; // If one of the vertex's connections array is empty, then return.
        }

            if(collection[h].equals(tempOne)) {
                int j = 0; // Counter variable
                int n = collection[h].connections.length - 1;
                Vertex[] tmp = new Vertex[n]; // New temporary array.
                for (int i = 0; i < n; i++) {
                    // Add the edge to the array if it isn't the edge we are trying to remove.
                    if (!collection[h].connections[i].equals(tempTwo)) {
                        tmp[i] = collection[h].connections[j];
                    }
                    else if (collection[h].connections[i].equals(tempTwo)) {
                        j = i + 1;
                        tmp[i] = collection[h].connections[j]; // Skip the edge we are trying to remove.
                    }
                    j++;
                }
                collection[h].connections = tmp; // Set old array equal to the temporary one.
            }
            if (collection[m].equals(tempTwo)) {
                int j = 0;
                int n = collection[m].connections.length - 1;
                Vertex[] tmp = new Vertex[n]; // New temporary array.
                for(int i = 0; i < n; i++) {
                    // Add the edge to the array if it isn't the edge we are trying to remove.
                    if(!collection[m].connections[i].equals(tempOne)) {
                        tmp[i] = collection[m].connections[j];
                    }
                    else if (collection[m].connections[i].equals(tempOne)) {
                        j = i + 1;
                        tmp[i] = collection[m].connections[j]; // Skip the edge we are trying to remove.
                    }
                    j++;
                }
                collection[m].connections = tmp; // Set old array equal to the temporary one.
            }
        }

    /**
     * Will get the number of nodes in the graph.
     *
     * @return Will return an integer value of how many nodes are on the graph.
     */
    @Override
    public int countNodes() {
        return collection.length;
    }

    /**
     * Will get the number of edges in the graph.
     *
     * @return Will return an integer value of how many edges are on the graph.
     */
    @Override
    public int countEdges() {
        int k = 0;
        for(int i = 0; i < collection.length; i++) { // Loop through the vertex's.
            for(int j = 0; j < collection[i].connections.length; j++) {
                k++; // Increment k for how many edges there are in each connections array.
            }
        }
        k = k / 2; // Divide k by 2 to account for the repeated edges it counted.
        return k; // Returns the number of edges there are in the graph.
    }

    /**
     * Will get the value of the genus.
     *
     * @return Will return an integer value of the genus.
     */
    @Override
    public int genus() {
        return (countEdges() - countNodes()) + 1; // Returns the genus of the graph.
    }

    /**
     * Will return a String that represents the graph.
     *
     * @return Will return a String that represents the graph and each node in the graph,
     *         including the value of that node, and the other nodes that it is connected to.
     */
    @Override
    public String toString() {
        String returnString = "";
        for (int i = 0; i < collection.length; i++) { // Loop through the vertex's.
            returnString += collection[i].id + "(" + collection[i].object + "): [";
            for (int j = 0; j < collection[i].connections.length; j++) {
                if(j > 0) {
                    returnString += ", "; // Add a comma if there is more than one number.
                }
                returnString += collection[i].connections[j].id; // Add each edge that vertex has.
            }
            returnString += "]" + "\n"; // Close off the array and start printing the next vertex.
        }
        return returnString; // Returns a string that represents the graph.
    }

}
