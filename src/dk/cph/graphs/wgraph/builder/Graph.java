package dk.cph.graphs.wgraph.builder;

import dk.cph.graphs.wgraph.builder.Edge;

public interface Graph {
    int getV();
    int getE();
    void addEdge(int v1, int v2, float w);
    Iterable<Edge> abj(int v);
    Iterable<Edge> edges();
    Iterable<Edge> getPrim();
}
