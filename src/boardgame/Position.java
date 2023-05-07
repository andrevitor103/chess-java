package boardgame;

public class Position {
    private int row;
    private int column;

    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }
}
