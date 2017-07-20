package ModerateProblems;

import java.awt.*;

/**
 * Created by amritachowdhury on 7/2/17.
 */
public class coding_16_3 {

    public class Line {
        Point start, end;

        public Line(int startX, int startY, int endX, int endY) {
            this.start = new Point(startX, startY);
            this.end = new Point(endX, endY);
        }
    }

    public void run() {
        Line line1 = new Line(1, 5, 20, 6);
        Line line2 = new Line(1, 6, 8, 2);
        if (areLinesParallel(line1, line2)) {
            System.out.println("These are parallel lines, they never meet");
        } else {
            Point intersectingPoint = computeIntersection(line1, line2);
            System.out.println("x : " + intersectingPoint.getX() + " y : " + intersectingPoint.getY());
        }
    }

    private boolean areLinesParallel(Line line1, Line line2) {
        double slope1 = getSlopeOfLine(line1.start, line1.end);
        double slope2 = getSlopeOfLine(line2.start, line2.end);
        return slope1 == slope2;
    }
     private double getSlopeOfLine(Point start, Point end)  {
        double slope = (end.getY() - start.getY()) / (end.getX() - start.getX());
        return slope;
     }

     private double getInterceptOfLine(Line line) {
         double slope = getSlopeOfLine(line.start, line.end);
         double y = line.end.getY();
         double x = line.end.getX();
         double intercept = y - slope * x;
         return intercept;
         // y = mx + c
     }

     private Point computeIntersection(Line line1, Line line2) {
        double slope1 = getSlopeOfLine(line1.start, line1.end);
        double slope2 = getSlopeOfLine(line2.start, line2.end);
        double intercept1 = getInterceptOfLine(line1);
        double intercept2 = getInterceptOfLine(line2);
        double intersectionX = (intercept2 - intercept1) / (slope1 - slope2);
        double intersectionY = slope1 * intersectionX + intercept1;
        Point intersectionPoint = new Point((int)intersectionX, (int)intersectionY);
        return  intersectionPoint;
         //y = slope * x + intercept1;
     }

}
