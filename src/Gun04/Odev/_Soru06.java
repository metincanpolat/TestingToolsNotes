package Gun04.Odev;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _Soru06 {
    public static void main(String[] args) {
        //Bu siteye gidiniz.  https://testpages.herokuapp.com/styled/index.html
        //Fake Alerts'e tıklayınız.
        //Show modal dialog buttonuna tıklayınız.
        //Ok'a tıklayınız.
        //Alert kapanmalıdır.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Wait(2);
        WebElement FakeAlertsButton=driver.findElement(By.id("fakealerttest"));
        FakeAlertsButton.click();
        MyFunc.Wait(2);
        WebElement ShowAlertBox=driver.findElement(By.id("fakealert"));
        ShowAlertBox.click();
        MyFunc.Wait(2);
        WebElement OKbutton=driver.findElement(By.id("dialog-ok"));
        OKbutton.click();


        MyFunc.Wait(3);
        driver.quit();
    }
}
