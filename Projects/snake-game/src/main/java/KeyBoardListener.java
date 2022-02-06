
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyBoardListener implements KeyboardHandler {

    private Keyboard keyboard;
    private Snake snake;
    private boolean keyboardLocked;

    public void init(Snake snake) {

        this.keyboardLocked = false;
        this.snake = snake;
        keyboard = new Keyboard(this);

        KeyboardEvent pressRight = new KeyboardEvent();
        pressRight.setKey(KeyboardEvent.KEY_RIGHT);
        pressRight.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressRight);

        KeyboardEvent pressLeft = new KeyboardEvent();
        pressLeft.setKey(KeyboardEvent.KEY_LEFT);
        pressLeft.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressLeft);

        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKey(KeyboardEvent.KEY_UP);
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressUp);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressDown);

    }

    public void unlockKeyBoard() {

        this.keyboardLocked = false;
    }


    private void lockKeyBoard() {

        this.keyboardLocked = true;
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if(!this.keyboardLocked) {

            switch (keyboardEvent.getKey()) {

                case KeyboardEvent.KEY_RIGHT:
                    if (!(snake.getMovingDirection() == MovingDirection.LEFT)) {
                        snake.changeMovingDirection(MovingDirection.RIGHT);
                        lockKeyBoard();

                    }
                    break;

                case KeyboardEvent.KEY_LEFT:
                    if (!(snake.getMovingDirection() == MovingDirection.RIGHT)) {
                        snake.changeMovingDirection(MovingDirection.LEFT);
                        lockKeyBoard();

                    }
                    break;
                case KeyboardEvent.KEY_UP:
                    if (!(snake.getMovingDirection() == MovingDirection.DOWN)) {
                        snake.changeMovingDirection(MovingDirection.UP);
                        lockKeyBoard();

                    }
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if (!(snake.getMovingDirection() == MovingDirection.UP)) {
                        snake.changeMovingDirection(MovingDirection.DOWN);
                        lockKeyBoard();

                    }
                    break;
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
