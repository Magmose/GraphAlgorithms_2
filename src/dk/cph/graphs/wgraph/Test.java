package dk.cph.graphs.wgraph;

import dk.cph.graphs.wgraph.astar.Astar;
import dk.cph.graphs.wgraph.astar.interfaces.Heuristic;
import dk.cph.graphs.wgraph.astar.HeuristicImpl;
import dk.cph.graphs.wgraph.builder.Graph;
import dk.cph.graphs.wgraph.builder.GraphFactory;
import dk.cph.graphs.wgraph.dijksta.DijkstraImpl;
import dk.cph.graphs.wgraph.impl.GraphFactoryImpl;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws IOException {
        GraphFactory factory = new GraphFactoryImpl();
        Graph myGraph = factory.readFromFile("graph2.txt");

        DijkstraImpl dijkstra = new DijkstraImpl(0, myGraph);
        Heuristic h = new HeuristicImpl();
        //Graph graph, int startNode, int targetNode, Heuristic heuristic
        Astar astar = new Astar(myGraph,0,7,h);
        System.out.println(  astar.toString());

//        GraphImpl graph = new GraphImpl(8);
////        EdgeImpl edge1 = new EdgeImpl(0, 1, 2);
//        graph.addEdge(0,1,2);
//        graph.addEdge(1,2,1);
//        graph.addEdge(0,3,3);
//        graph.addEdge(0,4,8);
//        graph.addEdge(2,4,1);
//        graph.addEdge(2,5,1);
//        graph.addEdge(3,4,1);
//        graph.addEdge(4,5,3);
//        graph.addEdge(3,6,5);
//        graph.addEdge(4,6,2);
//        graph.addEdge(7,4,2);
//        graph.addEdge(5,7,1);
//        graph.addEdge(6,7,1);
//
//        Dijkstra d = new Dijkstra(graph, 0);


    }

}
