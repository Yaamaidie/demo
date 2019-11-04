package javaConcurrencePractice.bean;

public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        this(0, 0);
    }

    public MutablePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MutablePoint(MutablePoint p) {
        x = p.x;
        y = p.y;
    }
}
