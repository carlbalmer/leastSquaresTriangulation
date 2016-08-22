import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by carl on 15.08.16.
 */


public class FileReaderTest {

    LinkedList<Datapoint> datapoints;
    Datapoint datapoint1;
    Datapoint datapoint2;
    Datapoint datapoint3;

    @Before
    public void setUp() throws Exception {
        datapoints = FileReader.readDatapoints("src/test/resources/testInputFile.txt");
        datapoint1 = datapoints.remove();
        datapoint2 = datapoints.remove();
        datapoint3 = datapoints.remove();
    }

    @Test
    public void checkLinkedListIsEmpty() throws Exception {
        assertTrue(datapoints.isEmpty());
    }

    @Test
    public void checkRoom() throws Exception {
        assertEquals(1, datapoint1.room);
        assertEquals(4, datapoint2.room);
        assertEquals(2, datapoint3.room);
    }

    @Test
    public void checkRSSI() throws Exception {
        assertEquals(-41, datapoint1.rssiAP1);
        assertEquals(-80, datapoint2.rssiAP1);
        assertEquals(-59, datapoint3.rssiAP1);

        assertEquals(-64, datapoint1.rssiAP2);
        assertEquals(-50, datapoint2.rssiAP2);
        assertEquals(-36, datapoint3.rssiAP2);

        assertEquals(-74, datapoint1.rssiAP3);
        assertEquals(-38, datapoint2.rssiAP3);
        assertEquals(-51, datapoint3.rssiAP3);

        assertEquals(-62, datapoint1.rssiAP4);
        assertEquals(-58, datapoint2.rssiAP4);
        assertEquals(-73, datapoint3.rssiAP4);

        assertEquals(-80, datapoint1.rssiAP5);
        assertEquals(-49, datapoint2.rssiAP5);
        assertEquals(-47, datapoint3.rssiAP5);
    }

    @Test
    public void checkMagnetometer() throws Exception {
        assertEquals(23, datapoint1.XAxys);
        assertEquals(21, datapoint2.XAxys);
        assertEquals(13, datapoint3.XAxys);

        assertEquals(-7, datapoint1.YAxys);
        assertEquals(-23, datapoint2.YAxys);
        assertEquals(10, datapoint3.YAxys);

        assertEquals(-41, datapoint1.ZAxys);
        assertEquals(-5, datapoint2.ZAxys);
        assertEquals(-24, datapoint3.ZAxys);
    }

    @Test
    public void checkPosition() throws Exception {
        assertEquals(1.562f, datapoint1.position.getX(), 0.0f);
        assertEquals(15.776f, datapoint2.position.getX(), 0.0f);
        assertEquals(7.023f, datapoint3.position.getX(), 0.0f);

        assertEquals(2.26f, datapoint1.position.getY(), 0.0f);
        assertEquals(11.563f, datapoint2.position.getY(), 0.0f);
        assertEquals(14.752f, datapoint3.position.getY(), 0.0f);
    }

}