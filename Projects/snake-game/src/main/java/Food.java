import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Food {

    private Ellipse food;

    public Food() {

        this.food = new Ellipse(Utils.SEGMENT_SIZE * 10, Utils.SEGMENT_SIZE * 10, Utils.PADDING, Utils.PADDING);
        this.food.setColor(Color.GREEN);
        this.food.fill();
    }

    public void newPos() {

        int xpos = (Utils.randomInt() - this.food.getX() + Utils.PADDING);
        int ypos = (Utils.randomInt() - this.food.getY() + Utils.PADDING);

        this.food.translate(xpos, ypos);

    }

    public int getXPos(){
       return this.food.getX();
    }

    public int getYPos(){
        return this.food.getY();
    }
}
