package org.academiadecodigo.ramster.snake;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Head {

    private Position position;
    private PlayField field;
    private Rectangle headRectangle;

    public Head(PlayField field){
        this.field = field;
    }

    public void setPosition(Position position){
        this.position = position;
        this.headRectangle = new Rectangle(field.colsToX(position.getCol()), field.rowsToY(position.getRow()), field.getCellSize(), field.getCellSize());
    }

    public Rectangle getHeadRectangle() {
        return headRectangle;
    }

    public void move(){

    }

    public void occupy(Position position){
        position.setOccupied(true);
    }

    public void eat(){}

    public void die(){}

}
