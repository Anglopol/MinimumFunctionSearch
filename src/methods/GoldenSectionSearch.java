package methods;

public class GoldenSectionSearch extends AbstractMethod {

    @Override
    protected void setFirstPoint() {
        firstPoint = startOfInterval + ((3 - Math.sqrt(5)) / 2)
                * (endOfInterval - startOfInterval);
    }

    @Override
    protected void setSecondPoint() {
        secondPoint = startOfInterval + ((Math.sqrt(5) - 1) / 2)
                * (endOfInterval - startOfInterval);
    }

    @Override
    public double getFunctionMinimum() {
        double firstPointFunction = functionAtPoint(firstPoint),
                secondPointFunction = functionAtPoint(secondPoint);
        while (Math.abs(endOfInterval - startOfInterval) > delta) {
            if(firstPointFunction < secondPointFunction) {
                endOfInterval = secondPoint;
                secondPoint = firstPoint;
                secondPointFunction = firstPointFunction;
                setFirstPoint();
                firstPointFunction = functionAtPoint(firstPoint);
            } else {
                startOfInterval = firstPoint;
                firstPoint = secondPoint;
                firstPointFunction = secondPointFunction;
                setSecondPoint();
                secondPointFunction = functionAtPoint(secondPoint);
            }
        }
        return (startOfInterval + endOfInterval) / 2;
    }

}
