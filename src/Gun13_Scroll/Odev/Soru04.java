package Gun13_Scroll.Odev;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Soru04 extends BaseDriver {
//1) https://demoqa.com/browser-windows adresine gidin
//2) Alerts’e tiklayin
//3) On button click, alert will appear after 5 seconds karsisindaki click me butonuna basin
//4) Allert’in gorunur olmasini bekleyin
//5) Allert uzerindeki yazinin “This alert appeared after 5 seconds” oldugunu test edin
//6) Ok diyerek alerti kapatin

    @Test
    public void Test1(){

        driver.get("https://demoqa.com/browser-windows");

        WebElement alertsBut= driver.findElement(By.xpath("//span[text()='Alerts']"));
        alertsBut.click();
        WebElement clickMe= driver.findElement(By.id("timerAlertButton"));
        clickMe.click();
        waitAWhile.until(ExpectedConditions.alertIsPresent());

        Assert.assertEquals("This alert appeared after 5 seconds",driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        driverWaitQuit(2);










    }
}
