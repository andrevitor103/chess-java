package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    private ChessMatch chessMatch;
    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
        Position p = new Position(0,0);
        System.out.println(position);
        if (this.getColor() == Color.WHITE) {
            if (this.getMoveCount() == 0) {
                mat[this.position.getRow()-2][this.position.getColumn()] = true;
            }
            mat[this.position.getRow()-1][this.position.getColumn()] = true;
            return mat;
        }
        if (this.getMoveCount() == 0) {
            mat[this.position.getRow()+2][this.position.getColumn()] = true;
        }
        mat[this.position.getRow()+1][this.position.getColumn()] = true;
        return mat;
    }

    @Override
    public String toString() {
        return "P";
    }
}
