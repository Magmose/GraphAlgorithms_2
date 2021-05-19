package dk.cph.graphs.wgraph.astar.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface ManhattanFactory {
    ManhattanGraph readFromFile(String filename) throws FileNotFoundException, IOException;
}
