package methods;

public class FibonacciSearchMethod extends AbstractMethod {

    private static final double PHI = 1.6180339887;
    private double n;

    public FibonacciSearchMethod() {
        super();
        calcN();
        setPoints();
    }

    static public double fibonacci(double n) {
        return (Math.pow(PHI, n) - Math.pow(1 - PHI, n)) / Math.sqrt(5);
    }

    @Override
    protected void setFirstPoint() {
        firstPoint = startOfInterval + (fibonacci(n - 2) / fibonacci(n)) * (endOfInterval - startOfInterval);
    }

    @Override
    protected void setSecondPoint() {
        secondPoint = startOfInterval + (fibonacci(n - 1) / fibonacci(n)) * (endOfInterval - startOfInterval);
    }

    @Override
    public double getFunctionMinimum() {
        firstPointFunction = functionAtPoint(firstPoint);
        secondPointFunction = functionAtPoint(secondPoint);
        for(double i = n; i > 1; i--) {
            recalculate(firstPointFunction < secondPointFunction);
        }
        return (startOfInterval + endOfInterval) / 2;
    }

    @Override
    protected void recalculate(boolean expression) {
        if (expression) {
            endOfInterval = secondPoint;
            secondPoint = firstPoint;
            firstPoint = startOfInterval + (endOfInterval - secondPoint);
            secondPointFunction = firstPointFunction;
            firstPointFunction = functionAtPoint(firstPoint);
        } else {
            startOfInterval = firstPoint;
            firstPoint = secondPoint;
            secondPoint = endOfInterval - (firstPoint - startOfInterval);
            firstPointFunction = secondPointFunction;
            secondPointFunction = functionAtPoint(secondPoint);
        }
    }

    private void calcN() {
        n = 0;
        while ((endOfInterval - startOfInterval) / delta >= fibonacci(n + 2)) {
            n++;
        }
    }


}
