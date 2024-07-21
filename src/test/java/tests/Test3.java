package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;

/*
Проверить, можно ли зарегистрироваться, введя разные пароли в поля пароль и подтверждение пароля
 */
public class Test3 {

    @Test
    public void differentPasswords(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
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

        boolean isErrorMessagePresent = isElementPresent(driver, By.xpath("//*[contains(@class,'confirmation_message')]"));
        Assert.assertTrue(isErrorMessagePresent, "Message is not   present on the page.");
        driver.quit();

    }
    public boolean isElementPresent(WebDriver driver, By locator){
        return !driver.findElements(locator).isEmpty();
    }
}
