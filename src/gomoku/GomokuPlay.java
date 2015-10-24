package gomoku;
import java.util.Scanner;

/**
 * GomokuPlay class contains main method that plays the game.
 */
public class GomokuPlay {
	/**
	 * Main method. Parse command line arguments to get game settings
	 * @param  args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 20;
		int m = 5;
        int turn = 0;

        System.out
                .println("Would you like to go first or second? Please enter 1 or 2");
        while (true) {
            try {
                turn = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out .println("Please input 1 or 2:");
            }
        }

        if (turn == 1) {
            Human x = new Human(n, m, true);
            SmartAgent o = new SmartAgent(n, m, false);
            String xMove, oMove = "";
            xMove = x.takeTurn();
            System.out.println(xMove);
            boolean play = true;
            while (play) {
                o.receiveTurn(xMove);
                oMove = o.takeTurn();
                if (o.board.winner == 'x') {
                    System.out.println("Winner: x");
                    play = false;
                    break;
                }
                if (o.board.winner == 'o') {
                    System.out.println("Winner: o");
                    play = false;
                    break;
                }
                if (o.board.winner == 'd') {
                    System.out.println("Winner: d");
                    play = false;
                    break;
                }
                x.receiveTurn(oMove);
                xMove = x.takeTurn();
                if (x.board.winner == 'x') {
                    System.out.println("Winner: x");
                    play = false;
                    break;
                }
                if (x.board.winner == 'o') {
                    System.out.println("Winner: o");
                    play = false;
                    break;
                }
                if (x.board.winner == 'd') {
                    System.out.println("Winner: d");
                    play = false;
                    break;
                }
            }

        } else {
            SmartAgent x = new SmartAgent(n, m, false);
            Human o = new Human(n, m, true);
            String xMove, oMove = "";
            xMove = x.firstTurn();
            System.out.println(xMove);
            boolean play = true;
            while (play) {
                o.receiveTurn(xMove);
                oMove = o.takeTurn();
                if (o.board.winner == 'x') {
                    System.out.println("Winner: x");
                    play = false;
                    break;
                }
                if (o.board.winner == 'o') {
                    System.out.println("Winner: o");
                    play = false;
                    break;
                }
                if (o.board.winner == 'd') {
                    System.out.println("Winner: d");
                    play = false;
                    break;
                }
                x.receiveTurn(oMove);
                xMove = x.takeTurn();
                if (x.board.winner == 'x') {
                    System.out.println("Winner: x");
                    play = false;
                    break;
                }
                if (x.board.winner == 'o') {
                    System.out.println("Winner: o");
                    play = false;
                    break;
                }
                if (x.board.winner == 'd') {
                    System.out.println("Winner: d");
                    play = false;
                    break;
                }
            }
        }
    }

}