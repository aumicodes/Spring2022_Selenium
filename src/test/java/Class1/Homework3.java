package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Homework3 {


    /**
     * TC-1:  darksky.net
     * Verify correct temperature value is displayed after changing temperature units
     */

    @Test
    public void verifyCorrectTemp() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.darksky.net");

        By text = (By.xpath("//span[@class='summary swap']"));
        String[] getText = driver.findElement(text).getText().split("˚");
        int convertion = Integer.parseInt(getText[0]);
        System.out.println(convertion);
        driver.findElement(By.xpath("//div[contains(@class,'selectric-units')]")).click();
        By textC = (By.xpath("//span[@class='summary swap']"));
        String[] getTextC = driver.findElement(textC).getText().split("˚");
        int convertionC = Integer.parseInt(getTextC[0]);
        System.out.println(convertionC);
        double formulaTemp = (convertion - 32) * 5 / 9;
        System.out.println(formulaTemp);
        boolean bb = convertionC == Math.round(formulaTemp);
        System.out.println(bb);

        Assert.assertTrue(bb, "Not true");
        driver.quit();
    }

    /**
     * TC-2: facebook.com
     * Verify current date is selected in the dropdown when user lands on the Create new account form
     */

    @Test
    public void facebookTodayDate() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        MyDriver.getDriver().findElement(By.partialLinkText("new account")).click();
        Misc.pause(3);
        String month = MyDriver.getDriver().findElement(By.xpath("//select[@title='Month']/option[@selected='1']")).getText();
        String day = MyDriver.getDriver().findElement(By.xpath("//select[@title='Day']/option[@selected='1']")).getText();
        String year = MyDriver.getDriver().findElement(By.xpath("//select[@title='Year']/option[@selected='1']")).getText();
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM:dd:yyyy");
        String dateLocal = sdf.format(d);
        String dateFacebook = month + ":" + day + ":" + year;
        Assert.assertEquals(dateFacebook, dateLocal, "Test Fail - Dates don't match");
        MyDriver.quitWindows();
    }

    /**
     * TC-3: https://classroomessentialsonline.com/
     * Verify user lands on Economy Church Chairs page after clicking the option from Church Chairs
     */

    @Test
    public void verifyEconomyChurchChairs() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.classroomessentialsonline.com");

        Actions a = new Actions(MyDriver.getDriver());
        By chairsLocator = By.xpath("//li[@class='navPages-item']/a[contains(text(),'Church')]");
        WebElement churchChairs = MyDriver.getDriver().findElement(chairsLocator);
        a.moveToElement(churchChairs).perform();
        Misc.pause(2);
        String href = MyDriver.getDriver().findElement(By.xpath("//*[text()='Economy Church Chairs']")).getAttribute("href");
        String navLink = MyDriver.getDriver().findElement(By.xpath("//*[text()='Economy Church Chairs']")).getText();
        MyDriver.getDriver().findElement(By.xpath("//*[text()='Economy Church Chairs']")).click();
        Misc.pause(2);
        String currentUrl = MyDriver.getDriver().getCurrentUrl();
        Assert.assertEquals(currentUrl, href, "Test Failed - URLs do not match");

    }
}
