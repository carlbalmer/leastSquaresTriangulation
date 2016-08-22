import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**
 * Created by carl on 18.08.16.
 */
public class DistanceTest {

    private LinkedList<Datapoint> datapoints;
    private Datapoint datapoint1;
    private Datapoint datapoint2;
    private Datapoint datapoint3;
    private Datapoint datapoint4;

    @Before
    public void setUp() throws Exception {
        datapoints = new LinkedList<>();
        datapoints.add(new Datapoint(3, -97, -51, -42, -53, -60, 25, -24, -12, 10.573f, 11.167f));
        datapoints.add(new Datapoint(4, -85, -58, -47, -52, -41, 23, -25, -7, 14.605f, 11.195f));
        datapoints.add(new Datapoint(8, -39, -34, -34, -34, -39, -12, -47, 7, 10.332f, 3.004f));
        datapoints.add(new Datapoint(8, -49, -39, -34, -34, -39, -12, -47, 7, 10.332f, 3.004f));

        Distance.assignDistances(datapoints);

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
    public void checkDistanceNotNull() throws Exception {
        assertNotEquals(0.0, datapoint1.distances[0], 0.0);
    }

    @Test
    public void distanceAP1() throws Exception {
        assertEquals(34.8602, datapoint1.distances[0], 0.0001);
        assertEquals(24.6947, datapoint2.distances[0], 0.0001);
    }

    @Test
    public void distanceAP2() throws Exception {
        assertEquals(9.3516, datapoint1.distances[1], 0.0001);
        assertEquals(11.7768, datapoint2.distances[1], 0.0001);
    }

    @Test
    public void distanceAP3() throws Exception {
        assertEquals(4.25016, datapoint1.distances[2], 0.0001);
        assertEquals(5.19376, datapoint2.distances[2], 0.0001);
    }

    @Test
    public void distanceAP4() throws Exception {
        assertEquals(6.26204, datapoint1.distances[3], 0.0001);
        assertEquals(6.02372, datapoint2.distances[3], 0.0001);
    }

    @Test
    public void distanceAP5() throws Exception {
        assertEquals(9.63714, datapoint1.distances[4], 0.0001);
        assertEquals(5.39749, datapoint2.distances[4], 0.0001);
    }

    @Test
    public void distanceAP1threshold() throws Exception {
        assertEquals(2.0, datapoint3.distances[0], 0.0);
        assertEquals(4.0, datapoint4.distances[0], 0.0);
    }

    @Test
    public void distanceAP2threshold() throws Exception {
        assertEquals(1.0, datapoint3.distances[1], 0.0);
        assertEquals(3.0, datapoint4.distances[1], 0.0);
    }

    @Test
    public void distanceAP3threshold() throws Exception {
        assertEquals(1, datapoint3.distances[2], 0.0);
    }

    @Test
    public void distanceAP4threshold() throws Exception {
        assertEquals(1, datapoint3.distances[3], 0.0);
    }

    @Test
    public void distanceAP5threshold() throws Exception {
        assertEquals(2, datapoint3.distances[4], 0.0);
    }
}