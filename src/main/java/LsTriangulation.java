import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.io.IOException;
import java.util.LinkedList;

/**
 * Main class of the program. Handles the program flow.
 * Created by carl on 16.08.16.
 */
public class LsTriangulation {

    static final Vector2D[] accespoints = new Vector2D[]{
            new Vector2D(0.93, 1.22),
            new Vector2D(4.63, 15.88),
            new Vector2D(14.4, 14.2),
            new Vector2D(13.6, 1.6),
            new Vector2D(10.57, 14.74)};


    public static void main(String[] args) throws IOException {
        String input = "input.csv";
        String output = "output.csv";

        LinkedList<Datapoint> datapoints;

        datapoints = FileReader.readDatapoints(input);
        Distance.assignDistances(datapoints);
        Weight weight = new InverselyProportionalWeight();
        weight.assignWeights(datapoints);

        Triangulation triangulation = new Triangulation(accespoints);
        triangulation.triangulate(datapoints);
        Writer.writeDatapoints(datapoints, output);
    }
}
