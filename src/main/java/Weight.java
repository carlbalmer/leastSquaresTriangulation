import java.util.LinkedList;

/**
 * Interface for the Weights. Allows for different ways to assign the weights to be tried out.
 * Created by carl on 16.08.16.
 */
public interface Weight {
    void assignWeights(LinkedList<Datapoint> datapoints);

    Datapoint assignWeights(Datapoint datapoint);
}