package org.academiadecodigo.ramster.snake.gameObjects;

import org.academiadecodigo.ramster.snake.positionLogic.PlayField;
import org.academiadecodigo.ramster.snake.positionLogic.Position;
import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Food {

    private PlayField field;
    private Position position;
    private Ellipse foodCircle;

    public Food(PlayField field, Position pos){
        this.field = field;
        this.position = pos;
        this.position.setFooded(true);
        this.foodCircle = new Ellipse(field.colsToX(position.getCol()), field.rowsToY(position.getRow()), field.getCellSize(), field.getCellSize());
        this.foodCircle.setColor(Color.RED);
        this.foodCircle.fill();

    }

    public void getEaten(){
        this.position.setFooded(false);
        this.foodCircle.delete();
    }

    public void newFood(Position position){
        int oldX = field.colsToX(this.position.getCol());
        int oldY = field.rowsToY(this.position.getRow());

        this.position = position;
        this.position.setFooded(true);

        int newX = field.colsToX(position.getCol());
        int newY = field.rowsToY(position.getRow());

        this.foodCircle.translate(newX - oldX, newY - oldY);
        this.foodCircle.fill();
    }


}
