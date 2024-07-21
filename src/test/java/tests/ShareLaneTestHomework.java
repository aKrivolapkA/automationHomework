package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Random;

public class ShareLaneTestHomework {
    @Test
    public void emptyFirstNameAndLastNameTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("888888");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();

        driver.findElement(By.name("email")).sendKeys("Bob@test.mail");
        driver.findElement(By.name("password1")).sendKeys("password");
        driver.findElement(By.name("password2")).sendKeys("password");
        driver.findElement(By.xpath("//*[@value= 'Register']")).click();

        boolean isErrorMessagePresent = isElementPresent(driver, By.xpath("//*[contains(@class,'error_message')]"));
        Assert.assertTrue(isErrorMessagePresent, "Error message is not present on the page.");

        driver.quit();
    }


    @Test
    public void emptyEmailTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        driver.findElement(By.name("zip_code")).sendKeys("888888");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();

        driver.findElement(By.name("first_name")).sendKeys("Bob");
        driver.findElement(By.name("last_name")).sendKeys("Bobowa");
        driver.findElement(By.name("password1")).sendKeys("password");
        driver.findElement(By.name("password2")).sendKeys("password");
        driver.findElement(By.xpath("//*[@value= 'Register']")).click();

        boolean isErrorMessagePresent = isElementPresent(driver, By.xpath("//*[contains(@class,'error_message')]"));
        Assert.assertTrue(isErrorMessagePresent, "Error message is not present on the page.");

        driver.findElement(By.name("email")).sendKeys("@");
        driver.findElement(By.name("password1")).sendKeys("password");
        driver.findElement(By.name("password2")).sendKeys("password");
        driver.findElement(By.xpath("//*[@value= 'Register']")).click();

        Assert.assertTrue(isErrorMessagePresent, "Error message is not present on the page.");

        driver.quit();
    }

    @Test
    public void differentPasswords() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        driver.findElement(By.name("zip_code")).sendKeys("888888");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();

        driver.findElement(By.name("first_name")).sendKeys("Bob");
        driver.findElement(By.name("last_name")).sendKeys("Bobowa");
        driver.findElement(By.name("email")).sendKeys("Bob@test.mail");
        driver.findElement(By.name("password1")).sendKeys("password");
        driver.findElement(By.name("password2")).sendKeys("test123");
        driver.findElement(By.xpath("//*[@value= 'Register']")).click();

        boolean isMessagePresent = isElementPresent(driver, By.xpath("//*[contains(@class,'confirmation_message')]"));
        Assert.assertTrue(isMessagePresent, "Message is not   present on the page.");
        driver.quit();
    }

    @Test
    public void randomZipCode() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");

        Random random = new Random();
        int x = 10000 + random.nextInt(999999 - 10000 + 1);
        driver.findElement(By.name("zip_code")).sendKeys(String.valueOf(x));
        driver.findElement(By.xpath("//*[@value='Continue']")).click();

        driver.findElement(By.name("first_name")).sendKeys("Bob");
        driver.findElement(By.name("last_name")).sendKeys("Bobowa");
        driver.findElement(By.name("email")).sendKeys("Bob@test.mail");
        driver.findElement(By.name("password1")).sendKeys("password");
        driver.findElement(By.name("password2")).sendKeys("password");
        driver.findElement(By.xpath("//*[@value= 'Register']")).click();

        boolean isMessagePresent = isElementPresent(driver, By.xpath("//*[contains(@class,'confirmation_message')]"));
        Assert.assertTrue(isMessagePresent, "Message is not  present on the page.");
        driver.quit();
    }
    private boolean isElementPresent(WebDriver driver, By locator) {
        return !driver.findElements(locator).isEmpty();
    }
}