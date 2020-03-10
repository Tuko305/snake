package org.academiadecodigo.ramster.snake;

public class Head {

    private Position position;
    private PlayField field;

    public Head(PlayField field, Position position){
        this.field = field;
        this.position = position;
    }

    public void move(){

    }

    public void occupy(Position position){
        position.setOccupied(true);
    }

    public void eat(){}

    public void die(){}

}
