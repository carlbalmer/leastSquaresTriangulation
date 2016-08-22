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
        double[] distances = new double[]{
                distanceAP1(datapoint.rssiAP1),
                distanceAP2(datapoint.rssiAP2),
                distanceAP3(datapoint.rssiAP3),
                distanceAP4(datapoint.rssiAP4),
                distanceAP5(datapoint.rssiAP5)};
        datapoint.distances = distances;
        return datapoint;
    }

    private static double distanceAP1(int rssi) {
        if (-40 < rssi) return 2;
        if (-50 < rssi) return 4;
        else return (float) (2.148 * Math.exp(-0.02873 * rssi));
    }

    private static double distanceAP2(int rssi) {
        if (-35 < rssi) return 1;
        if (-40 < rssi) return 3;
        else return (float) (1.743 * Math.exp(-0.03294 * rssi));
    }

    private static double distanceAP3(int rssi) {
        if (-35 < rssi) return 1;
        else return (float) (0.7888 * Math.exp(-0.0401 * rssi));
    }

    private static double distanceAP4(int rssi) {
        if (-35 < rssi) return 1;
        else return (float) (0.801 * Math.exp(-0.0388 * rssi));
    }

    private static double distanceAP5(int rssi) {
        if (-40 < rssi) return 2;
        else return (float) (1.545 * Math.exp(-0.03051 * rssi));
    }
}
