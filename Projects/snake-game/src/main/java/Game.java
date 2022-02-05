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

        this.keyBoardListener = new KeyBoardListener();
        this.keyBoardListener.init(snake);

    }

    public void updateScreen() {

        while (!isCollisionDetected) {

            if (this.snake.collisionDetected()) {
                this.scoreBoard.gameOverText();
                break;
            }

            if (this.snake.collisionWithFood(this.food.getXPos(), this.food.getYPos())) {

                this.food.newPos();
                this.snake.expand();
                this.scoreBoard.increment();
                this.scoreBoard.update();
            }

            try {

                Thread.sleep(100);

            }catch (InterruptedException e){
                e.printStackTrace();
            }
            this.snake.move();

        }
    }

}
