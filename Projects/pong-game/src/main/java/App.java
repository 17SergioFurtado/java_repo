public class App {

    public static void main(String[] args) {

        PongGame pongGame;

        pongGame = new PongGame();

        try {
            pongGame.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
