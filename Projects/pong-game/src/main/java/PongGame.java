import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class PongGame {

    private Rectangle field;


    public void start() {
        this.field = new Rectangle(20 ,20,600, 300);
        this.field.draw();

    }
}
