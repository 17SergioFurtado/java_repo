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
        this.movingDirection = "RIGHT";

        segment = new Rectangle(20, 20, 20, 20);
        segment.setColor(Color.BLACK);
        segment.fill();
        this.snake.add(segment);

        segment = new Rectangle(40, 20, 20, 20);
        segment.setColor(Color.BLACK);
        segment.fill();
        this.snake.add(segment);

        segment = new Rectangle(60, 20, 20, 20);
        segment.setColor(Color.BLACK);
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

    public boolean detectWallCollision() {
        Rectangle snakeHead = this.snake.get(2);

        if (this.movingDirection.equals("DOWN")) {
            if (snakeHead.getY() + 20 > 600) {
                return true;
            }
        }
        if (this.movingDirection.equals("UP")) {
            if (snakeHead.getY() - 40 < 0) {
                return true;
            }
        }
        if (this.movingDirection.equals("LEFT")) {
            if (snakeHead.getX() - 40 < 0) {
                return true;
            }
        }
        if (this.movingDirection.equals("RIGHT")) {
            if (snakeHead.getX() + 20 > 600) {
                return true;
            }
        }

        return false;
    }

    public boolean detectTailCollision() {
        Rectangle snakeHead = this.snake.get(2);

        for(Rectangle segment : this.snake) {
            if (this.movingDirection.equals("UP")) {
                if (snakeHead.getY() - 20 == segment.getY() && snakeHead.getX() == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection.equals("DOWN")) {
                if (snakeHead.getY() + 20 == segment.getY() && snakeHead.getX() == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection.equals("LEFT")) {
                if (snakeHead.getY() == segment.getY() && snakeHead.getX() - 20 == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection.equals("RIGHT")) {
                if (snakeHead.getY() == segment.getY() && snakeHead.getX() + 20 == segment.getX()) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean collisionDetected() {

        return detectWallCollision() || detectTailCollision();
    }
}