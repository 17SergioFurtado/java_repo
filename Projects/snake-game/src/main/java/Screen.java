import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Screen {

    private Rectangle screen;
    private Snake snake;
    private KeyBoardListener keyBoardListener;

    public Screen() {
        this.screen = new Rectangle(20, 20, 600, 600);
        this.screen.draw();
        this.snake = new Snake();
        this.keyBoardListener = new KeyBoardListener();
        this.keyBoardListener.init(snake);
    }

    public void update() {

        this.snake.move();

    }

}
