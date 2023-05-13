package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Rook extends ChessPiece {
    private ChessMatch chessMatch;

    public Rook(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
        Position positionToEvaluate = new Position(0,0);
        System.out.println(position);

        positionToEvaluate.setValues(this.position.getRow() + 1, this.position.getColumn());
        while(acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
            if (this.chessMatch.isThereOpponentPiece(positionToEvaluate)) {
                break;
            }
            positionToEvaluate.setValues(positionToEvaluate.getRow() + 1, positionToEvaluate.getColumn());
        }

        positionToEvaluate.setValues(this.position.getRow() - 1, this.position.getColumn());
        while(acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
            if (this.chessMatch.isThereOpponentPiece(positionToEvaluate)) {
                break;
            }
            positionToEvaluate.setValues(positionToEvaluate.getRow() - 1, positionToEvaluate.getColumn());
        }

        positionToEvaluate.setValues(this.position.getRow(), this.position.getColumn() + 1);
        while(acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
            if (this.chessMatch.isThereOpponentPiece(positionToEvaluate)) {
                break;
            }
            positionToEvaluate.setValues(positionToEvaluate.getRow(), positionToEvaluate.getColumn() + 1);
        }

        positionToEvaluate.setValues(this.position.getRow(), this.position.getColumn() - 1);
        while(acceptablePosition(positionToEvaluate)) {
            mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
            if (this.chessMatch.isThereOpponentPiece(positionToEvaluate)) {
                break;
            }
            positionToEvaluate.setValues(positionToEvaluate.getRow(), positionToEvaluate.getColumn() - 1);
        }

        return mat;
    }

    private boolean acceptablePosition(Position positionToEvaluate) {
        return (
                this.getBoard().positionExists(positionToEvaluate) &&
                (!this.getBoard().thereIsAPiece(positionToEvaluate) || this.chessMatch.isThereOpponentPiece(positionToEvaluate))
        );
    }

    @Override
    public String toString() {
        return "R";
    }
}
