package Class1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework2 {

    // Testcase-1:
     /* Verify "Keep me signed in" is NOT selected for messenger login page
     * Click "Log in" button
     * Verify "Incorrect email or phone number" is displayed
     * Verify "Continue" button is enabled
     *
     1. Launch a new browser window
     2. Open messenger.com
     3. Verify login email text & button -
        find locators for email & pass and web elements for locators.
     4. Confirm "continue" button is enabled
     *
     */

    @Test
    public void loginToMessenger() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://messenger.com/");

        By myName = By.className("uiInputLabelInput");
        WebElement bigname = driver.findElement(myName);
        boolean isSelected = bigname.isSelected();
        Assert.assertFalse(isSelected, "It is selected");

        By mylogin = By.name("login");
        WebElement findlogin = driver.findElement(mylogin);

        driver.findElement(By.id("close")).click();
        findlogin.click();

        By mytext = By.xpath("//button[@name='login']");

        WebElement findEl = driver.findElement(mytext);
        boolean isDisplaced = findEl.isDisplayed();
        Assert.assertTrue(isDisplaced, "Is not displayed");

        By isenabled = By.name("login");
        WebElement enbaledButton = driver.findElement(isenabled);
        boolean enabledTrue = enbaledButton.isDisplayed();
        Assert.assertTrue(enabledTrue, "Is not enabled");
    }

    // Testcase-2:
    /*
     * On Create new account page:
     * Verify the "Sign Up" button is enabled when user lands on the form
     * Enter the below details in Sign Up form EXCEPT DOB
     * First name
     * Last name
     * email
     * re-enter email
     * new password
     * click Sign Up
     *
     * Verify "Please choose a gender. You can change who can see this later." is displayed
     */

    @Test
    public void SignUp() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");

        By uniqueText = By.linkText("Create new account");
        WebElement findElement = driver.findElement(uniqueText);
        boolean isDisplayed = findElement.isDisplayed();
        Assert.assertTrue(isDisplayed, "Is not enabled");

        By linktext = By.linkText("Create new account");
        WebElement findCreButtn = driver.findElement(linktext);
        findCreButtn.sendKeys("Find the button");
        findCreButtn.click();

        By firstName = By.xpath("//input[@placeholder='First name']");
        Misc.pause(3);
        WebElement textName = driver.findElement(firstName);
        textName.sendKeys("Aumi");

        By lastName = By.xpath("//input[@name='lastname'] ");
        WebElement enterLastName = driver.findElement(lastName);
        enterLastName.sendKeys("Alam");

        By enterEmail = By.xpath("//input[@aria-label='Mobile number or email']");
        WebElement enterEmailMobile = driver.findElement(enterEmail);
        enterEmailMobile.sendKeys("myemail@gmail.com");

        By reenterEmail = By.xpath("//input[@aria-label='Re-enter email']");
        WebElement reenterEmailMobile = driver.findElement(reenterEmail);
        reenterEmailMobile.sendKeys("myemail@gmail.com");

        By enterpassword = By.xpath("//input[@aria-label='New password']");
        WebElement entnewPass = driver.findElement(enterpassword);
        entnewPass.sendKeys("QAengineer");

        By verGender = By.xpath("//button[@name='websubmit']");
        WebElement findgenderbutton = driver.findElement(verGender);
        findgenderbutton.click();

        By verDisplay = By.xpath("//div[text()='Please choose a gender. You can change who can see this later.']");
        WebElement genderDisplayed = driver.findElement(verDisplay);

        boolean genderIsDisplayed = genderDisplayed.isDisplayed();
        Assert.assertTrue(genderIsDisplayed, "Is not displayed");
    }
}