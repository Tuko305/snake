package org.academiadecodigo.ramster.snake;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    private int gameCols;
    private int gameRows;

    private Queue queue = new LinkedList<BodyPart>();
    private Position[][] allPositions;
    private PlayField playField;
    private Head head;
    private Collision collision;


    public Game(int cols, int rows, int cellSize){
        this.gameCols = cols;
        this.gameRows = rows;
        this.playField = new PlayField(cols, rows, cellSize);
        this.head = new Head(this.playField);
        this.collision = new Collision();
        this.allPositions = new Position[cols][rows];
    }

    public void init(){

        for (int i = 0; i < allPositions.length; i++){
            for (int j = 0; j < allPositions[i].length; j++){
                allPositions[i][j] = new Position(i, j);
            }
        }

        head.setPosition(allPositions[(gameCols/2) -1][(gameRows/2)-1]);
        allPositions[(gameCols/2) -1][(gameRows/2)-1].setOccupied(true);

        
    }

}
