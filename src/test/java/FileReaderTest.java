import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by carl on 15.08.16.
 */


public class FileReaderTest {

    @Test
    public void readDatapoints() throws Exception {
        LinkedList<Datapoint> datapoints = FileReader.readDatapoints("src/test/resources/testInputFile.txt");
        Datapoint datapoint1 = datapoints.remove();
        Datapoint datapoint2 = datapoints.remove();
        Datapoint datapoint3 = datapoints.remove();
        assertTrue(datapoints.isEmpty());

        assertEquals(1, datapoint1.room);
        assertEquals(4, datapoint2.room);
        assertEquals(2, datapoint3.room);

        assertEquals(-74, datapoint1.rssiAP1);
        assertEquals(-38, datapoint2.rssiAP1);
        assertEquals(-51, datapoint3.rssiAP1);

        assertEquals(-62, datapoint1.rssiAP2);
        assertEquals(-58, datapoint2.rssiAP2);
        assertEquals(-73, datapoint3.rssiAP2);

        assertEquals(-80, datapoint1.rssiAP3);
        assertEquals(-49, datapoint2.rssiAP3);
        assertEquals(-47, datapoint3.rssiAP3);

        assertEquals(-41, datapoint1.rssiAP4);
        assertEquals(-80, datapoint2.rssiAP4);
        assertEquals(-59, datapoint3.rssiAP4);

        assertEquals(-64, datapoint1.rssiAP5);
        assertEquals(-50, datapoint2.rssiAP5);
        assertEquals(-36, datapoint3.rssiAP5);

        assertEquals(23, datapoint1.XAxys);
        assertEquals(21, datapoint2.XAxys);
        assertEquals(13, datapoint3.XAxys);

        assertEquals(-7, datapoint1.YAxys);
        assertEquals(-23, datapoint2.YAxys);
        assertEquals(10, datapoint3.YAxys);

        assertEquals(-41, datapoint1.ZAxys);
        assertEquals(-5, datapoint2.ZAxys);
        assertEquals(-24, datapoint3.ZAxys);

        assertEquals(1.562f, datapoint1.XPosition, 0.0f);
        assertEquals(15.776f, datapoint2.XPosition, 0.0f);
        assertEquals(7.023f, datapoint3.XPosition, 0.0f);

        assertEquals(2.26f, datapoint1.YPosition, 0.0f);
        assertEquals(11.563f, datapoint2.YPosition, 0.0f);
        assertEquals(14.752f, datapoint3.YPosition, 0.0f);
    }

}