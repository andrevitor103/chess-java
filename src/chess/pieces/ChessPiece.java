package chess.pieces;

import boardgame.Piecie;

public abstract class ChessPiece extends Piecie {
    private Color color;
    private int moveCount;
    @Override
    abstract public boolean[][] possibleMoves();

    public Color getColor() {
        return this.color;
    }
}
