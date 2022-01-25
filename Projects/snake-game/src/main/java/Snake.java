import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<Rectangle> snake;
    private String movingDirection;

    public Snake() {

        Rectangle segment;
        this.snake = new LinkedList<>();
        this.movingDirection = "DOWN";

        segment = new Rectangle(20, 20, 20, 20);
        segment.setColor(Color.BLACK);
        segment.draw();
        segment.fill();

        this.snake.add(segment);

        segment = new Rectangle(40, 20, 20, 20);
        segment.setColor(Color.BLACK);
        segment.draw();
        segment.fill();

        this.snake.add(segment);

        segment = new Rectangle(60, 20, 20, 20);
        segment.setColor(Color.BLACK);
        segment.draw();
        segment.fill();

        this.snake.add(segment);


    }

    public void move() {

        Rectangle segment;

        for (int i = 0; i < this.snake.size() - 1; i++) {

            segment = this.snake.get(i);
            segment.translate(this.snake.get(i + 1).getX() - this.snake.get(i).getX(), this.snake.get(i + 1).getY() - this.snake.get(i).getY());
        }

        if (this.movingDirection.equals("DOWN")) {

            this.snake.get(2).translate(0, 20);
        }
        if (this.movingDirection.equals("UP")) {

            this.snake.get(2).translate(0, -20);
        }
        if (this.movingDirection.equals("LEFT")) {

            this.snake.get(2).translate(-20, 0);
        }
        if (this.movingDirection.equals("RIGHT")) {

            this.snake.get(2).translate(20, 0);
        }

    }

    public void setMovingDirection(String movingDirection) {

        this.movingDirection = movingDirection;
    }

    public String getMovingDirection() {

        return movingDirection;
    }

}
