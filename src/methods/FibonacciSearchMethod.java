package methods;

import function.Function;

public class FibonacciSearchMethod extends AbstractMethod {

    private int n;

    public FibonacciSearchMethod() {
        super();
        calcN();
    }

    static public int fibonacci(int n) {
        if (n - 1 <= 1) {
            return n;
        }
        return (fibonacci(n - 1) + fibonacci(n - 2));
    }

    @Override
    protected void setFirstPoint() {

    }

    @Override
    protected void setSecondPoint() {

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
