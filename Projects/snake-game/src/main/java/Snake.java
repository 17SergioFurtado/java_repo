import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Snake {

    private Rectangle snake[];

    public Snake() {

        this.snake = new Rectangle[3];
        this.snake[0] = new Rectangle(20, 20, 20, 20);
        this.snake[0].setColor(Color.BLACK);
        this.snake[0].draw();
        this.snake[0].fill();

        this.snake[1] = new Rectangle(40, 20, 20, 20);
        this.snake[1].setColor(Color.BLACK);
        this.snake[1].draw();
        this.snake[1].fill();

        this.snake[2] = new Rectangle(60, 20, 20, 20);
        this.snake[2].setColor(Color.BLACK);
        this.snake[2].draw();
        this.snake[2].fill();

    }
}
