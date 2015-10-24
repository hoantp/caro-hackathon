package gomoku;
/**
 * SmartAgent class that uses minimax algorithm and heuristic evaluation to pick next move
 */
public class SmartAgent extends Agent {

	Minimax minimax;
    String oppMove;

	public SmartAgent(int n, int m, boolean isFirst) {
		super(n, m, isFirst);
		minimax = new Minimax();
	}

	String firstTurn() {
		// pick default first move
		String move = "7 7";
		board.placeMove(me, move, true);
		System.out.println(board);
		return move;
	}

	String takeTurn() {
		String move = pickMove();
		board.placeMove(me, move, true);
		System.out.println(board);
		return move;
	}

	String pickMove() {
        String threatMove = board.checkThreat(oppMove, them);
        System.out.println("Prev move " + oppMove);
        System.out.println("threatMove :" + threatMove);
        if (threatMove != null) {
            return threatMove;
        }
		// use minimax
		Object[] move = minimax.mmab(board, 2, Double.NEGATIVE_INFINITY,
				Double.POSITIVE_INFINITY);
		return (String) move[1];
	}

    /**
     * Get opponent's turn and update board
     * @param  move opponent's move
     * @return opponent's move
     */
    String receiveTurn(String move) {
        board.placeMove(them, move, false);
        oppMove = move;
        return move;
    }
}