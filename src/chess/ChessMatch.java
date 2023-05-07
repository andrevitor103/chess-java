package chess;

import boardgame.Board;
import boardgame.Piecie;
import boardgame.Position;
import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class ChessMatch {
    private Color currentPlayer;
    private boolean check;
    private boolean checkMate;
    private Board board;
    private ChessPiece[][] chessPieces;

    private List<Piecie> piecesOnTheBoard = new ArrayList<>();

    private List<Piecie> capturedPieces = new ArrayList<>();
    public ChessMatch() {
        this.board = new Board(8,8);
        currentPlayer = Color.WHITE;
        this.initialize();
    }

    public ChessPiece[][] getPieces() {
        ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++) {
            for (int j=0; j<board.getColumns(); j++) {
                mat[i][j] = (ChessPiece) board.getPiecie(i, j);
            }
        }
        return mat;
    }
    public ChessPiece[][] getChessPieces() {
        return this.chessPieces;
    }
    public Color getCurrentPlayer() {
        return this.currentPlayer;
    }
    public boolean getCheck() {
        return false;
    }

    public boolean getCheckMate() {
        return false;
    }
    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        return board.getPiecie(position).possibleMoves();
    }
    public boolean isThereOpponentPiece(Position position) {
        ChessPiece piece = (ChessPiece)this.board.getPiecie(position);
        return piece != null && piece.getColor() != this.currentPlayer;
    }

    public void addPieceInBoard(char column, int row, ChessPiece piece) {
        this.board.placePiece(piece, new ChessPosition(row, column).toPosition());
    }
    public ChessPiece executeChessMove(ChessPosition source, ChessPosition target) {
        // pegar peça, avaliar se pode mover para o destino informado
        ChessPiece piece = (ChessPiece)this.board.getPiecie(source.toPosition());
        if (!piece.possibleMove(target.toPosition())) {
            return null;
        }
        piece = (ChessPiece) this.board.removePiece(source.toPosition());
        piece.incrementMoveCount();
        Piecie capturedPiece = this.board.removePiece(target.toPosition());
        this.board.movePiece(target.toPosition(), piece);

        if (capturedPiece == null) {
            return null;
        }
        this.piecesOnTheBoard.remove(capturedPiece);
        this.capturedPieces.add(capturedPiece);
        return (ChessPiece) capturedPieces;
    }
    private void initialize() {
        this.addPieceInBoard('a', 2, new Pawn(board, Color.WHITE, this));
        this.addPieceInBoard('b', 2, new Pawn(board, Color.WHITE, this));
        this.addPieceInBoard('c', 2, new Pawn(board, Color.WHITE, this));
        this.addPieceInBoard('d', 2, new Pawn(board, Color.WHITE, this));
        this.addPieceInBoard('e', 2, new Pawn(board, Color.WHITE, this));
        this.addPieceInBoard('f', 2, new Pawn(board, Color.WHITE, this));
        this.addPieceInBoard('g', 2, new Pawn(board, Color.WHITE, this));
        this.addPieceInBoard('h', 2, new Pawn(board, Color.WHITE, this));
    }
}
