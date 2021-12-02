## Overview
For this project I will implement a simple graph data structure that will be used to solve a math problem. The actual programming component of this project will be fairly minimal as the difficulty will come in the design of the data structure itself. 

### The Project3GraphADT interface and Project3Graph class

The `Project3GraphADT` will provide the abstract method declarations that the `Project3Graph` class will implement. In order for us to do some testing, we are going to add the following methods:

* `void addNode(String id, T value)`
* `void addEdge(String id1, String id2)`
* `void setNode(String id, T value)`
* `T getNode(String id)`
* `String[] getNodeIds()`
* `void removeNode(String id)`
* `void removeEdge(String id1, String id2)`
* `int countNodes()`
* `int countEdges()`
* `int genus()`
* `String toString()`

`Project3Graph` will actually implement the graph data structure.

The following is a brief description of what each of the methods listed above should do.
#### addNode
`addNode` will add a node to the graph.

#### addEdge
`addEdge` will add an edge between the two specified nodes. If one (or both) of the edges do not exist in the graph it will do nothing.

#### setNode
`setNode` will set the specified existing node's value. If the specified node does not exist in the graph it will do nothing.

#### getNode
`getNode` will return the value of the specified node. If the specified node does not exist in the graph it will return `null`.

#### getNodeIds
`getNodeIds` will return an array of Strings that is populated with each of the node ids in the graph. If there are no nodes in the graph it returns an empty String array.

#### removeNode
`removeNode` will remove the specified node from the graph (and all of the edges connected to it). If the specified node does not exist in the graph it will do nothing.

#### removeEdge
`removeEdge` will remove the edge between the two specified nodes. If one (or both) of the edges do not exist in the graph, or there is not an edge already between them, it will do nothing.

#### countNodes
`countNodes` will return the number of nodes in the graph.

#### countEdges
`countEdges` will return the number of edges in the graph.

#### genus
`genus` will return the genus of the graph.

#### toString
`toString` will return a String that represents the graph. It must show each node, the value of that node, and the other nodes that it is connected to (the edges). For example, a graph that has three edges (with ids `n1`, `n2`, and `n3`; and values 5, 2, and 7 respectively) that are all connected to each other could look like this:
```
n1(5): n2, n3
n2(2): n1, n3
n3(7): n1, n2
```

### The MoneyGame class
The "Money Game" is a simple game that is used in graph theory. The graph nodes can have an integer value, and that value can be negative, positive, or zero. This value represents an amount of money. The goal of the game is to distribute the money (though the graph edges) such that each node ends up with a value greather than or equal to zero (all nodes have no "debt"). To distribute money, you select a node and that node gives 1 "money" to each of the nodes that it is connected to (increasing their value by 1). If the node has less money than the number of  nodes it is connected to, then that node will go into "debt" (it will have a negative value). [Here is a good video](https://youtu.be/U33dsEcKgeQ) describing the game (it was this video that was the inspiration for this project).

The `MoneyGame` class will use your `Project3Graph` graph data structure to store the game state. 

* `void addNode(String id, int element)`
* `void addEdge(String id1, String id2)`
* `int sum()`
* `boolean isWinnable()`
* `String toString()`

It should be possible to make the `MoneyGame` class extend the `Project3Graph`, meaning it would inherit many of the above methods and they would not need to be implemented. The other option (and the one that should be easier to implement) is to have the `MoneyGame` class contain a `Project3Graph` object (it would have a "has-a" relationship instead of a "is-a" relationship).


The following is a brief description of what each of the methods listed above should do.

#### addNode
`addNode` will add a node to the graph.

#### addEdge
`addEdge` will add an edge between the two specified nodes. If one (or both) of the edges do not exist in the graph it will do nothing.

#### sum
`sum` will return the sum of all of the node's values. This is total amount of "money" in the graph.

#### isWinnable
`isWinnable` will return `true` if the game can be won, and `false` otherwise. The game can be won if the total amount of "money" in the graph is greater than or equal to the graph's genus.

#### toString
`toString` should simply return the graph's `toString` value.