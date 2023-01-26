package Gun13_Scroll;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class _03_ScrollToWebElement extends BaseDriver {

    @Test
    public void Test1() {

        driver.get("https://triplebyte.com/");
        MyFunc.Wait(2);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("(//*[text()='Get a demo'])[5]"));

        // scroll u bir elemente kadar, yani o pencere içinde gözükene kadar nasıl kaydırırım.
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        js.executeScript("window.scrollBy(0,-500)"); //sayfa yukarıdaki line ı görmediği için biraz yukarıya aldık.

//        WebDriverWait waitAWhile=new WebDriverWait(driver, Duration.ofSeconds(30));
//        waitAWhile.until(ExpectedConditions.visibilityOf(element));
        MyFunc.Wait(5);

        //js.executeScript("arguments[0].click();",element);
        //veya
        element.click();

        driverWaitQuit(2);

    }
}