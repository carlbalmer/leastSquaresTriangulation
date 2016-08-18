import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;

/**
 * Reads out a file with datapoints (from the room recocognition) and parses it into a Datapoint objects.
 * Created by carl on 15.08.16.
 */
public class FileReader {

    public static LinkedList<Datapoint> readDatapoints(String filename) throws IOException {
        LinkedList<Datapoint> datapoints = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(filename));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            datapoints.add(parseLine(line));
        }
        bufferedReader.close();
        return datapoints;
    }

    private static Datapoint parseLine(String line) {
        String[] splittedLine = line.split("[ :]");
        return new Datapoint(Integer.parseInt(splittedLine[0]), Integer.parseInt(splittedLine[8]), Integer.parseInt(splittedLine[10]), Integer.parseInt(splittedLine[2]), Integer.parseInt(splittedLine[4]), Integer.parseInt(splittedLine[6]), Integer.parseInt(splittedLine[12]), Integer.parseInt(splittedLine[14]), Integer.parseInt(splittedLine[16]), Float.parseFloat(splittedLine[17]), Float.parseFloat(splittedLine[18]));
    }
}