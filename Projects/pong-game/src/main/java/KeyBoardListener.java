import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class KeyBoardListener implements KeyboardHandler {

    private Keyboard keyboard;
    private UserPaddleImpl paddle;

    public void init(UserPaddleImpl paddle) {

        this.paddle = paddle;
        keyboard = new Keyboard(this);

        KeyboardEvent pressUp = new KeyboardEvent();
        pressUp.setKey(KeyboardEvent.KEY_UP);
        pressUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressUp);

        KeyboardEvent pressDown = new KeyboardEvent();
        pressDown.setKey(KeyboardEvent.KEY_DOWN);
        pressDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(pressDown);

        KeyboardEvent releaseUp = new KeyboardEvent();
        releaseUp.setKey(KeyboardEvent.KEY_UP);
        releaseUp.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releaseUp);

        KeyboardEvent releaseDown = new KeyboardEvent();
        releaseDown.setKey(KeyboardEvent.KEY_DOWN);
        releaseDown.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(releaseDown);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                this.paddle.setMovingDirection("UP");
                this.paddle.moveUp();
                break;
            case KeyboardEvent.KEY_DOWN:
                this.paddle.setMovingDirection("DOWN");
                this.paddle.moveDown();
                break;
        }
    }



    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {

            case KeyboardEvent.KEY_UP:
                this.paddle.setMovingDirection("NONE");
                break;
            case KeyboardEvent.KEY_DOWN:
                this.paddle.setMovingDirection("NONE");
                break;
        }


    }
}

