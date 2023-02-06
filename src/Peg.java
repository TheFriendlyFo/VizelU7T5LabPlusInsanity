public class Peg {
    // true represents blue, false represents red
    private final boolean color;
    private final int id;

    Peg(boolean color, int id) {
        this.color = color;
        this.id = id;
    }

    public String toString() {
        return "\033[0;"  + (color ? 31 : 34) + "mo\033[0m";
    }

    public int direction() {
        return color ? 1 : -1;
    }

    public boolean getColor() {
        return color;
    }
}
