package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

/*
Создать автотест на страницу регистрации и проверить, можно ли зарегистрироваться с пустым именем и фамилией
 */
public class Test1 {
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

    private boolean isElementPresent(WebDriver driver, By locator) {
        return !driver.findElements(locator).isEmpty();
    }

}

