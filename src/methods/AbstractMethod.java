package methods;

import function.Function;

public abstract class AbstractMethod {
    protected double firstPoint, secondPoint;
    protected double startOfInterval, endOfInterval;
    protected double firstPointFunction, secondPointFunction;

    protected double delta = Function.EPSILON / 4;

    protected void setPoints() {
        setFirstPoint();
        setSecondPoint();
    }

    public AbstractMethod() {
        startOfInterval = Function.START_OF_INTERVAL;
        endOfInterval = Function.END_OF_INTERVAL;
        setPoints();
    }

    protected double functionAtPoint(double x) {
        return Function.functionAtPoint(x);
    }

    protected void showCurrentCondition() {
        System.out.println("x1: " + firstPoint
                + "\nx2: " + secondPoint
                + "\na: " + startOfInterval
                + "\nb: " + endOfInterval
                + "\nf(x1) = " + functionAtPoint(firstPoint)
                + "\nf(x2) = " + functionAtPoint(secondPoint) + "\n");
    }

    protected abstract void setFirstPoint();
    protected abstract void setSecondPoint();
    protected abstract void recalculate(boolean expression);
    public abstract double getFunctionMinimum();
}
