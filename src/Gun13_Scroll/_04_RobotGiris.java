package Gun13_Scroll;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class _04_RobotGiris extends BaseDriver {

    @Test
    public void Test1() throws AWTException {

        driver.get("http://demo.guru99.com/test/upload/");

        Robot rbt=new Robot();

        for (int i = 0; i < 21; i++) {
            rbt.keyPress(KeyEvent.VK_TAB);
            rbt.keyRelease(KeyEvent.VK_TAB);
        }
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        // Bilgisayardaki dosyanın path ini kopyalayıp (shift+sağ tık), dosya adının olduğu yere yapıştırmamız gerekiyor bunun için
        // önce dosyanın path , yolunu hafızaya kopyalayıp, sonra ctrl+v ile açılan windows popup ın
        // dosya adı bölümüne yapıştırmamız gerekiyor.// hafızaya path i kopyaladık

        StringSelection selection = new StringSelection("C:\\Users\\canpo\\Downloads\\TechnoStudyUserStories.xlsx\\");
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);
        // Bu bize pc den bir dosya yolunu panoya kopyalamamıza veya bir string i kopyalamamıza yarıyor. Bu şekilde istediğimiz yere yapıştırabiliriz.

        MyFunc.Wait(2);

        //Burada CTRL+V yaptık
        rbt.keyPress(KeyEvent.VK_CONTROL);
        rbt.keyPress(KeyEvent.VK_V);
        rbt.keyRelease(KeyEvent.VK_CONTROL);
        rbt.keyRelease(KeyEvent.VK_V);

        //Enter a basarak popup ı kapattım
        rbt.keyPress(KeyEvent.VK_ENTER);
        rbt.keyRelease(KeyEvent.VK_ENTER);

        WebElement chcBox = driver.findElement(By.xpath("//*[@id='terms']"));
        chcBox.click();

        WebElement submitBut= driver.findElement(By.id("submitbutton"));
        submitBut.click();

        //butona basıldıktan sonra yazının çıkması süre alıyor, bu beklendi
        WebDriverWait waitAWhile=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadMessage=waitAWhile.until(ExpectedConditions.visibilityOfElementLocated(By.id("res"))); // burada hem bekliyor hem de atama yapıyor.

        Assert.assertTrue(uploadMessage.getText().contains("has been successfully uploaded.")); // beklentiyi yazdırıyoruz

        driverWaitQuit(2);


    }
}
