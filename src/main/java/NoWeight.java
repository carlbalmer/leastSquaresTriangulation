import java.util.LinkedList;

/**
 * Created by carl on 22.08.16.
 */
public class NoWeight implements Weight {
    @Override
    public void assignWeights(LinkedList<Datapoint> datapoints) {
        for (int i = 0, len = datapoints.size(); i < len; i++) {
            datapoints.add(assignWeights(datapoints.remove()));
        }

    }

    @Override
    public Datapoint assignWeights(Datapoint datapoint) {
        double[] weights = new double[]{1, 1, 1, 1, 1};
        datapoint.weights = weights;
        return datapoint;
    }
}
