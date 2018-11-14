package function;

public class Function {

    public static final int START_OF_INTERVAL = 2;
    public static final int END_OF_INTERVAL = 200;
    public static final double EPSILON = 0.001;

    public static double functionAtPoint(double x) {
        return Math.pow((x - 15), 2) + 5;
    }

}
