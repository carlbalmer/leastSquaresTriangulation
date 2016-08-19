public class Triangulation {

    /*final Vector2D[] observedPoints;

    public Triangulation(int AP1x, int AP1y, int AP2x, int AP2y, int AP3x, int AP3y, int AP4x, int AP4y, int AP5x, int AP5y,) {
        this.observedPoints = new Vector2D[]{
                new Vector2D(AP1x, AP1y),
                new Vector2D(AP2x, AP2y),
                new Vector2D(AP3x, AP3y),
                new Vector2D(AP4x, AP4y),
                new Vector2D(AP5x, AP5y)};
    }

    final double radius = 70.0;

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
    double[] prescribedDistances = new double[observedPoints.length];
    Arrays.fill(prescribedDistances,radius);

    // least squares problem to solve : modeled radius should be close to target radius
    LeastSquaresProblem problem = new LeastSquaresBuilder().
            start(new double[]{100.0, 50.0}).
            model(distancesToCurrentCenter).
            target(prescribedDistances).
            lazyEvaluation(false).
            maxEvaluations(1000).
            maxIterations(1000).
            build();
    LeastSquaresOptimizer.Optimum optimum = new LevenbergMarquardtOptimizer().optimize(problem);
    Vector2D fittedCenter = new Vector2D(optimum.getPoint().getEntry(0), optimum.getPoint().getEntry(1));
    System.out.println("fitted center: "+fittedCenter.getX()+" "+fittedCenter.getY());
    System.out.println("RMS: "+optimum.getRMS());
    System.out.println("evaluations: "+optimum.getEvaluations());
    System.out.println("iterations: "+optimum.getIterations());*/
}