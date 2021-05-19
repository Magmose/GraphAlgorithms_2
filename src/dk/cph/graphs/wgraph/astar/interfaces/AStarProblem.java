package dk.cph.graphs.wgraph.astar.interfaces;

import dk.cph.graphs.wgraph.builder.Graph;

public interface AStarProblem {
    Graph getGraph();
    int getStartNode();
    int getTargetNode();
    Heuristic getHeuristic();
}
