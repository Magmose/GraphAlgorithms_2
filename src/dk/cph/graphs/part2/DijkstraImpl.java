package dk.cph.graphs.part2;

import dk.cph.graphs.airline.EdgeImplAirline;
import dk.cph.graphs.airline.VertexComparator;
import dk.cph.graphs.airline.VertexImpl;

import java.util.*;


public class DijkstraImpl {
//    private VertexImpl[] pathArray;
//    private double[] bestWeight;
//    private boolean[] marked;
//    private ArrayList<Vertex> pq;


    public double dijkstraImpl(HashMap<String, VertexImpl> graph, String startNode, String endNode) {
        int count = 0;
        graph.get(startNode).setDijkstraDist(0.0);
        //System.out.println("_________"+graph.get(startNode).getDijkstraDist());
        PriorityQueue<VertexImpl> pq = new PriorityQueue<>(graph.size(), new VertexComparator());

//        for (Map.Entry<String, VertexImpl> entry : graph.entrySet()) {
//             pq.add(entry.getValue());
//        }

        pq.offer(graph.get(startNode));

        while (!pq.isEmpty()) {
            VertexImpl curr = pq.poll();
            //System.out.println("curr polled: " + curr.toString());
            count++;
            if (curr.getCode().equals(endNode)) {
                System.out.println(curr.toString());
                System.out.println("Succesfully found shortest path, prev to goal was " + curr.getDijkstraPrev().getCode() + "\nNumber of vertices removed from pq: " + count);
                return curr.getDijkstraDist();
            }

            Map<VertexImpl, Double> neighbours = getAdjInQueue(graph, curr, pq);
            for (Map.Entry<VertexImpl, Double> e : neighbours.entrySet()) {
                VertexImpl neighbor = e.getKey();
                Double alt = curr.getDijkstraDist() + e.getValue();
//                System.out.println("making alt with " + curr.getDijkstraDist() + " and edge distance: " + e.getValue());
                //System.out.println("Double alt: " +alt + " and neighbor dist : " + neighbor.getDijkstraDist());
                if (alt < neighbor.getDijkstraDist()) {
//                    System.out.println();

                    if (!neighbor.isMarked()) {
                        neighbor.setDijkstraDist(alt);
                        neighbor.setDijkstraPrev(curr);
                        pq.offer(neighbor);

                        neighbor.setMarked(true);
                    } else {

                        pq.remove(neighbor);
                        neighbor.setDijkstraDist(alt);
                        neighbor.setDijkstraPrev(curr);
                        pq.offer(neighbor);
                    }

                }

            }

        }

        return 0;
    }

    public Map<VertexImpl, Double> getAdjInQueue(HashMap<String, VertexImpl> graph, VertexImpl vertex, PriorityQueue pq) {
        Map<VertexImpl, Double> result = new HashMap<>();

        //for hver edge destination check om der findes et nodeset med matchende destination i PQ

        //hvis ja tilføj til result
        for (int i = 0; i < vertex.getEdges().size(); i++) {
            EdgeImplAirline edge = vertex.getEdges().get(i);
            VertexImpl neighbour = graph.get(edge.getDestinationCode());
            result.put(neighbour, edge.getDistance());
//            if(pq.contains(neighbour)) {
//              System.out.println("added to result : "+ neighbour + " with dist " + edge.getDistance());
//
//            }
        }


        return result;
    }

}
/*
 function Dijkstra(Graph, source):
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
 */
/*
 function Dijkstra(Graph, source):
 2
 3      create vertex set Q
 4
 5      for each vertex v in Graph:
 6          dist[v] ← INFINITY
 7          prev[v] ← UNDEFINED
 8          add v to Q
 9      dist[source] ← 0
10
11      while Q is not empty:
12          u ← vertex in Q with min dist[u]
13
14          remove u from Q
15
16          for each neighbor v of u:           // only v that are still in Q
17              alt ← dist[u] + length(u, v)
18              if alt < dist[v]:
19                  dist[v] ← alt
20                  prev[v] ← u
21
22      return dist[], prev[]
 */
//    public DijkstraImpl() {
//    }
//
//    public DijkstraImpl(int startNode, Graph g) {
//        //Defualting
//        pathArray = new int[g.getV()];
//        for (int i = 0; i < pathArray.length; i++) {
//            pathArray[i] = -1;
//        }
//        //Defualting
//        bestWeight = new float[g.getV()];
//        for (int i = 0; i < bestWeight.length; i++) {
//            bestWeight[i] =Float.MAX_VALUE;
//        }
//        //Defualting
//        marked = new boolean[g.getV()];
//        for (int i = 0; i < marked.length; i++) {
//            marked[i] = false;
//        }
//
//        bestWeight[startNode] = 0;
//        marked[startNode] = true;
//
//        pq = new ArrayList<>();
//        int curNode = startNode;
//        while(curNode != -1){
//            float curCost = bestWeight[curNode];
//            for (Edge e: g.abj(curNode)){
//                float cost = curCost + e.getWeight();
//                int toNode = e.to();
//                if(cost < bestWeight[toNode]){
//                    bestWeight[toNode] = cost;
//                    pathArray[toNode] = curNode;
//                }
//
//                if(!marked[toNode]){
//                    pq.add(toNode);
//                    marked[toNode] = true;
//                }
//
//            }
//
//
//            curNode = extractMin();
//            if(curNode == -2) break;
//
//        }
//
//
//    }
//
//
//    @Override
//    public String toString(){
//    StringBuilder sb = new StringBuilder();
//    sb.append("Best weight:\n");
//        for (int i = 0; i < bestWeight.length; i++) {
//            sb.append(i);
//            sb.append(": ");
//            sb.append(bestWeight[i]);
//            sb.append('\n');
//        }
//        sb.append("Path parents:\n");
//        for (int i = 0; i < bestWeight.length; i++) {
//            sb.append(i);
//            sb.append(": ");
//            sb.append(pathArray[i]);
//            sb.append('\n');
//        }
//        return sb.toString();
//    }
//
//
//    private int extractMin(){
//        int res = -1;
//        float minWeight = Float.MAX_VALUE;
//        for(int i : pq){
//            if(bestWeight[i] < minWeight){
//                res = i;
//                minWeight = bestWeight[i];
//            }
//        }
//        if(res != -1){
//            pq.remove((Integer)res);
//            if(res == 4)return -2;
//        }
//        return res;
//    }
//}
/*
procedure uniform_cost_search(Graph, start, goal) is
    node ← start
    cost ← 0
    frontier ← priority queue containing node only
    explored ← empty set
    do
        if frontier is empty then
            return failure
        node ← frontier.pop()
        if node is goal then
            return solution
        explored.add(node)
        for each of node's neighbors n do
            if n is not in explored then
                frontier.add(n)
 */