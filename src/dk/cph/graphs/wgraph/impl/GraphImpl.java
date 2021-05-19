package dk.cph.graphs.wgraph.impl;

import dk.cph.graphs.wgraph.builder.Edge;

import dk.cph.graphs.wgraph.builder.Graph;
import dk.cph.graphs.wgraph.builder.GraphBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphImpl implements Graph, GraphBuilder {
    private static final ArrayList<Edge> emptyList = new ArrayList<>(0);
    private ArrayList<Edge>[] arr;
    private ArrayList<Edge> allEgdes;

    public GraphImpl(int verticeCount) {
        this.arr = new ArrayList[verticeCount];
        allEgdes = new ArrayList<>();
    }

    @Override
    public int getV() {
        return arr.length;
    }

    @Override
    public int getE() {
        return allEgdes.size();
    }

    @Override
    public Iterable<Edge> abj(int v) {
        ArrayList adjList = arr[v];
        if(adjList == null){
            return emptyList;
        }
        return adjList;
    }

    @Override
    public Iterable<Edge> edges() {
        return allEgdes;
    }

    @Override
    public Iterable<Edge> getPrim() {
        HashMap<Integer, List<Edge>> visited = new HashMap<>();

        List<Edge>[] unVisted =  arr;
        List<Edge> result  = new ArrayList<>();
        visited.put(0,unVisted[0]);



        return null;
    }

    @Override
    public void addEdge(int v1, int v2, float weight) {
    Edge e = new EdgeImplAStar(v1,v2,weight);
        allEgdes.add(e);
    addEdgeToList(v1,e);
    addEdgeToList(v2,e);
    }

    private void addEdgeToList(int v, Edge e){
        ArrayList<Edge> list = arr[v];
        if(list == null){
            list = new ArrayList<>();
            arr[v] = list;
        }
        list.add(e);
    }

    @Override
    public Graph build() {
        return this;
    }

    @Override
    public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append(getV());
     sb.append('\n');
        sb.append(getE());
        sb.append('\n');
        for ( Edge e: edges()) {
            sb.append(e.from());
            sb.append(' ');
            sb.append(e.to());
            sb.append(' ');
            sb.append(e.getWeight());
            sb.append('\n');
        }
        return sb.toString();
    }
}
