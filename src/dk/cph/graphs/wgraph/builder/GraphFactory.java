package dk.cph.graphs.wgraph.builder;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface GraphFactory {
    GraphBuilder getNewBuilder(int verticeCount);
    Graph readFromFile(String filename) throws FileNotFoundException, IOException;
}
