package Gun06_CssSelector.Odev;

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

        WebElement userName=driver.findElement(By.cssSelector("div.form-group>input[id^=user]"));
        userName.sendKeys("ttechno@gmail.com");
        WebElement password=driver.findElement(By.cssSelector("div.form-group>input[placeholder$=password]"));
        password.sendKeys("techno123.");
        WebElement signIn=driver.findElement(By.cssSelector(".buttons-w>a"));
        signIn.click();
        WebElement resultCheck=driver.findElement(By.cssSelector(".element-wrapper>div+h6#time"));
        Assert.assertTrue("İçerik bulunamadı",resultCheck.getText().contains("Your nearest branch closes in: 30m 5s"));


        MyFunc.Wait(2);
        driver.quit();
    }
}
