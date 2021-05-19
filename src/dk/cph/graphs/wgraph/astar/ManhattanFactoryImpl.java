package dk.cph.graphs.wgraph.astar;

import dk.cph.graphs.wgraph.astar.interfaces.ManhattanBuilder;
import dk.cph.graphs.wgraph.astar.interfaces.ManhattanFactory;
import dk.cph.graphs.wgraph.astar.interfaces.ManhattanGraph;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManhattanFactoryImpl implements ManhattanFactory {
    /*
     *********
     *S**W****
     ****W****
     ****W****
     ****W****
     ****W****
     ****W**T*
     *********

     */
    @Override
    public ManhattanGraph readFromFile(String filename) throws FileNotFoundException, IOException {

        List<String> stringGraph = Files.lines(Path.of(filename)).collect(Collectors.toList());
        ManhattanBuilder builder = new ManhattanBuilderImpl();
        builder.setMeasurements(stringGraph.size(), stringGraph.get(0).length());



        for (int i = 0; i < stringGraph.size(); i++) {
            char[] c = stringGraph.get(i).toCharArray();
            for (int j = 0; j < c.length; j++) {
                if(c[j] == 'S') builder.setStart(i,j);
                if(c[j] == 'W' ) builder.setWall(i,j);
                if(c[j] == 'T' ) builder.setTarget(i,j);
            }
        }




        return builder.build();
    }
}
