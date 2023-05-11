package boardgame;

public class Board {
    private int rows;
    private int columns;
    private Piecie[][] piecies;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.piecies = new Piecie[rows][columns];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public Piecie getPiecie(int row, int column) {
        if (!this.positionExists(row, column)) {
            throw new BoardException("Position not exists");
        }
        return this.piecies[row][column];
    }
    public void placePiece(Piecie piecie, Position position) {
        if (!this.positionExists(position)) {
            throw new BoardException("Position not exists");
        }
        this.piecies[position.getRow()][position.getColumn()] = piecie;
        piecie.position = position;
    }

    public Piecie getPiecie(Position position) {
        if (!this.positionExists(position.getRow(), position.getColumn())) {
            throw new BoardException("Position not exists: " + position);
        }
        return this.piecies[position.getRow()][position.getColumn()];
    }

    public boolean positionExists(int row, int column) {
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }

    public boolean positionExists(Position position) {
        int row = position.getRow();
        int column = position.getColumn();
        return row >= 0 && row < this.rows && column >= 0 && column < this.columns;
    }

    public void movePiece(Position position, Piecie piecie) {
        if (!this.positionExists(position)) {
            throw new BoardException("Position not exists");
        }
        this.piecies[position.getRow()][position.getColumn()] = piecie;
        piecie.position = position;
    }

    public Piecie removePiece(Position position) {
        if (!this.thereIsAPiece(position)) {
            return null;
        }
        Piecie piecie = this.getPiecie(position);
        piecie.position = null;
        this.piecies[position.getRow()][position.getColumn()] = null;
        return piecie;
    }

    public boolean thereIsAPiece(Position position) {
        return this.getPiecie(position) != null;
    }

    @Override
    public String toString() {
        return " " + rows + "," + columns;
    }
}
