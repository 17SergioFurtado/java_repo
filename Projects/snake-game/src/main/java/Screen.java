import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Screen {

    private Rectangle screen;
    private Snake snake;
    private KeyBoardListener keyBoardListener;
    private boolean isCollisionDetected = false;

    public Screen() {
        this.screen = new Rectangle(Utils.PADDING, Utils.PADDING, Utils.SCREEN_HEITH, Utils.SCREEN_WIDTH);
        this.screen.draw();
        this.snake = new Snake();
        this.keyBoardListener = new KeyBoardListener();
        this.keyBoardListener.init(snake);
    }

    public void update() throws InterruptedException{

        while (!isCollisionDetected) {

            Thread.sleep(100);
            if (this.snake.collisionDetected()) {
                break;
            }
            this.snake.move();

        }
    }

}
