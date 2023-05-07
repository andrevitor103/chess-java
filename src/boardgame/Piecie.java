package boardgame;
public abstract class Piecie {
    protected Position position;
    private Board board;
    abstract public boolean[][] possibleMoves();

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
