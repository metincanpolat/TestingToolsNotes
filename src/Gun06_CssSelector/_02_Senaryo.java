package Gun06_CssSelector;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_Senaryo extends BaseDriver {
    //1- https://formsmarts.com/form/yu?mode=h5 sitesini açın
    //2- Business i çekleyin.
    //3- discover XYZ ye tıklatın ve online Advertising i seçin
    //4- Every day i seçin
    //5- Good u seçin
    //6- using XYZ yi tıklatın ve 3.seçeneği seçin
    @Test
    public void Test1() {
        driver.get("https://formsmarts.com/form/yu?mode=h5");
        MyFunc.Wait(2);
        WebElement business= driver.findElement(By.cssSelector("#section_1>[role='radiogroup']>label>[value=Business]"));
        business.click();
        MyFunc.Wait(2);
        WebElement discover= driver.findElement(By.cssSelector("#section_1>select:nth-of-type(1)"));
        discover.click();
        MyFunc.Wait(2);
        WebElement onlineAd=driver.findElement(By.cssSelector("option[value='Online Advertising']"));
        onlineAd.click();
        MyFunc.Wait(2);
        WebElement everyday=driver.findElement(By.cssSelector("input[value='Every Day']"));
        everyday.click();
        MyFunc.Wait(2);
        WebElement good=driver.findElement(By.cssSelector("input[value='Good']"));
        good.click();
        MyFunc.Wait(2);
        WebElement usingXYZ=driver.findElement(By.cssSelector("#section_1>select:nth-of-type(2)"));
        usingXYZ.click();
        MyFunc.Wait(2);
        WebElement thirdSec=driver.findElement(By.cssSelector("option[value*='month or more']"));
        thirdSec.click();
        MyFunc.Wait(2);

        good.click(); // en son açılan dropdown ı kapatmak için kullandık. Boş bir yeri tıklamak gibi.

        driverWaitQuit(3);


    }




}
