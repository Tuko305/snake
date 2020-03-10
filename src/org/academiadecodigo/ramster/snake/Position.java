package org.academiadecodigo.ramster.snake;

public class Position {

    private int col;
    private int row;
    private boolean isOccupied;

    public Position(int col, int row){
        this.col = col;
        this.row = row;
        isOccupied = false;
    }

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
