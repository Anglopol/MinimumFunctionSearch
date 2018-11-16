package methods;

public class FibonacciSearchMethod extends AbstractMethod {

    private double n;
    private double k;

    public FibonacciSearchMethod() {
        super();
        calcN();
        k = 1;
    }

    static public double fibonacci(double n) {
        if (n - 1 <= 1) {
            return n;
        }
        return (fibonacci(n - 1) + fibonacci(n - 2));
    }

    @Override
    protected void setFirstPoint() {
        firstPoint = startOfInterval + (fibonacci(n - k - 1) / fibonacci(n - k + 1)) * (endOfInterval - startOfInterval);
    }

    @Override
    protected void setSecondPoint() {
        secondPoint = startOfInterval + (fibonacci(n - k) / fibonacci(n - k + 1)) * (endOfInterval - startOfInterval);
    }

    @Override
    public double getFunctionMinimum() {
        double firstPointFunction = functionAtPoint(firstPoint),
                secondPointFunction = functionAtPoint(secondPoint);
        for(k = 1; k < n - 2; k++) {
            if(firstPointFunction < secondPointFunction) {
                endOfInterval = secondPoint;
                secondPoint = firstPoint;
                setFirstPoint();
                secondPointFunction = firstPointFunction;
                firstPointFunction = functionAtPoint(firstPoint);
            } else {
                startOfInterval = firstPoint;
                firstPoint = secondPoint;
                setSecondPoint();
                firstPointFunction = secondPointFunction;
                secondPointFunction = functionAtPoint(secondPoint);
            }
        }

        return (startOfInterval + endOfInterval) / 2;
    }

    private void calcN() {
        n = 0;
        while ((endOfInterval - startOfInterval) / delta >= fibonacci(n + 2)) {
            n++;
        }
    }


}
