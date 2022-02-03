import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ComputerPaddleImpl extends AbstractPaddle implements Paddle {

    public ComputerPaddleImpl() {
        this.paddle = new Rectangle(595,10,15, 50);
        this.paddle.draw();
        this.paddle.fill();
        this.movingDirection = "DOWN";
    }

    @Override
    public void moveLeft() {

        this.paddle.translate(0, 10);
    }

    @Override
    public void moveRight() {

        this.paddle.translate(0, -10);
    }


}
