import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<Rectangle> snakeHead;
    private String movingDirection;

    public Snake() {

        Rectangle segment;
        this.snakeHead = new LinkedList<>();
        this.movingDirection = "Down";

        segment = new Rectangle(20, 20, 20, 20);
        segment.setColor(Color.BLACK);
        segment.draw();
        segment.fill();

        this.snakeHead.add(segment);

        segment = new Rectangle(40, 20, 20, 20);
        segment.setColor(Color.BLACK);
        segment.draw();
        segment.fill();

        this.snakeHead.add(segment);

        segment = new Rectangle(60, 20, 20, 20);
        segment.setColor(Color.BLACK);
        segment.draw();
        segment.fill();

        this.snakeHead.add(segment);


    }

    public void move() {

        Rectangle segment;

        for (int i = 0; i < this.snakeHead.size() - 1; i++) {

            segment = this.snakeHead.get(i);
            segment.translate(this.snakeHead.get(i + 1).getX() - this.snakeHead.get(i).getX(), this.snakeHead.get(i + 1).getY() - this.snakeHead.get(i).getY());
        }
        this.snakeHead.get(2).translate(0, 20);
    }
}
