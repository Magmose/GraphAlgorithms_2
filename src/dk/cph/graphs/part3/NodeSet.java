package dk.cph.graphs.part3;

import dk.cph.graphs.airline.VertexImpl;

public class NodeSet implements Comparable<NodeSet> {
    VertexImpl vertice;
    double dist;

    public NodeSet(VertexImpl vertice, double dist) {
        this.vertice = vertice;
        this.dist = dist;
    }

    @Override
    public int compareTo(NodeSet o) {
        if (this.dist < o.dist)
            return 1;
        else if (this.dist > o.dist)
            return -1;
        return 0;
    }
}

