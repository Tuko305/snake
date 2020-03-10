package org.academiadecodigo.ramster.snake;

import org.academiadecodigo.simplegraphics.graphics.Color;

import java.util.LinkedList;
import java.util.Queue;

public class Game {

    private int gameCols;
    private int gameRows;

    private Queue<BodyPart> queue = new LinkedList<>();
    private Position[][] allPositions;
    private PlayField playField;
    private Head head;
    private Collision collision;
    private Food food;
    private KeyboardHandler keyboardHandler;
    private boolean paused;


    public Game(int cols, int rows, int cellSize) {
        this.gameCols = cols;
        this.gameRows = rows;
        this.paused = false;
        this.playField = new PlayField(cols, rows, cellSize);
        this.collision = new Collision();
        this.head = new Head(this.playField);
        this.keyboardHandler = new KeyboardHandler(this, this.head);
        this.allPositions = new Position[cols][rows];

    }

    public void setPaused(boolean paused) {
        this.paused = paused;
        if (paused){
            System.out.println("You have paused the game");
            return;
        }
        System.out.println("You have unpaused the game");
    }

    public boolean getPaused(){
        return this.paused;
    }

    public void init() {
        playField.init();
        for (int i = 0; i < allPositions.length; i++) {
            for (int j = 0; j < allPositions[i].length; j++) {
                allPositions[i][j] = new Position(i, j);
            }
        }
        System.out.println(allPositions[(gameCols - 1)][(0)].getRow());
        head.setPosition(new Position((gameCols / 2) - 1, ((gameRows / 2) - 1)));
        head.getHeadRectangle().setColor(Color.RED);
        head.getHeadRectangle().fill();

        createFood();

    }

    public void createFood() {
        int randomCol = (int) (Math.random() * gameCols);
        int randomRow = (int) (Math.random() * gameRows);

        if (this.food == null) {
            if (!allPositions[randomCol][randomRow].isOccupied() && !allPositions[randomCol][randomRow].hasFood()) {
                this.food = new Food(this.playField, allPositions[randomCol][randomRow]);
                return;
            }
            createFood();
        }
        if (!allPositions[randomCol][randomRow].isOccupied() && !allPositions[randomCol][randomRow].hasFood()) {
            this.food.newFood(allPositions[randomCol][randomRow]);
            return;
        }
        createFood();
    }

    public void start() throws InterruptedException {


        while (true) {

            while (paused){
                Thread.sleep(50);

            }
            Thread.sleep(50);
            int oldCols = head.getPosition().getCol();
            int oldRows = head.getPosition().getRow();
            boolean deadlyMove;
            deadlyMove = head.move();

            if (deadlyMove){
                System.out.println("You have gone out of bounds");
                return;
            }

            if (!queue.isEmpty()) {
                BodyPart tail = queue.poll();
                tail.setNewPosition(allPositions[oldCols][oldRows]);
                queue.offer(tail);
            }
            int headCols = head.getPosition().getCol();
            int headRows = head.getPosition().getRow();

            if (collision.checkCollision(allPositions[headCols][headRows])) {
                System.out.println("Snake body collision detected, you have lost the game");
                return;
            }
            if (collision.checkFoodCollision(allPositions[headCols][headRows])) {
                System.out.println("omnomnom");
                queue.offer(new BodyPart(allPositions[headCols][headRows], playField));
                food.getEaten();
                createFood();
            }

        }
    }

}
