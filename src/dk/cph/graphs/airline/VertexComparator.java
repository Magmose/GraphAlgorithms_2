package dk.cph.graphs.airline;

import java.util.Comparator;

public class VertexComparator implements Comparator<VertexImpl> {
    @Override
    public int compare(VertexImpl o1, VertexImpl o2) {
        if (o1.dijkstraDist < o2.dijkstraDist)
            return -1;
        else if (o1.dijkstraDist > o2.dijkstraDist)
            return 1;
        return 0;
    }


}

