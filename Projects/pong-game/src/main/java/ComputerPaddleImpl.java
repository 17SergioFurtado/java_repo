import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ComputerPaddleImpl extends AbstractPaddle implements Paddle {

    public ComputerPaddleImpl() {
        this.paddle = new Rectangle(595,150,15, 50);
        this.paddle.draw();
        this.paddle.fill();
        this.movingDirection = "DOWN";
    }

    @Override
    public void moveUp() {

        this.paddle.translate(0, -10);
    }

    @Override
    public void moveDown() {

        this.paddle.translate(0, 10);
    }

    public boolean collisionWithWallDetected() {

        if(this.paddle.getY() == 10 || this.paddle.getY() == 250 + 10) {
            return true;
        }
        return false;
    }

    public void move() {
        if(this.movingDirection.equals("UP")) {
            this.paddle.translate(0,-10);
        }
        else {
            this.paddle.translate(0,10);

        }
    }

    public void changeMovingDirection(){
        this.movingDirection = (this.movingDirection.equals("UP")) ? "DOWN" : "UP" ;
    }
}
