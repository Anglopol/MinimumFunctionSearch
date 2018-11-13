package methods;

public abstract class AbstractMethod {
    public AbstractMethod() {
        setPoints();
    }

    protected abstract void setPoints();

    public abstract double getFunctionMinimum();
}
