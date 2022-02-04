import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PongGame {

    private Rectangle field;
    private Line fieldHalfLine;
    private UserPaddleImpl userPaddle;
    private ComputerPaddleImpl computerPaddle;

    public void start() throws InterruptedException {
        this.field = new Rectangle(10 ,10,600, 300);
        this.field.draw();
        this.fieldHalfLine = new Line(300,10,300, 310);
        this.fieldHalfLine.draw();
        this.userPaddle = new UserPaddleImpl();
        this.computerPaddle = new ComputerPaddleImpl();

        while(true) {
            if (this.computerPaddle.collisionWithWallDetected()) {
                this.computerPaddle.changeMovingDirection();
                }
            Thread.sleep(100);
            this.computerPaddle.move();
            userPaddle.showMov();
            }
    }

}
