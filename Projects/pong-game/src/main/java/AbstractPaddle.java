import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public abstract class AbstractPaddle {

    private Rectangle paddle;

    public AbstractPaddle(){
        this.paddle = new Rectangle(0,0,15, 50);
        this.paddle.draw();
        this.paddle.fill();
    }

}
