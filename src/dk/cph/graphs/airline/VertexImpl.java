package dk.cph.graphs.airline;

import java.util.ArrayList;
import java.util.List;

public class VertexImpl implements Comparable<VertexImpl> {
    String code;
    String name;
    String city;
    String country;
    double latitude;
    double longitude;
    List<EdgeImplAirline> edges = new ArrayList<>();
    Double dijkstraDist;
    VertexImpl dijkstraPrev;
    boolean marked = false;

    public VertexImpl(String code, String name, String city, String country, double latitude, double longitude) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dijkstraDist = Double.MAX_VALUE;
        this.dijkstraPrev = null;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }

    public List<EdgeImplAirline> getEdges() {
        return edges;
    }

    public Double getDijkstraDist() {
        return dijkstraDist;
    }

    public void setDijkstraDist(Double dijkstraDist) {
        this.dijkstraDist = dijkstraDist;
    }

    public VertexImpl getDijkstraPrev() {
        return dijkstraPrev;
    }

    public void setDijkstraPrev(VertexImpl dijkstraPrev) {
        this.dijkstraPrev = dijkstraPrev;
    }

    public void setEdges(List<EdgeImplAirline> edges) {
        this.edges = edges;
    }
    public void addEdges(EdgeImplAirline edge) {
        this.edges.add(edge);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nDistance to "+code+" was " + dijkstraDist );
        if(dijkstraPrev != null){
        sb.append(", and the previous airport was "+dijkstraPrev.getCode()+ dijkstraPrev);

        } else if (dijkstraPrev == null){
            sb.append(" because it is the starting point");
            return sb.toString();
        }
        return sb.toString();
    }
    @Override
    public int compareTo(VertexImpl o) {
        if (this.dijkstraDist < o.dijkstraDist)
            return -1;
        else if (this.dijkstraDist > o.dijkstraDist)
            return 1;
        return 0;
    }
}
