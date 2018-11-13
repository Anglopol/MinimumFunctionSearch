package methods;

import function.Function;

public class GoldenSectionSearch extends AbstractMethod {
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
        double ai = Function.functionAtPoint(firstPoint), bi = Function.functionAtPoint(secondPoint);
        while (Math.abs(endOfInterval - startOfInterval) > Function.EPSILON) {
            if (ai >= bi) {
                startOfInterval = firstPoint;
                firstPoint = secondPoint;
                setSecondPoint();
                ai = Function.functionAtPoint(firstPoint);
            } else {
                endOfInterval = secondPoint;
                secondPoint = firstPoint;
                setFirstPoint();
                bi = Function.functionAtPoint(secondPoint);
            }
        }
        return (startOfInterval + endOfInterval) / 2;
    }
}
