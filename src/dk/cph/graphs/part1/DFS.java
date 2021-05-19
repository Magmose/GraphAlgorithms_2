package dk.cph.graphs.part1;

import dk.cph.graphs.airline.EdgeImplAirline;
import dk.cph.graphs.airline.VertexImpl;

import java.util.*;

public class DFS {
    public boolean dfs(HashMap<String, VertexImpl> graph, String root, String goal, String airlineCode) {

        HashMap<String, Boolean> visited = new HashMap<String, Boolean>();
        Stack<VertexImpl> stack = new Stack<>();
        visited.put(root, true);
        stack.push(graph.get(root));

        while (stack.size() != 0) {
            VertexImpl current = stack.pop();
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
                    stack.push(graph.get(edge.getDestinationCode()));
                }
            }

        }
        return false;
    }
}
