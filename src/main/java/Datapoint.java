import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

/**
 * Data object represents one measurement.
 * Created by carl on 15.08.16.
 */
public class Datapoint {

    final int room;
    final int rssiAP1;
    final int rssiAP2;
    final int rssiAP3;
    final int rssiAP4;
    final int rssiAP5;
    final int XAxys;
    final int YAxys;
    final int ZAxys;
    final Vector2D position;
    double[] distances;
    double[] weights;
    double rsm;
    double error;
    private Vector2D assumedPosition;

    public Datapoint(int room, int rssiAP1, int rssiAP2, int rssiAP3, int rssiAP4, int rssiAP5, int XAxys, int YAxys, int ZAxys, double XPosition, double YPosition) {
        this.room = room;
        this.rssiAP1 = rssiAP1;
        this.rssiAP2 = rssiAP2;
        this.rssiAP3 = rssiAP3;
        this.rssiAP4 = rssiAP4;
        this.rssiAP5 = rssiAP5;
        this.XAxys = XAxys;
        this.YAxys = YAxys;
        this.ZAxys = ZAxys;
        this.position = new Vector2D(XPosition, YPosition);
    }

    @Override
    public String toString() {
        return position.getX() +
                " " + position.getY() +
                " " + assumedPosition.getX() +
                " " + assumedPosition.getY() +
                " " + error +
                " " + rsm +
                " " + room +
                " " + distances[0] +
                " " + distances[1] +
                " " + distances[2] +
                " " + distances[3] +
                " " + distances[4] +
                " " + weights[0] +
                " " + weights[1] +
                " " + weights[2] +
                " " + weights[3] +
                " " + weights[4] +
                " " + rssiAP1 +
                " " + rssiAP2 +
                " " + rssiAP3 +
                " " + rssiAP4 +
                " " + rssiAP5 +
                " " + XAxys +
                " " + YAxys +
                " " + ZAxys;
    }

    public Vector2D getAssumedPosition() {
        return assumedPosition;
    }

    public void setAssumedPosition(Vector2D assumedPosition) {
        this.assumedPosition = assumedPosition;
        error = assumedPosition.distance(position);
    }
}