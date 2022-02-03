import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class ComputerPaddleImpl extends AbstractPaddle implements Paddle {

    public ComputerPaddleImpl() {
        this.paddle = new Rectangle(595,10,15, 50);
        this.paddle.draw();
        this.paddle.fill();

    }

    @Override
    public void moveLeft() {

    }

    @Override
    public void moveRight() {

    }
}
