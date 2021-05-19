package dk.cph.graphs.airline;

public class EdgeImplAirline {
    String airLineCode;
    String sourceCode;
    String destinationCode;
    double distance;
    double time;

    public EdgeImplAirline(String airLineCode, String sourceCode, String destinationCode, double distance, double time) {
        this.airLineCode = airLineCode;
        this.sourceCode = sourceCode;
        this.destinationCode = destinationCode;
        this.distance = distance;
        this.time = time;
    }

    public String getAirLineCode() {
        return airLineCode;
    }

    public void setAirLineCode(String airLineCode) {
        this.airLineCode = airLineCode;
    }

    public String getSourceCode() {
        return sourceCode;
    }

    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    public String getDestinationCode() {
        return destinationCode;
    }

    public void setDestinationCode(String destinationCode) {
        this.destinationCode = destinationCode;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "EgdeImpl{" +
                "airLineCode='" + airLineCode + '\'' +
                ", sourceCode='" + sourceCode + '\'' +
                ", destinationCode='" + destinationCode + '\'' +
                ", distance=" + distance +
                ", time=" + time +
                '}';
    }
}
