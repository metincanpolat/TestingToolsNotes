package Gun14_Robot_ScreenShot;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _01_RobotFileUpload2 extends BaseDriver {

    @Test
    public void Test1() { //CTRL+S dediğimiz zaman sayfanın HTML kodunu kaydediyoruz.

        driver.get("http://demo.guru99.com/test/upload/");

        WebElement input=driver.findElement(By.id("uploadfile_0"));
        input.sendKeys("C:\\Users\\canpo\\Downloads\\TechnoStudyUserStories.xlsx");

        MyFunc.Wait(2);
        WebElement submitBut= driver.findElement(By.id("submitbutton"));
        submitBut.click();

        WebDriverWait waitAWhile=new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement uploadMessage=waitAWhile.until(ExpectedConditions.visibilityOfElementLocated(By.id("res"))); // burada hem bekliyor hem de atama yapıyor.

        Assert.assertTrue(uploadMessage.getText().contains("has been successfully uploaded.")); // beklentiyi yazdırıyoruz

        driverWaitQuit(2);

    }

}
