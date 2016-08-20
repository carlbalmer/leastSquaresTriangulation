import org.apache.commons.math3.fitting.leastsquares.*;
import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.math3.util.Pair;

public class Triangulation {

    MultivariateJacobianFunction distancesToCurrentCenter;
    private Vector2D[] observedPoints;


    public Triangulation(int AP1x, int AP1y, int AP2x, int AP2y, int AP3x, int AP3y) {
        this.observedPoints = new Vector2D[]{
                new Vector2D(AP1x, AP1y),
                new Vector2D(AP2x, AP2y),
                new Vector2D(AP3x, AP3y)};

        createModel();
    }

    // the model function components are the distances to current estimated center,
    // they should be as close as possible to the specified radius
    private void createModel() {
        distancesToCurrentCenter = new MultivariateJacobianFunction() {
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
                    jacobian.setEntry(i, 1, (center.getY() - o.getY()) / modelI);
                }

                return new Pair<RealVector, RealMatrix>(value, jacobian);

            }
        };
    }

    public void solveProvlem(double[] prescribedDistances) {
        // least squares problem to solve : modeled radius should be close to target radius
        LeastSquaresProblem problem = new LeastSquaresBuilder().
                start(new double[]{Math.random(), Math.random()}).
                model(distancesToCurrentCenter).
                target(prescribedDistances).
                lazyEvaluation(false).
                maxEvaluations(1000).
                maxIterations(1000).
                build();
        LeastSquaresOptimizer.Optimum optimum = new LevenbergMarquardtOptimizer().optimize(problem);
        Vector2D fittedCenter = new Vector2D(optimum.getPoint().getEntry(0), optimum.getPoint().getEntry(1));
        System.out.println("fitted center: " + fittedCenter.getX() + " " + fittedCenter.getY());
        System.out.println("RMS: " + optimum.getRMS());
        System.out.println("evaluations: " + optimum.getEvaluations());
        System.out.println("iterations: " + optimum.getIterations());
    }
}