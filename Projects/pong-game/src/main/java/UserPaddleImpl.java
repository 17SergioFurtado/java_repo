import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class UserPaddleImpl extends AbstractPaddle implements Paddle{

    private KeyBoardListener keyBoardControl;

    public UserPaddleImpl(){

        this.paddle = new Rectangle(10,10,15, 50);
        this.paddle.draw();
        this.paddle.fill();
        this.keyBoardControl = new KeyBoardListener();

        keyBoardControl.init(this);
    }

    public void setMovingDirection(String movingDirection){
        this.movingDirection = movingDirection;
    }

    @Override
    public void moveUp() {
        this.paddle.translate(0, -10);

    }

    @Override
    public void moveDown() {
        this.paddle.translate(0, 10);

    }
    public void showMov(){
        System.out.println(movingDirection);
    }
}