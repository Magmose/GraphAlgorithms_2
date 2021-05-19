package dk.cph.graphs.wgraph.astar;

import dk.cph.graphs.wgraph.astar.interfaces.AStarProblem;
import dk.cph.graphs.wgraph.astar.interfaces.Heuristic;
import dk.cph.graphs.wgraph.builder.Edge;
import dk.cph.graphs.wgraph.builder.Graph;

import java.util.ArrayList;

public class Astar {
    private Graph graph;
    private int startNode;
    private int targetNode;
    private Heuristic heuristic;

    private int[] pathArray;
    private float[] bestWeight;
    private boolean[] marked;
    private ArrayList<Integer> pq;


    public Astar(AStarProblem aStarProblem) {
        this.graph = aStarProblem.getGraph();
        this.startNode = aStarProblem.getStartNode();
        this.targetNode = aStarProblem.getTargetNode();
        this.heuristic = aStarProblem.getHeuristic();
        AStarImpl();
    }

    public Astar(Graph graph, int startNode, int targetNode, Heuristic heuristic) {
        this.graph = graph;
        this.startNode = startNode;
        this.targetNode = targetNode;
        this.heuristic = heuristic;
        AStarImpl();
    }

    private void AStarImpl() {
        //Defualting
        pathArray = new int[graph.getV()];
        for (int i = 0; i < pathArray.length; i++) {
            pathArray[i] = -1;
        }
        //Defualting
        bestWeight = new float[graph.getV()];
        for (int i = 0; i < bestWeight.length; i++) {
            bestWeight[i] =Float.MAX_VALUE;
        }
        //Defualting
        marked = new boolean[graph.getV()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }

        bestWeight[startNode] = 0;
        marked[startNode] = true;

        pq = new ArrayList<>();
        int curNode = startNode;
        while(curNode != -1){
            float curCost = bestWeight[curNode];
            for (Edge e: graph.abj(curNode)){
                float cost = curCost + e.getWeight();
                int toNode = e.to();
                if(cost < bestWeight[toNode]){
                    bestWeight[toNode] = cost;
                    pathArray[toNode] = curNode;
                }

                if(!marked[toNode]){
                    pq.add(toNode);
                    marked[toNode] = true;
                }

            }
            curNode = extractMin();

        }
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Best weight:\n");
        for (int i = 0; i < bestWeight.length; i++) {
            sb.append(i);
            sb.append(": ");
            sb.append(bestWeight[i]);
            sb.append('\n');
        }
        sb.append("Path parents:\n");
        for (int i = 0; i < bestWeight.length; i++) {
            sb.append(i);
            sb.append(": ");
            sb.append(pathArray[i]);
            sb.append('\n');
        }
        return sb.toString();
    }


    private int extractMin(){
        int res = -1;
        float minWeight = Float.MAX_VALUE;
        for(int i : pq){
            float fn = bestWeight[i] + heuristic.h(i,targetNode);
            if(fn < minWeight){
                res = i;
                minWeight = fn;
            }
        }
        if(res != -1){
            pq.remove((Integer)res);
            if(res == targetNode) return -1;
        }
        return res;
    }

}
