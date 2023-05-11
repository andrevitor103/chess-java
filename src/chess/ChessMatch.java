package chess;

import boardgame.Board;
import boardgame.Piecie;
import boardgame.Position;
import chess.pieces.*;

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

        System.out.println(this.currentPlayer);
        this.nextTurn();
        if (capturedPiece == null) {
            return null;
        }
        this.piecesOnTheBoard.remove(capturedPiece);
        this.capturedPieces.add(capturedPiece);
        return (ChessPiece) capturedPiece;
    }

    private void nextTurn() {
        this.currentPlayer = (this.currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
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
        this.addPieceInBoard('c', 1, new Bishop(board, Color.WHITE, this));
        this.addPieceInBoard('f', 1, new Bishop(board, Color.WHITE, this));
        this.addPieceInBoard('a', 1, new Rook(board, Color.WHITE, this));
        this.addPieceInBoard('h', 1, new Rook(board, Color.WHITE, this));
        this.addPieceInBoard('b', 1, new Kninght(board, Color.WHITE, this));
        this.addPieceInBoard('g', 1, new Kninght(board, Color.WHITE, this));
        this.addPieceInBoard('d', 1, new Queen(board, Color.WHITE, this));
        this.addPieceInBoard('e', 1, new King(board, Color.WHITE, this));


        this.addPieceInBoard('a', 7, new Pawn(board, Color.BLACK, this));
        this.addPieceInBoard('b', 7, new Pawn(board, Color.BLACK, this));
        this.addPieceInBoard('c', 7, new Pawn(board, Color.BLACK, this));
        this.addPieceInBoard('d', 7, new Pawn(board, Color.BLACK, this));
        this.addPieceInBoard('e', 7, new Pawn(board, Color.BLACK, this));
        this.addPieceInBoard('f', 7, new Pawn(board, Color.BLACK, this));
        this.addPieceInBoard('g', 7, new Pawn(board, Color.BLACK, this));
        this.addPieceInBoard('h', 7, new Pawn(board, Color.BLACK, this));
        this.addPieceInBoard('c', 8, new Bishop(board, Color.BLACK, this));
        this.addPieceInBoard('f', 8, new Bishop(board, Color.BLACK, this));
        this.addPieceInBoard('a', 8, new Rook(board, Color.BLACK, this));
        this.addPieceInBoard('h', 8, new Rook(board, Color.BLACK, this));
        this.addPieceInBoard('b', 8, new Kninght(board, Color.BLACK, this));
        this.addPieceInBoard('g', 8, new Kninght(board, Color.BLACK, this));
        this.addPieceInBoard('d', 8, new Queen(board, Color.BLACK, this));
        this.addPieceInBoard('e', 8, new King(board, Color.BLACK, this));
    }
}
