import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Food {

    private Rectangle food;

    public Food() {

        this.food = new Rectangle(Utils.SEGMENT_SIZE * 10, Utils.SEGMENT_SIZE * 10, Utils.PADDING, Utils.PADDING);
        this.food.fill();
    }

    public void newPos() {

        int xpos = (Utils.randomInt() - this.food.getX());
        int ypos = (Utils.randomInt() - this.food.getY());
        System.out.println(Utils.randomInt());
        this.food.translate(xpos, ypos);

    }
}
