import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Screen {

    private Rectangle screen;
    private Snake snake;
    private DirectionControl keyBoardListner;

    public Screen() {
        this.screen = new Rectangle(20, 20, 600, 600);
        this.screen.draw();
        this.snake = new Snake();
        this.keyBoardListner = new DirectionControl();
        this.keyBoardListner.init(snake);
    }

    public void update() {

        this.snake.move();

    }

}
