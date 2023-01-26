package Gun07_XPath.Odev;

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

        WebElement fullName= driver.findElement(By.xpath("//input[@id='userName']"));
        fullName.sendKeys("Automation");
        WebElement email=driver.findElement(By.xpath("//input[contains(@placeholder,'@')]"));
        email.sendKeys("Testing@gmail.com");
        WebElement adress=driver.findElement(By.xpath("//textarea[@class='form-control'and@id='currentAddress']"));
        adress.sendKeys("Testing Current Address");
        WebElement perAdress=driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        perAdress.sendKeys("Testing Permanent Address");
        WebElement submitButton=driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.click();

        WebElement nameCheck =driver.findElement(By.xpath("//p[@id='name']"));
        Assert.assertTrue("Full Name \"Automation\" içermiyor",nameCheck.getText().contains("Automation"));

        WebElement emailCheck=driver.findElement(By.xpath("//p[@id='name']/following-sibling::p[1]"));
        Assert.assertTrue("Email içerisinde \"Testing\" bulundurmuyor",emailCheck.getText().contains("Testing"));


        MyFunc.Wait(5);
        driver.quit();







    }




}
