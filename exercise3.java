
record Point(int x, int y) {
}

// A record to represent boundaries
record Boundaries(Point min, Point max) {}

// This is an abstract class for all shapes
public abstract class Shape {
    public abstract double getArea();
    public abstract Boundaries getBoundaries();
}

public class Circle extends Shape {
    private final Point center;
    private final Point perimeterPoint;

    public Circle(Point center, Point perimeterPoint) {
        this.center = center;
        this.perimeterPoint = perimeterPoint;
    }

    @Override
    public Boundaries getBoundaries() {
        int minX = Math.min(center.x(), perimeterPoint.x());
        int minY = Math.min(center.y(), perimeterPoint.y());
        int maxX = Math.max(center.x(), perimeterPoint.x());
        int maxY = Math.max(center.y(), perimeterPoint.y());
        return new Boundaries(new Point(minX, minY), new Point(maxX, maxY));
    }

    @Override
    public double getArea() {
        Boundaries boundaries = getBoundaries();
        int dx = boundaries.max().x() - boundaries.min().x();
        int dy = boundaries.max().y() - boundaries.min().y();
        return Math.PI * (dx * dx + dy * dy);
    }
}

public class Triangle extends Shape {
    private final List<Point> corners;

    public Triangle(List<Point> corners) {
        this.corners = corners;
    }

    @Override
    public Boundaries getBoundaries() {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (Point p : corners) {
            minX = Math.min(minX, p.x());
            minY = Math.min(minY, p.y());
            maxX = Math.max(maxX, p.x());
            maxY = Math.max(maxY, p.y());
        }
        return new Boundaries(new Point(minX, minY), new Point(maxX, maxY));
    }

    @Override
    public double getArea() {
        Boundaries boundaries = getBoundaries();
        return (double) (boundaries.max().x() - boundaries.min().x()) * (boundaries.max().y() - boundaries.min().y()) / 2.0;
    }
}

public class Quadrilateral extends Shape {
    private final List<Point> corners;

    public Quadrilateral(List<Point> corners) {
        this.corners = corners;
    }

    @Override
    public Boundaries getBoundaries() {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (Point p : corners) {
            minX = Math.min(minX, p.x());
            minY = Math.min(minY, p.y());
            maxX = Math.max(maxX, p.x());
            maxY = Math.max(maxY, p.y());
        }
        return new Boundaries(new Point(minX, minY), new Point(maxX, maxY));
    }

    @Override
    public double getArea() {
        Boundaries boundaries = getBoundaries();
        return (double) (boundaries.max().x() - boundaries.min().x()) * (boundaries.max().y() - boundaries.min().y());
    }
}
