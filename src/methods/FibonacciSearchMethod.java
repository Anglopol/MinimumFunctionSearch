package methods;

public class FibonacciSearchMethod extends AbstractMethod {

    private double n;

    public FibonacciSearchMethod() {
        super();
        calcN();
    }

    static public double fibonacci(double n) {
        if (n - 1 <= 1) {
            return n;
        }
        return (fibonacci(n - 1) + fibonacci(n - 2));
    }

    @Override
    protected void setFirstPoint() {
        firstPoint = startOfInterval + (fibonacci(n) / fibonacci(n + 2)) * (endOfInterval - startOfInterval);
    }

    @Override
    protected void setSecondPoint() {
        secondPoint = startOfInterval + (fibonacci(n + 1) / fibonacci(n + 2)) * (endOfInterval - startOfInterval);
    }

    @Override
    public double getFunctionMinimum() {
        return 0;
    }

    private void calcN() {
        n = 0;
        while ((endOfInterval - startOfInterval) / delta >= fibonacci(n + 2)) {
            n++;
        }
    }


}
