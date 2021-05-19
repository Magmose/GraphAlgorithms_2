package dk.cph.graphs.wgraph.astar.interfaces;

public interface Heuristic {
    //2 noder, estimatet af afstender mellem de to noder
    float h(int a, int b);
}
