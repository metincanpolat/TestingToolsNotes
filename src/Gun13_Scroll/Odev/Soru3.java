package Gun13_Scroll.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

public class Soru3 extends BaseDriver {
    //Senaryo
    //1- google.com ile sayfayı açınız.
    //2- Daha sonra Yeni bir TAB (ctrl+T) açınız.
    //3- Bu açılan yeni sayfada facebook.com u açınız.
    //4- Bu sayfanın açıldığını URL sinden kontrol ediniz.
    //5- Daha sonra facebook.com sayfasını kapatınız.

    @Test
    public void Test() throws AWTException {

        driver.get("https://google.com");

        Robot rbt=new Robot();

        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_T);
        rbt.keyRelease(KeyEvent.VK_T);
        rbt.keyRelease(KeyEvent.VK_CONTROL);

        StringSelection selection = new StringSelection("https://facebook.com");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        MyFunc.Wait(2);
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_V);
        rbt.keyRelease(KeyEvent.VK_V);
        rbt.keyRelease(KeyEvent.VK_CONTROL);

        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        Set<String> windowIdler=driver.getWindowHandles();

        System.out.println(windowIdler.size());

//        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
//        driver.switchTo().window(tabs2.get(1));
//        driver.close();
//        driver.switchTo().window(tabs2.get(0));


        for (String id : windowIdler) {
            driver.switchTo().window(id);
        }

        waitAWhile.until(ExpectedConditions.urlContains("facebook"));
        Assert.assertEquals("https://www.facebook.com/",driver.getCurrentUrl());

        driverWaitQuit(2);










    }
}
//driver.get("https://www.google.com");
//        driver.switchTo().newWindow(WindowType.TAB);  WINDOW yazınca yeni pencere olarak açıyor.
//        driver.get("https://www.facebook.com/");
//        Assert.assertTrue(driver.getCurrentUrl().contains("face"));
//        driver.close();