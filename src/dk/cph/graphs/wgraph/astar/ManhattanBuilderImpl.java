package dk.cph.graphs.wgraph.astar;

import dk.cph.graphs.wgraph.astar.interfaces.ManhattanBuilder;
import dk.cph.graphs.wgraph.astar.interfaces.ManhattanGraph;

public class ManhattanBuilderImpl implements ManhattanBuilder,ManhattanGraph {
    private int[][] map;


    @Override
    public void setStart(int x, int y) {
    map[x][y] = ManhattanGraph.START;;
    }

    @Override
    public void setTarget(int x, int y) {
        map[x][y] = ManhattanGraph.TARGET;
    }

    @Override
    public void setWall(int x, int y) {
    map[x][y] =  ManhattanGraph.WALL;
    }

    @Override
    public void setMeasurements(int h, int w) {
        this.map = new int[w][h];
    }

    @Override
    public ManhattanGraph build() {
        return this;
    }


    @Override
    public int width() {
        return map.length;
    }

    @Override
    public int height() {
        return map[0].length;
    }

    @Override
    public int get(int x, int y) {
        return map[x][y];
    }
}
