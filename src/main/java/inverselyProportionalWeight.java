import java.util.LinkedList;

/**
 * Assigns weights to the distances based on the formula di = di/sum(di)
 * Created by carl on 16.08.16.
 */
public class inverselyProportionalWeight implements Weight {
    public void assignWeights(LinkedList<Datapoint> datapoints) {
        for (int i = 0, len = datapoints.size(); i < len; i++) {
            datapoints.add(assignWeights(datapoints.remove()));
        }
    }

    public Datapoint assignWeights(Datapoint datapoint) {
        float sum = 1 / datapoint.distanceAP1 + 1 / datapoint.distanceAP2 + 1 / datapoint.distanceAP3 + 1 / datapoint.distanceAP4 + 1 / datapoint.distanceAP5;
        datapoint.weightAP1 = 1 / datapoint.distanceAP1 / sum;
        datapoint.weightAP2 = 1 / datapoint.distanceAP2 / sum;
        datapoint.weightAP3 = 1 / datapoint.distanceAP3 / sum;
        datapoint.weightAP4 = 1 / datapoint.distanceAP4 / sum;
        datapoint.weightAP5 = 1 / datapoint.distanceAP5 / sum;
        return datapoint;
    }
}
