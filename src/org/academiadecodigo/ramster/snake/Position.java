package org.academiadecodigo.ramster.snake;

public class Position {

    private int col;
    private int row;
    private boolean isOccupied;
    private boolean hasFood;

    public Position(int col, int row) {
        this.col = col;
        this.row = row;
        isOccupied = false;
        hasFood = false;
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

    public boolean hasFood() {
        return hasFood;
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

    public void setFooded(boolean fooded){
        hasFood = fooded;
    }


}
