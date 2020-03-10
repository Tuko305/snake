package org.academiadecodigo.ramster.snake;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Head {

    private Position position;
    private PlayField field;
    private Rectangle headRectangle;
    private int xSpeed = 0;
    private int ySpeed = 0;


    public Head(PlayField field) {
        this.field = field;
    }

    public void setPosition(Position position) {
        this.position = position;
        this.headRectangle = new Rectangle(field.colsToX(position.getCol()), field.rowsToY(position.getRow()), field.getCellSize(), field.getCellSize());
    }

    public void setXSpeed(int speed) {
        this.xSpeed = speed;
    }

    public void setYSpeed(int speed) {
        this.ySpeed = speed;
    }

    public Rectangle getHeadRectangle() {
        return headRectangle;
    }

    public Position getPosition() {
        return position;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void move() {

        this.position.updateCol(xSpeed);
        this.position.updateRow(ySpeed);
        this.headRectangle.translate((xSpeed * field.getCellSize()), (ySpeed * field.getCellSize()));

    }

    public void moveUp() {
        if (ySpeed == 1){
            return;
        }
        setYSpeed(-1);
        setXSpeed(0);
    }

    public void moveDown() {
        if (ySpeed == -1){
            return;
        }
        setYSpeed(1);
        setXSpeed(0);
    }

    public void moveLeft() {
        if (xSpeed == 1){
            return;
        }
        setXSpeed(-1);
        setYSpeed(0);
    }

    public void moveRight() {
        if (xSpeed == -1){
            return;
        }
        setXSpeed(1);
        setYSpeed(0);
    }


}
