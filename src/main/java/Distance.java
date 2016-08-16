import java.util.LinkedList;

/**
 * Created by carl on 16.08.16.
 */
public class Distance {

    public LinkedList<Datapoint> assignDistances(LinkedList<Datapoint> datapoints) {
        LinkedList<Datapoint> output = new LinkedList<Datapoint>();
        while (!datapoints.isEmpty()) {
            output.add(assignDistances(datapoints.remove()));
        }
        return output;
    }

    public Datapoint assignDistances(Datapoint datapoint) {
        datapoint.distanceAP1 = distanceAP1(datapoint.rssiAP1);
        datapoint.distanceAP2 = distanceAP2(datapoint.rssiAP2);
        datapoint.distanceAP3 = distanceAP3(datapoint.rssiAP3);
        datapoint.distanceAP4 = distanceAP4(datapoint.rssiAP4);
        datapoint.distanceAP5 = distanceAP5(datapoint.rssiAP5);
        return datapoint;
    }

    private float distanceAP1(int rssi) {
        if (-40 < rssi) return 2;
        if (-50 < rssi) return 4;
        else return (float) (2.148f * Math.exp(-0.02873f * rssi));
    }

    private float distanceAP2(int rssi) {
        if (-35 < rssi) return 1;
        if (-40 < rssi) return 3;
        else return (float) (1.743f * Math.exp(-0.03294f * rssi));
    }

    private float distanceAP3(int rssi) {
        if (-35 < rssi) return 1;
        else return (float) (0.7888f * Math.exp(-0.0401f * rssi));
    }

    private float distanceAP4(int rssi) {
        if (-35 < rssi) return 1;
        else return (float) (0.801f * Math.exp(-0.0388f * rssi));
    }

    private float distanceAP5(int rssi) {
        if (-40 < rssi) return 2;
        else return (float) (1.545f * Math.exp(-0.03051f * rssi));
    }
}
