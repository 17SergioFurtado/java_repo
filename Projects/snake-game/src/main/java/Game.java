import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Game {

    private Rectangle screen;
    private Snake snake;
    private Food food;
    private KeyBoardListener keyBoardListener;
    private ScoreBoard scoreBoard;
    private boolean isCollisionDetected = false;


    public Game() {
        this.screen = new Rectangle(Utils.PADDING, Utils.PADDING, Utils.SCREEN_HEITH, Utils.SCREEN_WIDTH);
        this.screen.draw();
        this.snake = new Snake();
        this.food = new Food();
        this.scoreBoard = new ScoreBoard();
        this.snake.setFoodPos(this.food.getFoodPos());
        this.keyBoardListener = new KeyBoardListener();
        this.keyBoardListener.init(snake);

    }

    public void updateScreen() throws InterruptedException{

        while (!isCollisionDetected) {

            if (this.snake.collisionDetected()) {
                this.scoreBoard.gameOverText();
                break;
            }

            if (this.snake.collisionWithFood()) {
                this.food.newPos();
                this.snake.setFoodPos(this.food.getFoodPos());
                this.snake.grow();
                this.scoreBoard.increment();
                this.scoreBoard.updateScore();
            }
            this.snake.move();
            Thread.sleep(100);

        }
    }

}
