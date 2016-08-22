import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by carl on 18.08.16.
 */
public class inverselyProportionalWeightTest {

    private LinkedList<Datapoint> datapoints;
    private Datapoint datapoint1;
    private Datapoint datapoint2;
    private Datapoint datapoint3;
    private Datapoint datapoint4;


    @Before
    public void setUp() throws Exception {
        Weight weight = new InverselyProportionalWeight();
        datapoints = new LinkedList<>();
        datapoints.add(new Datapoint(3, -97, -51, -42, -53, -60, 25, -24, -12, 10.573f, 11.167f));
        datapoints.add(new Datapoint(4, -85, -58, -47, -52, -41, 23, -25, -7, 14.605f, 11.195f));
        datapoints.add(new Datapoint(8, -39, -34, -34, -34, -39, -12, -47, 7, 10.332f, 3.004f));
        datapoints.add(new Datapoint(8, -49, -39, -34, -34, -39, -12, -47, 7, 10.332f, 3.004f));

        Distance.assignDistances(datapoints);
        weight.assignWeights(datapoints);

        datapoint1 = datapoints.remove();
        datapoint2 = datapoints.remove();
        datapoint3 = datapoints.remove();
        datapoint4 = datapoints.remove();
    }

    @Test
    public void checkLinkedListIsEmpty() throws Exception {
        assertTrue(datapoints.isEmpty());
    }

    @Test
    public void checkWeightsNotNull() throws Exception {
        assertNotEquals(0.0, datapoint1.weights[0], 0.0);
    }

    @Test
    public void weightsDatapoint1() throws Exception {
        assertEquals(0.0452202197f, datapoint1.weights[0], 0.0001f);
        assertEquals(0.1685685768f, datapoint1.weights[1], 0.0001f);
        assertEquals(0.3709003668f, datapoint1.weights[2], 0.0001f);
        assertEquals(0.2517367987f, datapoint1.weights[3], 0.0001f);
        assertEquals(0.1635403785f, datapoint1.weights[4], 0.0001f);
    }

    @Test
    public void weightSumIs1() throws Exception {
        assertEquals(1, datapoint1.weights[0] + datapoint1.weights[1] + datapoint1.weights[2] + datapoint1.weights[3] + datapoint1.weights[4], 0.00000000001f);
    }

}