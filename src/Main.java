import methods.AbstractMethod;
import methods.BisectionMethod;
import methods.FibonacciSearchMethod;
import methods.GoldenSectionSearch;

public class Main {
    public static void main(String[] args) {
        AbstractMethod goldenSectionSearch = new GoldenSectionSearch();
        AbstractMethod bisectionMethod = new BisectionMethod();
        AbstractMethod fibonacciSearchMethod = new FibonacciSearchMethod();
        System.out.println("Golden Section Search Method: "
                + goldenSectionSearch.getFunctionMinimum()
                + "\nBisection Method: " + bisectionMethod.getFunctionMinimum()
                + "\nFibonacci Search: " + fibonacciSearchMethod.getFunctionMinimum());
    }
}
