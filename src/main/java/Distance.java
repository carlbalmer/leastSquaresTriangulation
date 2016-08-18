import java.util.LinkedList;

/**Determines the distance based on the RSSI.
 * Created by carl on 16.08.16.
 */
public class Distance {

    public static void assignDistances(LinkedList<Datapoint> datapoints) {
        for (int i = 0, len = datapoints.size(); i < len; i++) {
            datapoints.add(assignDistances(datapoints.remove()));
        }
    }

    private static Datapoint assignDistances(Datapoint datapoint) {
        datapoint.distanceAP1 = distanceAP1(datapoint.rssiAP1);
        datapoint.distanceAP2 = distanceAP2(datapoint.rssiAP2);
        datapoint.distanceAP3 = distanceAP3(datapoint.rssiAP3);
        datapoint.distanceAP4 = distanceAP4(datapoint.rssiAP4);
        datapoint.distanceAP5 = distanceAP5(datapoint.rssiAP5);
        return datapoint;
    }

    private static float distanceAP1(int rssi) {
        if (-40 < rssi) return 2;
        if (-50 < rssi) return 4;
        else return (float) (2.148f * Math.exp(-0.02873f * rssi));
    }

    private static float distanceAP2(int rssi) {
        if (-35 < rssi) return 1;
        if (-40 < rssi) return 3;
        else return (float) (1.743f * Math.exp(-0.03294f * rssi));
    }

    private static float distanceAP3(int rssi) {
        if (-35 < rssi) return 1;
        else return (float) (0.7888f * Math.exp(-0.0401f * rssi));
    }

    private static float distanceAP4(int rssi) {
        if (-35 < rssi) return 1;
        else return (float) (0.801f * Math.exp(-0.0388f * rssi));
    }

    private static float distanceAP5(int rssi) {
        if (-40 < rssi) return 2;
        else return (float) (1.545f * Math.exp(-0.03051f * rssi));
    }
}
