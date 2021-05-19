package dk.cph.graphs.part4;

import dk.cph.graphs.airline.EdgeImplAirline;
import dk.cph.graphs.airline.VertexImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class RunPart4 {
    public static void main(String[] args) throws IOException {
        HashMap<String, VertexImpl> graph = new HashMap<>();

        List<String> vertex = Files.lines(Path.of("doc/airlines/airports.txt")).collect(Collectors.toList());
        for (int i = 1; i < vertex.size(); i++) {
            String vertexString = vertex.get(i);
            String[] sa = vertexString.split(";");
            VertexImpl vertex1 = new VertexImpl(sa[0], sa[1], sa[2], sa[3], Double.parseDouble(sa[4]), Double.parseDouble(sa[5]));
            graph.put(vertex1.getCode(),vertex1);
        }

        List<String> edge = Files.lines(Path.of("doc/airlines/routes.txt")).collect(Collectors.toList());
        for (int i = 1; i < edge.size(); i++) {
            String edgeString = edge.get(i);
            String[] sa = edgeString.split(";");
            EdgeImplAirline edge1 = new EdgeImplAirline(sa[0],sa[1],sa[2],Double.parseDouble(sa[3]),Double.parseDouble(sa[4]));
            String from = edge1.getSourceCode();
            VertexImpl v = graph.get(from);
            v.addEdges(edge1);
        }
        Prims prim = new Prims();
        Set<EdgeImplAirline> li = prim.mst(graph,"GKA");
        System.out.println("edges in mst: " + li.size());
//        li.forEach(egde -> {
//            System.out.println(egde.getDistance());
//        });
    }
}
