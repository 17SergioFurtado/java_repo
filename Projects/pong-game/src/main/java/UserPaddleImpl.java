import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class UserPaddleImpl extends AbstractPaddle implements Paddle{

    public UserPaddleImpl(){
        this.paddle = new Rectangle(10,10,15, 50);
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
