import java.util.Scanner;

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

    public void play() {
        boolean won = false;
        Scanner scanner = new Scanner(System.in);

        displayBoard();
        while (!won) {
            boolean validMove = false;
            while (!validMove) {
                System.out.println("Select a peg to move:");
                System.out.print("> ");
                validMove = movePeg(scanner.nextInt() - 1);
            }
            displayBoard();
            won = evaluateBoard();
        }
    }

    public void displayBoard() {
        System.out.println("+---+ ".repeat(pegs.length));
        for (Peg peg: pegs) {
            System.out.print("| " + (peg == null ? " " : peg) + " | ");
        }

        System.out.println("\n" + "+---+ ".repeat(pegs.length));

        for (int i = 1; i <= 10; i++) {
            System.out.print(" |" + i + "|  ");
        }

        System.out.println();
    }

    public boolean movePeg(int pegIdx) {
        if (pegIdx < 0 || pegs.length <= pegIdx || pegs[pegIdx] == null) return false;

        Peg peg = pegs[pegIdx];
        for (int i = pegIdx; Math.abs(i - pegIdx) < 3; i += peg.direction()) {
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
            if (pegs[i] == null || pegs[i].getColor()) return false;
        }
        for (int i = 6; i < 10; i++) {
            if (pegs[i] == null || !pegs[i].getColor()) return false;
        }
        return true;
    }
}
