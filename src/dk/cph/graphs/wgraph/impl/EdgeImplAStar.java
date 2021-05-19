package dk.cph.graphs.wgraph.impl;

import dk.cph.graphs.wgraph.builder.Edge;

public class EdgeImplAStar implements Edge {
    private int a;
    private int b;
    private float w;

    public EdgeImplAStar(int a, int b, float w) {
        this.a = a;
        this.b = b;
        this.w = w;

    }

    @Override
    public int from() {
        return a;
    }

    @Override
    public int to() {
        return b;
    }

    @Override
    public float getWeight() {
        return w;
    }

    @Override
    public int compareTo(Edge o) {
        double d = this.w - o.getWeight();
        if (d > 0) return 1;
        if (d < 0) return -1;
        return 0;
    }
}
