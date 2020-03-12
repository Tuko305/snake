package org.academiadecodigo.ramster.snake.gameObjects;

import org.academiadecodigo.ramster.snake.positionLogic.PlayField;
import org.academiadecodigo.ramster.snake.positionLogic.Position;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Head {

    private Position position;
    private PlayField field;
    private Rectangle headRectangle;
    private int xSpeed = 0;
    private int ySpeed = 0;
    private boolean canChangeDirection;


    public Head(PlayField field) {
        this.field = field;
        this.canChangeDirection = true;
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

    public boolean move() {

        if(this.position.getCol() + xSpeed < 0 || this.position.getCol() + xSpeed >= field.getCols()){
            xSpeed = 0;
            ySpeed = 0;
            return true;
        }
        if(this.position.getRow() + ySpeed < 0 || this.position.getRow() + ySpeed >= field.getRows()){
            xSpeed = 0;
            ySpeed = 0;
            return true;
        }
        this.position.updateCol(xSpeed);
        this.position.updateRow(ySpeed);
        this.headRectangle.translate((xSpeed * field.getCellSize()), (ySpeed * field.getCellSize()));
        canChangeDirection = true;
        return false;

    }

    public void moveUp() {
        if(!canChangeDirection){
            return;
        }

        if (ySpeed == 1){
            return;
        }
        setYSpeed(-1);
        setXSpeed(0);
        canChangeDirection = false;
    }

    public void moveDown() {
        if(!canChangeDirection){
            return;
        }

        if (ySpeed == -1){
            return;
        }
        setYSpeed(1);
        setXSpeed(0);
        canChangeDirection = false;
    }

    public void moveLeft() {
        if(!canChangeDirection){
            return;
        }

        if (xSpeed == 1){
            return;
        }
        setXSpeed(-1);
        setYSpeed(0);
        canChangeDirection = false;
    }

    public void moveRight() {
        if(!canChangeDirection){
            return;
        }

        if (xSpeed == -1){
            return;
        }
        setXSpeed(1);
        setYSpeed(0);
        canChangeDirection = false;

    }


}
