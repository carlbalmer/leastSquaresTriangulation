import org.apache.commons.math3.fitting.leastsquares.LeastSquaresProblem.Evaluation;
import org.apache.commons.math3.optim.ConvergenceChecker;

public class EvaluationRmsChecker2 implements ConvergenceChecker<Evaluation> {
    /**
     * relative tolerance for comparisons.
     */
    private final double relTol;
    /**
     * absolute tolerance for comparisons.
     */
    private final double absTol;

    public EvaluationRmsChecker2(final double tol) {
        this(tol, tol);
    }

    public EvaluationRmsChecker2(final double relTol, final double absTol) {
        this.relTol = relTol;
        this.absTol = absTol;
    }

    public boolean converged(final int iteration,
                             final Evaluation previous,
                             final Evaluation current) {
        final double prevRms = previous.getRMS();
        final double currRms = current.getRMS();
        return false;
        //return Precision.equals(prevRms, currRms, this.absTol) ||
        //      Precision.equalsWithRelativeTolerance(prevRms, currRms, this.relTol);
    }
}



























































