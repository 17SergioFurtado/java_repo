import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PongGame {

    private Rectangle field;
    private Line fieldHalfLine;
    private Paddle userPaddle;
    private Paddle computerPaddle;

    public void start() {
        this.field = new Rectangle(10 ,10,600, 300);
        this.field.draw();
        this.fieldHalfLine = new Line(300,10,300, 310);
        this.fieldHalfLine.draw();
        this.userPaddle = new UserPaddleImpl();
        this.computerPaddle = new ComputerPaddleImpl();

    }
}
