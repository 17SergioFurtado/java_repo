import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;

public class Ball {

    private Ellipse ball;

    public Ball() {
        this.ball = new Ellipse(291, 150, 18,18);
        this.ball.setColor(Color.GREEN);
        this.ball.fill();
    }
}
