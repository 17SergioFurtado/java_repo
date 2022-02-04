import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Ball {

    private Ellipse ball;
    private String movingDirection;

    public Ball() {
        this.ball = new Ellipse(290, 150, 20,20);
        this.ball.setColor(Color.GREEN);
        this.ball.fill();
        this.movingDirection = "LEFT";
    }

    public void move() {
        if (this.movingDirection.equals("RIGHT")) {

            this.ball.translate(10, 0);
        } else {

            this.ball.translate(-10, 0);
        }
    }

    public void changeMovingDirection() {

        this.movingDirection = (this.movingDirection.equals("LEFT")) ? "RIGHT" : "LEFT";
    }

    public int[] getPos() {

        int[] ballPositon = {this.ball.getX(), this.ball.getY()};
        return ballPositon;
    }

    public boolean collisionWithPaddle(int userPaddle, int computerPaddle) {

        if(this.ball.getY() >= userPaddle && this.ball.getY() <= userPaddle + 50 && this.ball.getX() <= 25) {
            return true;
        }

        if(this.ball.getY() >= computerPaddle && this.ball.getY() <= computerPaddle + 50 && this.ball.getX() + 10 >= 600-10) {
            return true;
        }

        return false;
    }
}
