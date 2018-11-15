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
    public double getFunctionMinimum() {
        while (Math.abs(endOfInterval - startOfInterval) > delta) {
            if (functionAtPoint(firstPoint) > functionAtPoint(secondPoint)) {
                startOfInterval = secondPoint;
            } else {
                endOfInterval = firstPoint;
            }
            setPoints();
        }
        return (startOfInterval + endOfInterval) / 2;
    }
}
