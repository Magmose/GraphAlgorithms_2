package dk.cph.graphs.part1;

import dk.cph.graphs.airline.EdgeImplAirline;
import dk.cph.graphs.airline.VertexImpl;

import java.util.*;

public class BFS {

    public boolean bfs(HashMap<String, VertexImpl> graph, String root, String goal, String airlineCode) {

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        Queue<VertexImpl> que = new LinkedList<>();
        visited.put(root, true);
        que.add(graph.get(root));

        while (que.size() != 0) {
            VertexImpl current = que.poll();
            if (current.getCode().equals( goal)) {
                System.out.println(visited.size());
                return true;
            }

            List<EdgeImplAirline> edges = current.getEdges();
            for (int i = 0; i < edges.size(); i++) {
                EdgeImplAirline edge = edges.get(i);

                if (!edge.getAirLineCode().equals(airlineCode)) {
                    continue;
                }

                if (visited.get(edge.getDestinationCode()) == null) {
                    visited.put(edge.getDestinationCode(), true);
                    que.offer(graph.get(edge.getDestinationCode()));
                }
            }

        }
        return false;
    }
}
/*
Input: A graph G and a starting vertex root of G

Output: Goal state. The parent links trace the shortest path back to root[7]


1  procedure BFS(G, root) is
 2      let Q be a queue
 3      label root as discovered
 4      Q.enqueue(root)
 5      while Q is not empty do
 6          v := Q.dequeue()
 7          if v is the goal then
 8              return v
 9          for all edges from v to w in G.adjacentEdges(v) do
10              if w is not labeled as discovered then
11                  label w as discovered
12                  Q.enqueue(w)
 */
