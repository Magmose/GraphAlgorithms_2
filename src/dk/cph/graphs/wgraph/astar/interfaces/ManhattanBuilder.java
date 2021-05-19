package dk.cph.graphs.wgraph.astar.interfaces;

public interface ManhattanBuilder {
    void setStart(int x, int y);
    void setTarget(int x,int y);
    void setWall(int x, int y);
    void setMeasurements(int h, int w);
    ManhattanGraph build();
}
