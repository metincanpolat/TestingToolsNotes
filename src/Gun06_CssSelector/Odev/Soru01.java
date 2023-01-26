package Gun06_CssSelector.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru01 extends BaseDriver {
    //    1) Bu siteye gidin. ->  http://demoqa.com/text-box
    //    2) Full Name kısmına "Automation" girin.
    //    3) Email kısmına "Testing@gmail.com" girin.
    //    4) Current Address kısmına "Testing Current Address" girin.
    //    5) Permanent Address kısmına "Testing Permanent Address" girin.
    //    6) Submit butonuna tıklayınız.
    //    7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
    //    8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.

    @Test

    public void Test1(){

        driver.get("http://demoqa.com/text-box");

        WebElement fullName= driver.findElement(By.cssSelector("input.mr-sm-2[type='text']"));
        fullName.sendKeys("Automation");
        WebElement email=driver.findElement(By.cssSelector("input[placeholder*='@']")); // * contains
        email.sendKeys("Testing@gmail.com");
        WebElement adress=driver.findElement(By.cssSelector("textarea[id*='current']")); // ^ile başlayan
        adress.sendKeys("Testing Current Address");
//        MyFunc.Wait(5); // Ekranda submit butonu göremediği için bu sürede manuel kaydırdım.
        WebElement perAdress=driver.findElement(By.cssSelector("textarea[class='form-control'][id='permanentAddress']"));
        perAdress.sendKeys("Testing Permanent Address");
        WebElement submitButton=driver.findElement(By.cssSelector("button[id$=mit]"));
        submitButton.click();

        WebElement nameCheck =driver.findElement(By.cssSelector("p#name"));
        Assert.assertTrue("Full Name \"Automation\" içermiyor",nameCheck.getText().contains("Automation"));

        WebElement emailCheck=driver.findElement(By.cssSelector("p#name+p"));
        Assert.assertTrue("Email içerisinde \"Testing\" bulundurmuyor",emailCheck.getText().contains("Testing"));


        MyFunc.Wait(5);
        driver.quit();







    }




}
