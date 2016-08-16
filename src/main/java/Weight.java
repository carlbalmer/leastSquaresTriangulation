import java.util.LinkedList;

/**
 * Created by carl on 16.08.16.
 */
public interface Weight {
    LinkedList<Datapoint> assignWeights(LinkedList<Datapoint> datapoints);

    Datapoint assignWeights(Datapoint datapoint);
}
