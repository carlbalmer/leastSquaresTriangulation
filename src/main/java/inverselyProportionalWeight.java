import java.util.LinkedList;

/**
 * Assigns weights to the distances based on the formula di = di/sum(di)
 * Created by carl on 16.08.16.
 */
public class inverselyProportionalWeight implements Weight {
    public LinkedList<Datapoint> assignWeights(LinkedList<Datapoint> datapoints) {
        LinkedList<Datapoint> output = new LinkedList<Datapoint>();
        while (!datapoints.isEmpty()) {
            output.add(assignWeights(datapoints.remove()));
        }
        return output;
    }

    public Datapoint assignWeights(Datapoint datapoint) {
        float sum = datapoint.distanceAP1 + datapoint.distanceAP2 + datapoint.distanceAP3 + datapoint.distanceAP4 + datapoint.distanceAP5;
        datapoint.weightAP1 = datapoint.distanceAP1 / sum;
        datapoint.weightAP2 = datapoint.distanceAP2 / sum;
        datapoint.weightAP3 = datapoint.distanceAP3 / sum;
        datapoint.weightAP4 = datapoint.distanceAP4 / sum;
        datapoint.weightAP5 = datapoint.distanceAP5 / sum;
        return datapoint;
    }
}
