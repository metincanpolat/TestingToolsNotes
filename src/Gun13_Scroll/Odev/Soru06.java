package Gun13_Scroll.Odev;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Soru06 extends BaseDriver {
    //Senaryo
    //https://demoqa.com/dynamic-properties adresine gidin
    //1) “Visible After 5 seconds” butonunun gorunur olmasini bekleyin
    //2) “Visible After 5 seconds” butonunun gorunur oldugunu test edin

    @Test
    public void Test1(){

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement button= waitAWhile.until(ExpectedConditions.visibilityOfElementLocated((By.id("visibleAfter"))));

        Assert.assertTrue(button.isDisplayed());

        driverWaitQuit(2);







    }
}
