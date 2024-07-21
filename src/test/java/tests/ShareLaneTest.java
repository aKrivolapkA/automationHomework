package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ShareLaneTest {

    @Test
    public void fillZipCodeFieldTest(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        WebDriver  driver = new ChromeDriver();
        driver.get("https://www.sharelane.com/cgi-bin/register.py"); // открывем страницу в браузере хром
        driver.findElement(By.name("zip_code")).sendKeys("888888");
        driver.findElement(By.xpath("//*[@value='Continue']")).click();


        driver.findElement(By.name("first_name")).sendKeys("Bob");
        driver.findElement(By.name("last_name")).sendKeys("Bobowa");
        driver.findElement(By.name("email")).sendKeys("Bob@test.mail");
        driver.findElement(By.name("password1")).sendKeys("password");
        driver.findElement(By.name("password2")).sendKeys("password");

        driver.findElement(By.xpath("//*[@value= 'Register']")).click();
        driver.quit(); //автомаическое закрытие браузера


    }
}
