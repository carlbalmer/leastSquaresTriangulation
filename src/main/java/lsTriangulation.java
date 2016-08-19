import org.apache.commons.math3.fitting.leastsquares.*;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.Pair;

/**
 * Main class of the program. Handles the program flow.
 * Created by carl on 16.08.16.
 */
public class lsTriangulation {

    public static void main(String[] args) {
        final double radius = 70.0;
        final Vector2D[] observedPoints = new Vector2D[]{
                new Vector2D(5, 3),
                new Vector2D(-2, -4),
                new Vector2D(4, -3),
        };

        // the model function components are the distances to current estimated center,
        // they should be as close as possible to the specified radius
        MultivariateJacobianFunction distancesToCurrentCenter = new MultivariateJacobianFunction() {
            public Pair<RealVector, RealMatrix> value(final RealVector point) {

                Vector2D center = new Vector2D(point.getEntry(0), point.getEntry(1));

                RealVector value = new ArrayRealVector(observedPoints.length);
                RealMatrix jacobian = new Array2DRowRealMatrix(observedPoints.length, 2);

                for (int i = 0; i < observedPoints.length; ++i) {
                    Vector2D o = observedPoints[i];
                    double modelI = Vector2D.distance(o, center);
                    value.setEntry(i, modelI);
                    // derivative with respect to p0 = x center
                    jacobian.setEntry(i, 0, (center.getX() - o.getX()) / modelI);
                    // derivative with respect to p1 = y center
                    jacobian.setEntry(i, 1, (center.getX() - o.getX()) / modelI);
                }

                return new Pair<RealVector, RealMatrix>(value, jacobian);

            }
        };

        // the target is to have all points at the specified radius from the center
        double[] prescribedDistances = new double[]{5, 6, 3};
        //Arrays.fill(prescribedDistances, radius);

        // least squares problem to solve : modeled radius should be close to target radius
        LeastSquaresProblem problem = new LeastSquaresBuilder().
                start(new double[]{Math.random(), Math.random()}).
                model(distancesToCurrentCenter).
                target(prescribedDistances).
                lazyEvaluation(false).
                maxEvaluations(1000).
                maxIterations(1000).
                checker(new EvaluationRmsChecker(0)).
                build();
        LeastSquaresOptimizer.Optimum optimum = new LevenbergMarquardtOptimizer().optimize(problem);
        Vector2D fittedCenter = new Vector2D(optimum.getPoint().getEntry(0), optimum.getPoint().getEntry(1));
        System.out.println("fitted center: " + fittedCenter.getX() + " " + fittedCenter.getY());
        System.out.println("RMS: " + optimum.getRMS());
        System.out.println("evaluations: " + optimum.getEvaluations());
        System.out.println("iterations: " + optimum.getIterations());
    }
}
