package methods;

import function.Function;

public class GoldenSectionSearch extends AbstractMethod {

    private double delta = Function.EPSILON / 4;

    public GoldenSectionSearch() {
        startOfInterval = Function.START_OF_INTERVAL;
        endOfInterval = Function.END_OF_INTERVAL;
        setPoints();
    }

    @Override
    protected void setFirstPoint() {
        firstPoint = startOfInterval + ((3 - Math.sqrt(5)) / 2)
                * (endOfInterval - startOfInterval);
    }

    @Override
    protected void setSecondPoint() {
        secondPoint = startOfInterval + ((Math.sqrt(5) - 1) / 2)
                * (endOfInterval - startOfInterval);
    }

    @Override
    public double getFunctionMinimum() {
        double firstPointFunction = Function.functionAtPoint(firstPoint),
                secondPointFunction = Function.functionAtPoint(secondPoint);
        while (Math.abs(endOfInterval - startOfInterval) > delta) {
            if(firstPointFunction < secondPointFunction) {
                endOfInterval = secondPoint;
                secondPoint = firstPoint;
                secondPointFunction = firstPointFunction;
                setFirstPoint();
                firstPointFunction = Function.functionAtPoint(firstPoint);
            } else {
                startOfInterval = firstPoint;
                firstPoint = secondPoint;
                firstPointFunction = secondPointFunction;
                setSecondPoint();
                secondPointFunction = Function.functionAtPoint(secondPoint);
            }
        }
        return (startOfInterval + endOfInterval) / 2;
    }
}
