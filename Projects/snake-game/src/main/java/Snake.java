import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.util.LinkedList;
import java.util.List;

public class Snake {

    private List<Rectangle> snake;
    private String movingDirection;
    private int snakeSize;
    private int foodPos[];
    private Rectangle head;

    public Snake() {
        Rectangle segment;
        this.snake = new LinkedList<>();
        this.movingDirection = "RIGHT";

        for(int i = 1; i < 10; i++) {
            segment = new Rectangle(Utils.SEGMENT_SIZE , Utils.SEGMENT_SIZE, Utils.PADDING, Utils.PADDING);
            segment.setColor(Color.BLACK);
            segment.fill();
            this.snake.add(segment);
        }

        this.snakeSize = this.snake.size() - 1;
        this.head = this.snake.get(this.snakeSize);

    }

    public void setFoodPos(int[] foodPos) {
        this.foodPos = foodPos;
    }
    private void addSegment(){

        Rectangle segment;
        segment = new Rectangle(this.snake.get(snakeSize).getX(), this.snake.get(snakeSize).getY(), Utils.PADDING, Utils.PADDING);
        segment.setColor(Color.BLACK);
        segment.fill();
        this.snake.add(segment);
        this.snakeSize = this.snake.size() - 1;

    }

    public void move() {

        Rectangle segment;

        for (int i = 0; i < this.snake.size() - 1; i++) {

            segment = this.snake.get(i);
            segment.translate(this.snake.get(i + 1).getX() - this.snake.get(i).getX(), this.snake.get(i + 1).getY() - this.snake.get(i).getY());

        }

        if (this.movingDirection.equals("DOWN")) {

            this.snake.get(this.snakeSize).translate(0, Utils.SEGMENT_SIZE);
        }
        if (this.movingDirection.equals("UP")) {

            this.snake.get(this.snakeSize).translate(0, -Utils.SEGMENT_SIZE);
        }
        if (this.movingDirection.equals("LEFT")) {

            this.snake.get(this.snakeSize).translate(-Utils.SEGMENT_SIZE, 0);
        }
        if (this.movingDirection.equals("RIGHT")) {

            this.snake.get(this.snakeSize).translate(Utils.SEGMENT_SIZE, 0);
        }

    }

    public void setMovingDirection(String movingDirection) {

        this.movingDirection = movingDirection;
    }

    public String getMovingDirection() {

        return movingDirection;
    }

    public boolean detectWallCollision() {
        Rectangle snakeHead = this.snake.get(snakeSize);

        if (this.movingDirection.equals("DOWN")) {
            if (snakeHead.getY() + Utils.SEGMENT_SIZE > Utils.SCREEN_HEITH) {
                return true;
            }
        }
        if (this.movingDirection.equals("UP")) {
            if (snakeHead.getY() - Utils.SEGMENT_SIZE - Utils.PADDING < 0) {
                return true;
            }
        }
        if (this.movingDirection.equals("LEFT")) {
            if (snakeHead.getX() - Utils.SEGMENT_SIZE - Utils.PADDING < 0) {
                return true;
            }
        }
        if (this.movingDirection.equals("RIGHT")) {
            if (snakeHead.getX() + Utils.SEGMENT_SIZE > Utils.SCREEN_WIDTH) {
                return true;
            }
        }

        return false;
    }

    public boolean detectTailCollision() {
        Rectangle snakeHead = this.snake.get(this.snakeSize);

        for(Rectangle segment : this.snake) {
            if (this.movingDirection.equals("UP")) {
                if (snakeHead.getY() - Utils.SEGMENT_SIZE == segment.getY() && snakeHead.getX() == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection.equals("DOWN")) {
                if (snakeHead.getY() + Utils.SEGMENT_SIZE == segment.getY() && snakeHead.getX() == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection.equals("LEFT")) {
                if (snakeHead.getY() == segment.getY() && snakeHead.getX() - Utils.SEGMENT_SIZE == segment.getX()) {
                    return true;
                }
            }

            if (this.movingDirection.equals("RIGHT")) {
                if (snakeHead.getY() == segment.getY() && snakeHead.getX() + Utils.SEGMENT_SIZE == segment.getX()) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean collisionDetected() {

        return detectWallCollision() || detectTailCollision();
    }

    public boolean collisionWithFood() {

        if (this.foodPos[0] == this.head.getX() && this.foodPos[1] == this.head.getY()){
            return true;
        }
     return false;
    }

    public void grow() {

        this.addSegment();
    }
}