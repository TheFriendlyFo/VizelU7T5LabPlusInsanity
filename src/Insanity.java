public class Insanity {
    private int moves;
    private final Peg[] pegs;

    Insanity() {
        pegs = new Peg[10];
        for (int i = 0; i < 4; i++) {
            pegs[i] = new Peg(true, i);
        }
        for (int i = 6; i < 10; i++) {
            pegs[i] = new Peg(false, i);
        }
    }

    public void displayBoard() {
        System.out.println("+---+ ".repeat(pegs.length));
        for (Peg peg: pegs) {
            System.out.print("| " + (peg == null ? " " : peg) + " | ");
        }
        System.out.println("\n" + "+---+ ".repeat(pegs.length));
    }

    public boolean movePeg(int pegIdx) {
        if (pegIdx < 0 || pegs.length <= pegIdx || pegs[pegIdx] == null) return false;

        Peg peg = pegs[pegIdx];
        for (int i = pegIdx + 1; Math.abs(i - pegIdx) < 3; i += peg.direction()) {
            if (isValidMove(i)) {
                pegs[pegIdx] = null;
                pegs[i] = peg;
                return true;
            }
        }
        return false;
    }

    private boolean isValidMove(int idx) {
        return (0 <= idx && idx < pegs.length) && (pegs[idx] == null);
    }

    private boolean evaluateBoard() {
        for (int i = 0; i < 4; i++) {
            if (pegs[i].getColor()) return false;
        }
        for (int i = 6; i < 10; i++) {
            if (!pegs[i].getColor()) return false;
        }
        return true;
    }
}
