package methods;

public class BisectionMethod extends AbstractMethod {

    @Override
    protected void setFirstPoint() {
        firstPoint = (startOfInterval + endOfInterval) / 2 - delta;
    }

    @Override
    protected void setSecondPoint() {
        secondPoint = (startOfInterval + endOfInterval) / 2 + delta;
    }

    @Override
    protected void recalculate(boolean expression) {
        if(expression) {
            startOfInterval = secondPoint;
        } else {
            endOfInterval = firstPoint;
        }
    }

    @Override
    public double getFunctionMinimum() {
        while (Math.abs(endOfInterval - startOfInterval) > delta) {
            firstPointFunction = functionAtPoint(firstPoint);
            secondPointFunction = functionAtPoint(secondPoint);
            recalculate (firstPointFunction > secondPointFunction);
            setPoints();
        }
        return (startOfInterval + endOfInterval) / 2;
    }
}
