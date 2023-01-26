package Gun04.Odev;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _Soru02 {
    public static void main(String[] args) {
        //1) Bu siteye gidin. -> https://demo.applitools.com/
        //2) Username kısmına "ttechno@gmail.com" girin.
        //3) Password kısmına "techno123." girin.
        //4) "Sign in" buttonunan tıklayınız.
        //5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.applitools.com/");

        WebElement userName=driver.findElement(By.id("username"));
        userName.sendKeys("ttechno@gmail.com");
        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("techno123.");
        WebElement signIn=driver.findElement(By.id("log-in"));
        signIn.click();
        WebElement resultCheck=driver.findElement(By.id("time"));
        System.out.println("Mesajı veriyor mu?: " + resultCheck.getText().contains("Your nearest branch closes in: 30m 5s"));


        MyFunc.Wait(5);
        driver.quit();

    }
}
