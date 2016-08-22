import java.util.LinkedList;

/**
 * Assigns weights to the distances based on the formula di = di/sum(di)
 * Created by carl on 16.08.16.
 */
public class InverselyProportionalWeight implements Weight {
    public void assignWeights(LinkedList<Datapoint> datapoints) {
        for (int i = 0, len = datapoints.size(); i < len; i++) {
            datapoints.add(assignWeights(datapoints.remove()));
        }
    }

    public Datapoint assignWeights(Datapoint datapoint) {
        double sum = 1 / datapoint.distances[0] + 1 / datapoint.distances[1] + 1 / datapoint.distances[2] + 1 / datapoint.distances[3] + 1 / datapoint.distances[4];
        double[] weights = new double[]{
                1 / datapoint.distances[0] / sum,
                1 / datapoint.distances[1] / sum,
                1 / datapoint.distances[2] / sum,
                1 / datapoint.distances[3] / sum,
                1 / datapoint.distances[4] / sum};
        datapoint.weights = weights;

        return datapoint;
    }
}
