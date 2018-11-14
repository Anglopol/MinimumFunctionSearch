package methods;

import function.Function;

public abstract class AbstractMethod {
    protected double firstPoint, secondPoint;
    protected double startOfInterval, endOfInterval;
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

    protected abstract void setFirstPoint();
    protected abstract void setSecondPoint();

    public abstract double getFunctionMinimum();
}
