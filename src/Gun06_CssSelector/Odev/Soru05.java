package Gun06_CssSelector.Odev;

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
        WebElement fakeAlertsButton=driver.findElement(By.cssSelector("#fakealerttest"));
        fakeAlertsButton.click();
        MyFunc.Wait(2);
        WebElement ShowAlertBox=driver.findElement(By.cssSelector(".styled-click-button#fakealert"));
        ShowAlertBox.click();
        MyFunc.Wait(2);
        WebElement OKbutton=driver.findElement(By.cssSelector(".dialog-actions>button"));
        OKbutton.click();


        driverWaitQuit(3);
    }
}
