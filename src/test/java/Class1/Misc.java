package Class1;

public class Misc {

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
