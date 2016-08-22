import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Created by carl on 22.08.16.
 */
public class Writer {
    public static void writeDatapoints(LinkedList<Datapoint> datapoints, String filename) throws IOException {
        File file = new File(filename);
        // creates the file
        file.createNewFile();
        // creates a Writer Object
        FileWriter fileWriter = new FileWriter(file);
        // Writes the first line of labels
        fileWriter.write("X Y assumedX assumedY Error RSM Room AP1distance AP2distance AP3distance AP4distance AP5distance AP1weight AP2weight AP3weight AP4weight AP5weight AP1rssi AP2rssi AP3rssi AP4rssi AP5rssi MAG-X MAG-Y MAG-Z\n");
        while (!datapoints.isEmpty()) {
            fileWriter.append(datapoints.remove().toString() + "\n");
        }
        fileWriter.flush();
        fileWriter.close();

    }

}
