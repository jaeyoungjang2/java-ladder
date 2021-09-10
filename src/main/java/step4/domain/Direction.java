package step4.domain;

public class Direction {
    private boolean before;
    private boolean current;

    public Direction(boolean before, boolean current) {
        this.before = before;
        this.current = current;
    }

    public static Direction of(boolean before, boolean current) {
        return new Direction(before, current);
    }
}
