import methods.BisectionMethod;
import methods.FibonacciSearchMethod;
import methods.GoldenSectionSearch;

public class Main {
    public static void main(String[] args) {
        GoldenSectionSearch goldenSectionSearch = new GoldenSectionSearch();
        BisectionMethod bisectionMethod = new BisectionMethod();
        System.out.println("Golden Section Search Method: "
                + goldenSectionSearch.getFunctionMinimum()
                + "\nBisection Method: " + bisectionMethod.getFunctionMinimum());
        System.out.print("\n" + FibonacciSearchMethod.fibonacci(3));
    }
}
