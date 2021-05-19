package dk.cph.graphs.wgraph.impl;

import dk.cph.graphs.wgraph.builder.Edge;
import dk.cph.graphs.wgraph.builder.Graph;


import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    class PrioVertex {
        int idx;
        double dist;

        public PrioVertex(int idx, double dist) {
            this.idx = idx;
            this.dist = dist;
        }

        public int compare(PrioVertex o1, PrioVertex o2) {
            if (o1.dist < o2.dist) return 1;
            if (o1.dist > o2.dist) return -1;
            return 0;
        }
    }

    private GraphImpl graph;
    private int source;
    private PriorityQueue<PrioVertex> q = new PriorityQueue(
    );


    public Dijkstra(GraphImpl graph, int source) {
        this.graph = graph;
        this.source = source;

        this.run();
    }

    public void run() {
        int vcount = graph.getV();
        double[] dist = new double[vcount];
        int[] prev = new int[vcount];

        for (int i = 0; i < vcount; i++) {
            dist[i] = Double.MAX_VALUE;
            prev[i] = -1;
            q.add(new PrioVertex(i, dist[i]));
        }

        dist[source] = 0;

        while (!q.isEmpty()) {
            PrioVertex u = q.poll();
            q.remove(u);

            List<Edge> neighbor = (List<Edge>) graph.abj(u.idx);
            for (int i = 0; i < neighbor.size(); i++) {


            }


        }


    }
}
