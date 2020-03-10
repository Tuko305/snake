package org.academiadecodigo.ramster.snake;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class BodyPart {

    private Position position;
    private PlayField field;
    private Rectangle rectangle;

    public BodyPart (Position position, PlayField field){
        this.position = position;
        this.field = field;
        this.rectangle = new Rectangle (field.colsToX(position.getCol()), field.rowsToY(position.getRow()), field.getCellSize(), field.getCellSize());
        this.rectangle.setColor(Color.GREEN);
        this.rectangle.fill();
    }

    public void setNewPosition(Position position){
        desoccupy();
        int oldCol = this.position.getCol();
        int oldRow = this.position.getRow();
        this.position = position;
        occupy();
        int newCol = this.position.getCol();
        int newRow = this.position.getRow();
        rectangle.translate((newCol - oldCol) * field.getCellSize(), (newRow - oldRow) * field.getCellSize());
    }

    public void desoccupy(){
        this.position.setOccupied(false);
    }

    public void occupy(){
        this.position.setOccupied(true);
    }
}
