import org.academiadecodigo.simplegraphics.graphics.Text;

public class ScoreBoard {

    private int score;
    private Text text;

    public ScoreBoard() {
        this.text = new Text(300, 0, "Score:" + this.score);
        this.score = 0;
        text.draw();
    }

    public void increment() {
        this.score++;
    }

    public void update() {
        this.text.setText("Score:" + this.score);
    }

    public void gameOverText() {
        Text gameOverText = new Text(300, 300, "*** Game Over ***");
        gameOverText.draw();
        gameOverText.grow(20,20);
    }
}
