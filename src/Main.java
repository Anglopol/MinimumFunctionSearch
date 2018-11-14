import methods.BisectionMethod;
import methods.FibonacciSearchMethod;
import methods.GoldenSectionSearch;

public class Main {
    public static void main(String[] args) {
        GoldenSectionSearch goldenSectionSearch = new GoldenSectionSearch();
        BisectionMethod bisectionMethod = new BisectionMethod();
        FibonacciSearchMethod fibonacciSearchMethod = new FibonacciSearchMethod();
        System.out.println("Golden Section Search Method: "
                + goldenSectionSearch.getFunctionMinimum()
                + "\nBisection Method: " + bisectionMethod.getFunctionMinimum()
                + "\nFibonacci Search: " + fibonacciSearchMethod.getFunctionMinimum());
    }
}
