package dk.cph.graphs.part4;

import dk.cph.graphs.airline.EdgeImplAirline;
import dk.cph.graphs.airline.VertexImpl;

import java.util.*;

public class Prims {

    public Set<EdgeImplAirline> mst(HashMap<String, VertexImpl> graph, String startNode) {
        Set<EdgeImplAirline> mst = new HashSet<>();

        HashMap<String, VertexImpl> marked = new HashMap<>();
        marked.put(startNode, graph.get(startNode));


        while (mst.size() < graph.size() - 1) {
            EdgeImplAirline best = null;
            List<EdgeImplAirline> edgeList = new ArrayList<>();

            for (Map.Entry<String, VertexImpl> entry : marked.entrySet()) {
                edgeList.addAll(entry.getValue().getEdges());
            }
            for (int i = 0; i < edgeList.size(); i++) {
                EdgeImplAirline edge = edgeList.get(i);

                if (marked.get(edge.getDestinationCode()) == null) {
                    if(best == null) best = edge;
                    if (edge.getDistance() < best.getDistance()) {
                        best = edge;
                    }
                }
            }
            //System.out.println(best.toString());
//            System.out.println("Graph: " + graph.size() + "     Mst: " + mst.size() + "           marked: " + marked.size());

            if(best == null ){
                System.out.println("vi har ikke flere edges ");
                Set<String> destinations = new HashSet<>();
                edgeList.forEach(edge -> {
                    destinations.add(edge.getDestinationCode());
                });
                System.out.println("number of possible destinations: " + destinations.size() + "marked size: " + marked.size());

                break;
            }
            mst.add(best);
            marked.put(best.getDestinationCode(), graph.get(best.getDestinationCode()));


        }
        return mst;
    }
}
/*
T = ∅;
U = { 1 };
while (U ≠ V)
    let (u, v) be the lowest cost edge such that u ∈ U and v ∈ V - U;
    T = T ∪ {(u, v)}
    U = U ∪ {v}
 */