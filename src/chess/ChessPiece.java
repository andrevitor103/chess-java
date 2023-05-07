package chess;

import boardgame.Board;
import boardgame.Piecie;

public abstract class ChessPiece extends Piecie {
    private Color color;
    private int moveCount;

    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
    }

    public void incrementMoveCount() {
        this.moveCount++;
    }

    public void decrementMoveCount() {
        this.moveCount--;
    }

    public int getMoveCount() {
        return this.moveCount;
    }

    public Color getColor() {
        return this.color;
    }
}
