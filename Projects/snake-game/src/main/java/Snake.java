import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<Rectangle> snake;
    private MovingDirection movingDirection;
    private int snakeSize;
    private Rectangle head;

    public Snake() {
        Rectangle segment;
        this.snake = new LinkedList<>();
        this.movingDirection = MovingDirection.RIGHT;

        for(int i = 1; i < 2; i++) {
            segment = new Rectangle(Utils.SEGMENT_SIZE , Utils.SEGMENT_SIZE, Utils.PADDING, Utils.PADDING);
            segment.setColor(Color.BLACK);
            segment.fill();
            this.snake.add(segment);
        }

        this.snakeSize = this.snake.size() - 1;
        this.head = this.snake.get(this.snakeSize);

    }

    private void addSegment(){

        Rectangle segment;
        segment = new Rectangle(this.snake.get(snakeSize).getX(), this.snake.get(snakeSize).getY(), Utils.PADDING, Utils.PADDING);
        segment.setColor(Color.BLACK);
        segment.fill();
        this.snake.add(segment);
        this.snakeSize = this.snake.size() - 1;
        this.head = this.snake.get(this.snakeSize);
    }

    public void move() {

        Rectangle segment;

        for (int i = 0; i < this.snake.size() - 1; i++) {

            segment = this.snake.get(i);
            segment.translate(this.snake.get(i + 1).getX() - this.snake.get(i).getX(), this.snake.get(i + 1).getY() - this.snake.get(i).getY());

        }

        if (this.movingDirection == MovingDirection.DOWN) {

            this.snake.get(this.snakeSize).translate(0, Utils.SEGMENT_SIZE);
        }
        if (this.movingDirection == MovingDirection.UP) {

            this.snake.get(this.snakeSize).translate(0, -Utils.SEGMENT_SIZE);
        }
        if (this.movingDirection == MovingDirection.LEFT) {

            this.snake.get(this.snakeSize).translate(-Utils.SEGMENT_SIZE, 0);
        }
        if (this.movingDirection == MovingDirection.RIGHT) {

            this.snake.get(this.snakeSize).translate(Utils.SEGMENT_SIZE, 0);
        }

    }

    public void changeMovingDirection(MovingDirection movingDirection) {

        this.movingDirection = movingDirection;
    }

    public MovingDirection getMovingDirection() {

        return this.movingDirection;
    }

    public boolean detectWallCollision() {

        if (this.movingDirection == MovingDirection.DOWN) {
            if (this.head.getY() + Utils.SEGMENT_SIZE > Utils.SCREEN_HEITH) {
                return true;
            }
        }
        if (this.movingDirection == MovingDirection.UP) {
            if (this.head.getY() - Utils.SEGMENT_SIZE - Utils.PADDING < 0) {
                return true;
            }
        }
        if (this.movingDirection == MovingDirection.LEFT) {
            if (this.head.getX() - Utils.SEGMENT_SIZE - Utils.PADDING < 0) {
                return true;
            }
        }
        if (this.movingDirection == MovingDirection.RIGHT) {
            if (this.head.getX() + Utils.SEGMENT_SIZE > Utils.SCREEN_WIDTH) {
                return true;
            }
        }

        return false;
    }

    public boolean detectTailCollision() {

        for(Rectangle segment : this.snake) {
            if (this.movingDirection == MovingDirection.UP) {
                if (head.getY() - Utils.SEGMENT_SIZE == segment.getY() && head.getX() == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection == MovingDirection.DOWN) {
                if (head.getY() + Utils.SEGMENT_SIZE == segment.getY() && head.getX() == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection == MovingDirection.LEFT) {
                if (head.getY() == segment.getY() && head.getX() - Utils.SEGMENT_SIZE == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection == MovingDirection.RIGHT) {
                if (head.getY() == segment.getY() && head.getX() + Utils.SEGMENT_SIZE == segment.getX()) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean collisionDetected() {

        return detectWallCollision() || detectTailCollision();
    }

    public boolean collisionWithFood(int x, int y) {

        if (x == this.head.getX() && y == this.head.getY()){
            return true;
        }

     return false;
    }

    public void expand() {

        this.addSegment();
    }
}