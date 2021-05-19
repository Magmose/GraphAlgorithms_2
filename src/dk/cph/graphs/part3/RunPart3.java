package dk.cph.graphs.part3;

import dk.cph.graphs.airline.EdgeImplAirline;
import dk.cph.graphs.airline.VertexImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RunPart3 {
    public static void main(String[] args) throws IOException {
//Sådan skulle bare lige mute :D
        HashMap<String,VertexImpl> graph = new HashMap<>();

        List<String> vertex = Files.lines(Path.of("doc/airlines/airports2.txt")).collect(Collectors.toList());
        for (int i = 1; i < vertex.size(); i++) {
            String vertexString = vertex.get(i);
            String[] sa = vertexString.split(";");
            VertexImpl vertex1 = new VertexImpl(sa[0], sa[1], sa[2], sa[3], Double.parseDouble(sa[4]), Double.parseDouble(sa[5]));
            graph.put(vertex1.getCode(),vertex1);
        }

        List<String> edge = Files.lines(Path.of("doc/airlines/routes2.txt")).collect(Collectors.toList());
        for (int i = 1; i < edge.size(); i++) {
            String edgeString = edge.get(i);
            String[] sa = edgeString.split(";");
            EdgeImplAirline edge1 = new EdgeImplAirline(sa[0],sa[1],sa[2],Double.parseDouble(sa[3]),Double.parseDouble(sa[4]));
            String from = edge1.getSourceCode();
            VertexImpl v = graph.get(from);
            v.addEdges(edge1);
        }
        DijkstraImpl dijkstra = new DijkstraImpl();
        System.out.println("Time: " + dijkstra.dijkstraImpl(graph, "GKA", "POM"));

    }

    private static void printGraph(HashMap<String, VertexImpl> map) {
        for(Map.Entry<String,VertexImpl> entry : map.entrySet()){
            System.out.println("Key: "+entry.getKey());
            System.out.println("Value: "+entry.getValue().toString());
        }
    }
}
