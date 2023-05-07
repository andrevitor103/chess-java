package boardgame;
public abstract class Piecie {
    protected Position position;
    private Board board;

    public Piecie(Board board) {
        this.board = board;
    }

    abstract public boolean[][] possibleMoves();

    public Board getBoard() {
        return this.board;
    }

    public boolean possibleMove(Position position) {
        return this.possibleMoves()[position.getRow()][position.getColumn()];
    }
    public boolean isThereAnyPossibleMove() {
        boolean[][] moves = this.possibleMoves();
        for (boolean[] row : moves) {
            for (boolean column: row) {
                if (column) {
                    return true;
                }
            }
        }
        return false;
    }
}
