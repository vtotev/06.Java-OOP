package WorkingWithAbstraction.PointInRectangle;

public class Rectangle {
    Point bottomLeft;
    Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public void setBottomLeft(Point bottomLeft) {
        this.bottomLeft = bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public void setTopRight(Point topRight) {
        this.topRight = topRight;
    }

    public boolean contains(int x, int y) {
        return x >= bottomLeft.getX()
                && x <= topRight.getX()
                && y >= bottomLeft.getY()
                && y <= topRight.getY();
    }
}
