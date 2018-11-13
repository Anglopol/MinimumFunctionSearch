package methods;

public abstract class AbstractMethod {
    protected double firstPoint, secondPoint;
    protected double startOfInterval, endOfInterval;
    protected void setPoints() {
        setFirstPoint();
        setSecondPoint();
    }

    protected abstract void setFirstPoint();
    protected abstract void setSecondPoint();

    public abstract double getFunctionMinimum();
}
