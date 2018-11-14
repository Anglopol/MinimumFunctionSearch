package methods;

import function.Function;

public class BisectionMethod extends AbstractMethod {

    private double delta = Function.EPSILON / 4;

    public BisectionMethod() {
        startOfInterval = Function.START_OF_INTERVAL;
        endOfInterval = Function.END_OF_INTERVAL;
        setPoints();
    }


    @Override
    protected void setFirstPoint() {
        firstPoint = (startOfInterval + endOfInterval) / 2 - delta;
    }

    @Override
    protected void setSecondPoint() {
        secondPoint = (startOfInterval + endOfInterval) / 2 + delta;
    }

    @Override
    public double getFunctionMinimum() {
        while (Math.abs(endOfInterval - startOfInterval) > delta) {
            if (Function.functionAtPoint(firstPoint) > Function.functionAtPoint(secondPoint)) {
                startOfInterval = secondPoint;
            } else {
                endOfInterval = firstPoint;
            }
            setPoints();
        }
        return (startOfInterval + endOfInterval) / 2;
    }
}
