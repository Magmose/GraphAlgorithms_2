package dk.cph.graphs.part1;

import dk.cph.graphs.airline.*;
import dk.cph.graphs.airline.EdgeImplAirline;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
//https://nlp.stanford.edu/nlp/javadoc/javanlp/edu/stanford/nlp/util/PriorityQueue.html
public class RunPart1 {
    public static void main(String[] args) throws IOException {

        HashMap<String,VertexImpl> graph = new HashMap<>();

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

        breathFirst(graph);


    }

    private static void breathFirst(HashMap<String, VertexImpl> graph) {
        BFS bfs = new BFS();
        DFS df = new DFS();
        System.out.println("BFS: " + bfs.bfs(graph, "SIN", "CPH", "KL"));
        System.out.println("DFS: " + df.dfs(graph, "SIN", "CPH", "KL"));

    }

    private static void printGraph(HashMap<String, VertexImpl> map) {
        for(Map.Entry<String,VertexImpl> entry : map.entrySet()){
            System.out.println("Key: "+entry.getKey());
            System.out.println("Value: "+entry.getValue().toString());
        }
    }
}
