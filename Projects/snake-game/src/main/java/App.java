public class App {

    public static void main(String args[]) throws InterruptedException {

        Screen screen = new Screen();

        while (true) {

            Thread.sleep(1000);
            screen.update();

        }
    }
}
