package Gun06_CssSelector.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru06 extends BaseDriver {
    //Bu siteye gidiniz.  https://testpages.herokuapp.com/styled/index.html
    //Fake Alerts'e tıklayınız.
    //Show modal dialog buttonuna tıklayınız.
    //Ok'a tıklayınız.
    //Alert kapanmalıdır.

    @Test
    public void Test1(){

        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Wait(2);
        WebElement fakeAlertsButton=driver.findElement(By.cssSelector("#fakealerttest"));
        fakeAlertsButton.click();
        MyFunc.Wait(2);
        WebElement ShowModalDialogBut=driver.findElement(By.cssSelector("#modaldialog"));
        ShowModalDialogBut.click();
        MyFunc.Wait(2);
        WebElement OKbutton=driver.findElement(By.cssSelector(".dialog-actions>button"));
        OKbutton.click();


        driverWaitQuit(3);
    }
}
