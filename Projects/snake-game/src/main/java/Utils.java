public class Utils {

    public static final int PADDING = 20;
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEITH = 600;
    public static final int SEGMENT_SIZE = 20;

    public static int randomInt() {

        return (int) Math.floor(Math.random() * SCREEN_WIDTH/SEGMENT_SIZE) * SEGMENT_SIZE;
    }
}
