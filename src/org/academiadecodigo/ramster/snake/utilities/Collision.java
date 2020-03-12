package org.academiadecodigo.ramster.snake.utilities;

import org.academiadecodigo.ramster.snake.positionLogic.Position;

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
