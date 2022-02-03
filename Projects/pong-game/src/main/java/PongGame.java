import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PongGame {

    private Rectangle field;
    private Paddle userPaddle;


    public void start() {
        this.field = new Rectangle(10 ,10,600, 300);
        this.field.draw();
        this.userPaddle = new UserPaddleImpl();
    }
}
