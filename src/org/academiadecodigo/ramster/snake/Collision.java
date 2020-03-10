package org.academiadecodigo.ramster.snake;

public class Collision {

    public Collision(){

    }

    public boolean checkCollision(Position position){
        return position.isOccupied();
    }

    public boolean checkFoodCollision(Position position){
        return position.hasFood();
    }
}
