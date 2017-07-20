package ModerateProblems;

import java.awt.*;

/**
 * Created by amritachowdhury on 7/4/17.
 */
public class coding_16_13 {

    public class Square {
        Point bottomLeft, topLeft, topRight, bottomRight, center;

        public Square(int x, int y, int length) {
            this.bottomLeft = new Point();
            this.bottomLeft.setLocation(x, y);
            this.topLeft = new Point();
            this.topLeft.setLocation(x, y + length);
            this.topRight = new Point();
            this.topRight.setLocation(x + length, y + length);
            this.bottomRight = new Point();
            this.bottomRight.setLocation(x + length, y);
            this.center = new Point();
            this.center.setLocation(x + length / 2, y + length / 2);
        }
    }

    public class Line {
        Point start; Point end;

        public Line(Point start, Point end) {
            this.start = start;
            this.end = end;
        }

        public void printLine() {
            System.out.println("start : ( " + start.getX() + ", " + start.getY() + " )");
            System.out.println("end : ( " + end.getX() + ", " + end.getY() + " )");
        }
    }

    private Line bisectSquare(Square s1, Square s2) {
        Line line = new Line(s1.center, s2.center);
        return line;
    }

    public void run() {
        Square s1 = new Square (1, 2, 6);
        Square s2 = new Square (10, 4, 4);
        Line bisection = bisectSquare(s1, s2);
        bisection.printLine();

    }
}
