package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

import javax.print.attribute.standard.PDLOverrideSupported;

public class Bishop extends ChessPiece {

    private ChessMatch chessMatch;

    public Bishop(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }
    @Override
    public boolean[][] possibleMoves() {
        boolean[][] mat = new boolean[this.getBoard().getRows()][this.getBoard().getColumns()];
        Position positionToEvaluate = new Position(0,0);
        System.out.println(position);
        positionToEvaluate.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        while ((this.getBoard().positionExists(positionToEvaluate) && (!this.getBoard().thereIsAPiece(positionToEvaluate) || (this.chessMatch.isThereOpponentPiece(positionToEvaluate))) )) {
            System.out.println(positionToEvaluate);
            if (this.getBoard().positionExists(positionToEvaluate)) {

                 if (( this.getBoard().thereIsAPiece(positionToEvaluate) ) && ( !this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                    break;
                }

                 if (( this.getBoard().thereIsAPiece(positionToEvaluate) ) && ( this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                     mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
                     break;
                }

                if (( !this.getBoard().thereIsAPiece(positionToEvaluate) ) || ( this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                    mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
                }
            }
            positionToEvaluate.setValues(positionToEvaluate.getRow() - 1, positionToEvaluate.getColumn() + 1);
        }

        positionToEvaluate.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        while ((this.getBoard().positionExists(positionToEvaluate) && (!this.getBoard().thereIsAPiece(positionToEvaluate) || (this.chessMatch.isThereOpponentPiece(positionToEvaluate))) )) {
            System.out.println(positionToEvaluate);
            if (this.getBoard().positionExists(positionToEvaluate)) {

                 if (( this.getBoard().thereIsAPiece(positionToEvaluate) ) && ( !this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                    break;
                }

                 if (( this.getBoard().thereIsAPiece(positionToEvaluate) ) && ( this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                     mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
                     break;
                }

                if (( !this.getBoard().thereIsAPiece(positionToEvaluate) ) || ( this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                    mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
                }
            }
            positionToEvaluate.setValues(positionToEvaluate.getRow() - 1, positionToEvaluate.getColumn() - 1);
        }

        positionToEvaluate.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        while ((this.getBoard().positionExists(positionToEvaluate) && (!this.getBoard().thereIsAPiece(positionToEvaluate) || (this.chessMatch.isThereOpponentPiece(positionToEvaluate))) )) {
            System.out.println(positionToEvaluate);
            if (this.getBoard().positionExists(positionToEvaluate)) {

                 if (( this.getBoard().thereIsAPiece(positionToEvaluate) ) && ( !this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                    break;
                }

                 if (( this.getBoard().thereIsAPiece(positionToEvaluate) ) && ( this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                     mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
                     break;
                }

                if (( !this.getBoard().thereIsAPiece(positionToEvaluate) ) || ( this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                    mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
                }
            }
            positionToEvaluate.setValues(positionToEvaluate.getRow() + 1, positionToEvaluate.getColumn() + 1);
        }

        positionToEvaluate.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        while ((this.getBoard().positionExists(positionToEvaluate) && (!this.getBoard().thereIsAPiece(positionToEvaluate) || (this.chessMatch.isThereOpponentPiece(positionToEvaluate))) )) {
            System.out.println(positionToEvaluate);
            if (this.getBoard().positionExists(positionToEvaluate)) {

                 if (( this.getBoard().thereIsAPiece(positionToEvaluate) ) && ( !this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                    break;
                }

                 if (( this.getBoard().thereIsAPiece(positionToEvaluate) ) && ( this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                     mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
                     break;
                }

                if (( !this.getBoard().thereIsAPiece(positionToEvaluate) ) || ( this.chessMatch.isThereOpponentPiece(positionToEvaluate)) ) {
                    mat[positionToEvaluate.getRow()][positionToEvaluate.getColumn()] = true;
                }
            }
            positionToEvaluate.setValues(positionToEvaluate.getRow() + 1, positionToEvaluate.getColumn() - 1);
        }

        return mat;
    }

    @Override
    public String toString() {
        return "B";
    }
}
