package dk.cph.graphs.wgraph.builder;

public interface Edge extends Comparable<Edge>{
    int from();
    int to();
    float getWeight();

}
