package Class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Misc {

    public static void pause(int seconds) {
        try {
            Thread.sleep(seconds * 3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
