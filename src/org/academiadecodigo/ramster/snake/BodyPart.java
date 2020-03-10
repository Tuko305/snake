package org.academiadecodigo.ramster.snake;

public class BodyPart {

    private Position position;

    public void desoccupy(Position position){
        position.setOccupied(false);
    }
}
