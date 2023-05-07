package chess.pieces;

import boardgame.Board;
import boardgame.Position;

public class ChessMatch {
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private Board board;
    private ChessPiece[][] chessPieces;


    public ChessPiece[][] getChessPieces() {
        return this.chessPieces;
    }

    public boolean isThereOpponentPiece(Position position) {
        ChessPiece piece = (ChessPiece)this.board.getPiecie(position);
        return piece != null && piece.getColor() != this.currentPlayer;
    }
}
