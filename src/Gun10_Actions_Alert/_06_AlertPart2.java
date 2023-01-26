package Gun10_Actions_Alert;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _06_AlertPart2 extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

        WebElement clickMe2 = driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']"));
        clickMe2.click();

        MyFunc.Wait(2);
        driver.switchTo().alert().dismiss(); // Alert kutucuğuna geçildi ve CANCEL(iptal) butonuna basıldı.

        driverWaitQuit(3);
    }
}
