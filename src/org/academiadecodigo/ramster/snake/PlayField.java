package org.academiadecodigo.ramster.snake;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PlayField {

    public static int PADDING = 10;

    private int cols;
    private int rows;
    private int cellSize;

    private Rectangle field;


    public PlayField(int cols, int rows, int cellSize) {
        this.cols = cols;
        this.rows = rows;
        this.cellSize = cellSize;
        this.field = new Rectangle(PADDING, PADDING, cols * cellSize, rows * cellSize);
    }

    public void init() {
        field.draw();
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCellSize() {
        return cellSize;
    }

    public static int getPADDING() {
        return PADDING;
    }

    public int getX() {
        return field.getX();
    }

    public int getY() {
        return field.getY();
    }

    public int colsToX(int cols) {
        return cols * cellSize - PADDING;
    }

    public int rowsToY(int rows) {
        return rows * cellSize - PADDING;
    }
}
