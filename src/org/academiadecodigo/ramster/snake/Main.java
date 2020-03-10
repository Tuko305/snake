package org.academiadecodigo.ramster.snake;

public class Main {
    public static void main(String[] args)  {

        Game game = new Game(50, 50, 10);
        game.init();

        try {
            game.start();
        } catch (InterruptedException ex){
            System.out.println("Alert!");
        }
    }
}
