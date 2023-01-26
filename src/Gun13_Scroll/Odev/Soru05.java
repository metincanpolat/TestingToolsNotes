package Gun13_Scroll.Odev;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Soru05 extends BaseDriver {
    //1) https://demoqa.com/dynamic-properties adresine gidin
    //2) “Will enable 5 seconds” butonunun enable olmasini bekleyin
    //3) “Will enable 5 seconds” butonunun enable oldugunu test edin

    @Test
    public void Test1(){

        driver.get("https://demoqa.com/dynamic-properties");

        WebElement button= driver.findElement(By.id("enableAfter"));

        waitAWhile.until(ExpectedConditions.elementToBeClickable(button));

        Assert.assertTrue(button.isEnabled());

        driverWaitQuit(2);


    }
}
