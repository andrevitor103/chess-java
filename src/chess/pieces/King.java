package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
        Position positionToEvaluate = new Position(0,0);
        positionToEvaluate.setValues(this.position.getRow() + 1, this.position.getColumn());
        if (acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
        }

        positionToEvaluate.setValues(this.position.getRow() - 1, this.position.getColumn());
        if (acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
        }

        positionToEvaluate.setValues(this.position.getRow(), this.position.getColumn() + 1);
        if (acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
        }

        positionToEvaluate.setValues(this.position.getRow(), this.position.getColumn() - 1);
        if (acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
        }

        positionToEvaluate.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        if (acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
        }

        positionToEvaluate.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        if (acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
        }

        positionToEvaluate.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        if (acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
        }

        positionToEvaluate.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        if (acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
        }

        return mat;
    }

    private boolean acceptablePosition(Position positionToEvaluate) {
        return (this.getBoard().positionExists(positionToEvaluate)) && (!this.getBoard().thereIsAPiece(positionToEvaluate) || this.chessMatch.isThereOpponentPiece(positionToEvaluate));
    }

    @Override
    public String toString() {
        return "KG";
    }
}
