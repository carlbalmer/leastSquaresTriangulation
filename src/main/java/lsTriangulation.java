/**
 * Main class of the program. Handles the program flow.
 * Created by carl on 16.08.16.
 */
public class lsTriangulation {

    public static void main(String[] args) {
        Triangulation triangulation = new Triangulation(5, 3, -2, -4, 4, -3);
        triangulation.solveProvlem(new double[]{5, 6, 3});
    }
}
