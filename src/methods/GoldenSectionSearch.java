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
    protected void recalculate(boolean expression) {
        if(expression) {
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

    @Override
    public double getFunctionMinimum() {
        System.out.println("Golden Section Search");
        firstPointFunction = functionAtPoint(firstPoint);
        secondPointFunction = functionAtPoint(secondPoint);
        showCurrentCondition();
        while (Math.abs(endOfInterval - startOfInterval) > delta) {
            recalculate(firstPointFunction < secondPointFunction);
            showCurrentCondition();
        }
        return (startOfInterval + endOfInterval) / 2;
    }

}
