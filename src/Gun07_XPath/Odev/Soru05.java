package Gun07_XPath.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru05 extends BaseDriver {
    //Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]
    //Fake Alerts' tıklayınız
    //Show Alert Box'a tıklayınız.
    //Ok'a tıklayınız.
    //Alert kapanmalıdır.

    @Test
    public void Test1(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Wait(2);
        WebElement fakeAlertsButton=driver.findElement(By.xpath("//a[.='Fake Alerts']"));
        fakeAlertsButton.click();
        MyFunc.Wait(2);
        WebElement ShowAlertBox=driver.findElement(By.xpath("//input[@onclick='show_alert()']"));
        ShowAlertBox.click();
        MyFunc.Wait(2);
        WebElement OKbutton=driver.findElement(By.xpath("//button[@class='dialog-button']"));
        OKbutton.click();


        driverWaitQuit(3);
    }
}
