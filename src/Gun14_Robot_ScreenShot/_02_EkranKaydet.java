package Gun14_Robot_ScreenShot;

import Utility.BaseDriver;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.List;

public class _02_EkranKaydet extends BaseDriver {
    @Test
    public void Test1() throws IOException {

        driver.get("https://opensource-demo.orangehrmlive.com/");



        WebElement name=driver.findElement(By.name("username"));
        name.sendKeys("admin");
        WebElement pass= driver.findElement(By.name("password"));
        pass.sendKeys("123");//invalid pass
        WebElement submit= driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        List<WebElement> hataMesaji=driver.findElements(By.cssSelector("div[role='alert']"));
        if (hataMesaji.size()>0){
            System.out.println("Login olamadı, Hata mesajı gözüktü");

            TakesScreenshot ts=(TakesScreenshot) driver; // 1:Aşama ekran görüntüsü alma değişkenini tanımladım
            File hafizadakiHali=ts.getScreenshotAs(OutputType.FILE); //2.Aşama ekran görüntüsü alındı, şuan hafızada.birer bilgi kümeleri Ham halleri.

            LocalDateTime dt=LocalDateTime.now();
            String dateTimeSrg=dt.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT));
            dateTimeSrg=dateTimeSrg.replace(" ","-").replace(".","_").replace(":","_");

            FileUtils.copyFile(hafizadakiHali,new File("ekranGoruntuleri\\screenshot_"+dateTimeSrg+".png"));                                                            // Burada çıkan BASE64 ve BYTES database için kullanılabilecek

            //Burada aynı dosya ismi ile tekrar üzerine kaydetmesin diye tarih saat bilgisini isme eklememiz gerekiyor.
        }


        driverWaitQuit(2);




    }
}
