package methods;

import function.Function;

public class GoldenSectionSearch extends AbstractMethod {

    private double firstPoint, secondPoint;
    private double startOfInterval, endOfInterval;

    public GoldenSectionSearch() {
        startOfInterval = Function.START_OF_INTERVAL;
        endOfInterval = Function.END_OF_INTERVAL;
        setPoints();
    }

    @Override
    protected void setPoints() {
        firstPoint = startOfInterval + ((3 - Math.sqrt(5)) / 2)
                * (endOfInterval - startOfInterval);
        secondPoint = startOfInterval + ((Math.sqrt(5) - 1) / 2)
                * (endOfInterval - startOfInterval);
    }

    @Override
    public double getFunctionMinimum() {
        return 0;
    }
}
