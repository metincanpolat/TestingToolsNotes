package Gun07_XPath.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru02 extends BaseDriver {
    //1) Bu siteye gidin. -> https://demo.applitools.com/
    //2) Username kısmına "ttechno@gmail.com" girin.
    //3) Password kısmına "techno123." girin.
    //4) "Sign in" buttonunan tıklayınız.
    //5) "Your nearest branch closes in: 30m 5s" yazısının göründüğünü doğrulayınız.

    @Test
    public void Test1(){
        driver.get("https://demo.applitools.com/");

        WebElement userName=driver.findElement(By.xpath("//input[@id='username']"));
        userName.sendKeys("ttechno@gmail.com");
        WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("techno123.");
        WebElement signIn=driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
        signIn.click();
        WebElement resultCheck=driver.findElement(By.xpath("//h6[@id='time']"));
        Assert.assertTrue("İçerik bulunamadı",resultCheck.getText().contains("Your nearest branch closes in: 30m 5s"));


        MyFunc.Wait(2);
        driver.quit();
    }
}
