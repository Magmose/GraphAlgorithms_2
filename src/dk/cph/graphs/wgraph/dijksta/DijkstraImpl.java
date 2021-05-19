package dk.cph.graphs.wgraph.dijksta;

import dk.cph.graphs.wgraph.builder.Edge;
import dk.cph.graphs.wgraph.builder.Graph;

import java.util.ArrayList;

public class DijkstraImpl {
    private int[] pathArray;
    private float[] bestWeight;
    private boolean[] marked;
    private ArrayList<Integer> pq;

    public DijkstraImpl(int startNode, Graph g) {
        //Defualting
        pathArray = new int[g.getV()];
        for (int i = 0; i < pathArray.length; i++) {
            pathArray[i] = -1;
        }
        //Defualting
        bestWeight = new float[g.getV()];
        for (int i = 0; i < bestWeight.length; i++) {
            bestWeight[i] =Float.MAX_VALUE;
        }
        //Defualting
        marked = new boolean[g.getV()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }

        bestWeight[startNode] = 0;
        marked[startNode] = true;

        pq = new ArrayList<>();
        int curNode = startNode;
        while(curNode != -1){
            float curCost = bestWeight[curNode];
            for (Edge e: g.abj(curNode)){
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
            if(curNode == -2) break;

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
            if(bestWeight[i] < minWeight){
                res = i;
                minWeight = bestWeight[i];
            }
        }
        if(res != -1){
            pq.remove((Integer)res);
            if(res == 4)return -2;
        }
        return res;
    }
}
