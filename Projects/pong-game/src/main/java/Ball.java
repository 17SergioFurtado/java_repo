import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Ball {

    private Ellipse ball;
    private int movingAngle;

    public Ball() {
        this.ball = new Ellipse(290, 150, 20,20);
        this.ball.setColor(Color.GREEN);
        this.ball.fill();
        this.movingAngle = 45;
    }

    public void move() {
        switch (this.movingAngle) {

            case 0:
                this.ball.translate(10, 0);
                break;
            case 30:
                this.ball.translate(10, 10);
                break;
            case 45:
                this.ball.translate(10, -10);
                break;
            case 60:
                this.ball.translate(10, 10);
                break;
            case 120:
                this.ball.translate(10, 10);
                break;
            case 135:
                this.ball.translate(-10, -10);
                break;
            case 150:
                this.ball.translate(10, 10);
                break;
            case 180:
                this.ball.translate(-10, 0);
                break;
            case 210:
                this.ball.translate(10, 10);
                break;
            case 225:
                this.ball.translate(-10, 10);
                break;
            case 240:
                this.ball.translate(10, 10);
                break;
            case 300:
                this.ball.translate(10, 10);
                break;
            case 315:
                this.ball.translate(10, 10);
                break;
            case 330:
                this.ball.translate(10, 10);
                break;
            case 360:
                this.ball.translate(10, 0);
                break;
        }
    }

    public void setballWallReactionAngle() {

        this.movingAngle = (360 - this.movingAngle < 360) ? 360 - this.movingAngle : 180 - this.movingAngle;

    }


    public void setballPaddleReactionAngle() {

        this.movingAngle = (180 - this.movingAngle >= 0) ? 180 - this.movingAngle : 360 + 180 - this.movingAngle;

    }

    public boolean detectCollisionWithWall() {

        if(this.ball.getY() - 20 < 0) {
            return true;
        }

        if(this.ball.getY() + 20 > 300) {
            return true;
        }

        return false;
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
