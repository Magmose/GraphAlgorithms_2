
# GraphAlgorithms_2
## Part 1
All the tasks are implemented and run separately in their own packages - /src/dk/cph/graphs/ --part1/2/3/4 

### 1.1
Our BFS and DFS are implemented exactly the same way, except for the BFS which uses a Queue, where the DFS uses a Stack. We find that the results depend a lot on what airports we are trying to reach and which airline we have chosen. 

Some results here: 

| Airline-Source>Destination  | BFS iterations    |  DFS iterations     |
| :-------------:             | :-------------:   | :-----------------: |
| KL-SIN>CPH             | 288               |     **202**             |
| KL-SIN>LGA             | **334**               |       353           |
| DY-CPH>FLL             | **76**                |     90              | 

We can see that on *average* DFS uses fewer iterations, although this is a small sample size. It will depend a lot on how many different routes the specific carrier has.

### 1.2
Our dijkstra is implemented with the default Java PriorityQueue. Since it does not have function to update priority for an element (which is necessary in dijkstra), we remove the element and re-insert it. This however is an O(n) operation, that could have been O(logn) with a proper PriorityQueue. 

### 1.3 
For this we have reused our dijkstra implementation with a small addition to count the extra hours from layovers. Given the pseudocode below: 
```
1  function Dijkstra(Graph, source):
2      dist[source] ← 0                           // Initialization
3
4      create vertex priority queue Q
5
6      for each vertex v in Graph:          
7          if v ≠ source
8              dist[v] ← INFINITY                 // Unknown distance from source to v
9              prev[v] ← UNDEFINED                // Predecessor of v
10
11         Q.add_with_priority(v, dist[v])
12
13
14     while Q is not empty:                      // The main loop
15         u ← Q.extract_min()                    // Remove and return best vertex
16         for each neighbor v of u:              // only v that are still in Q
17             alt ← dist[u] + length(u, v)
18             if alt < dist[v]
19                 dist[v] ← alt
20                 prev[v] ← u
21                 Q.decrease_priority(v, alt)
22
23     return dist, prev
```
we simply insert after line 17: ``if (!neighbor.getCode().equals(endNode)) { alt +=1;}`` 

### 1.4 
This task made no real sense, or at least with the explanation provided it didn't. We have implemented Prim's algorithm and attempted to run it for all airports/airlines, just to generate a spanning tree. However it did not seem possible with the full data set - we have run the algorithm on a separate fictionary subset of the graph, which can be found in /doc/airlines/ (airports2.txt and routes2.txt make up the small fictionary graph). Our Prim implementation worked fine on this data,  which leads us to believe that the full graph is somehow disconnected. We did not want to sort through it all and figure out where it was disconnected, but it seems to stop after ~3400 airports out of ~5600 total.


