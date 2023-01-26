package Gun10_Actions_Alert;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _07_AlertPart3 extends BaseDriver {
    // 3.Alerte tıklayınız, isminizi alert e yazınız, daha sonra OK ye basıp,
    // HTML sayfasında isminizin görüntülendiğini Assert ile kontrol ediniz.
    @Test
    public void Test1() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

        WebElement clickMe3 = driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']"));
        clickMe3.click();

        MyFunc.Wait(2);
        driver.switchTo().alert().sendKeys("Metin");
        driver.switchTo().alert().accept();

        MyFunc.Wait(2);

        WebElement checkText=driver.findElement(By.id("prompt-demo"));

        Assert.assertTrue("Text Eşleşmedi",checkText.getText().contains("Metin"));

        driverWaitQuit(3);


    }
}
