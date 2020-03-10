package org.academiadecodigo.ramster.snake;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;

public class KeyboardHandler implements org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler {


    private Game game;
    private Head head;
    private Keyboard keyboard;


    public KeyboardHandler(Game game, Head head) {
        this.game = game;
        this.head = head;
        this.keyboard = new Keyboard(this);

        KeyboardEvent upPressed = new KeyboardEvent();
        upPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        upPressed.setKey(KeyboardEvent.KEY_UP);
        keyboard.addEventListener(upPressed);

        KeyboardEvent downPressed = new KeyboardEvent();
        downPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        downPressed.setKey(KeyboardEvent.KEY_DOWN);
        keyboard.addEventListener(downPressed);

        KeyboardEvent leftPressed = new KeyboardEvent();
        leftPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        leftPressed.setKey(KeyboardEvent.KEY_LEFT);
        keyboard.addEventListener(leftPressed);

        KeyboardEvent rightPressed = new KeyboardEvent();
        rightPressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        rightPressed.setKey(KeyboardEvent.KEY_RIGHT);
        keyboard.addEventListener(rightPressed);

        KeyboardEvent spacePressed = new KeyboardEvent();
        spacePressed.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        spacePressed.setKey(KeyboardEvent.KEY_SPACE);
        keyboard.addEventListener(spacePressed);

    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:

                head.moveUp();

                break;

            case KeyboardEvent.KEY_DOWN:

                head.moveDown();

                break;

            case KeyboardEvent.KEY_LEFT:

                head.moveLeft();

                break;

            case KeyboardEvent.KEY_RIGHT:

                head.moveRight();

                break;
            case KeyboardEvent.KEY_SPACE:

                game.setPaused(!game.getPaused());

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
