package chess;

import boardgame.Position;
import chess.ChessException;

public class ChessPosition {
    private int row;
    private char column;

    public ChessPosition(int row, char column) {
        if (column < 'a' || column > 'h' || row < 1 || row > 8) {
            throw new ChessException("Error instantiating ChessPosition. Valid values are from a1 to h8");
        }
        this.row = row;
        this.column = column;

    }

    public Position toPosition() {
        return new Position(8 - this.row, this.column - 'a');
    }

    static public ChessPosition fromChessPosition(Position position) {
        return new ChessPosition(8 - position.getRow(), (char)('a' - position.getColumn()));
    }
}
