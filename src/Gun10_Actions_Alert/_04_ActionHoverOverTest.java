package Gun10_Actions_Alert;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class _04_ActionHoverOverTest extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://www.etsy.com/");

        // 1- isDisplay ve isEnable gibi kontroller, element HTML nini içinde var fakat görünür değil.
        // durumunda kullanılır.
        // 2- BAZI durumlarda element HTML nini içinde hiç yoktur.

//        List<WebElement> cookiesAccept=driver.findElements(By.cssSelector("[data-gdpr-single-choice-accept='true']"));
//        if (cookiesAccept.size()>0) // varsa
//            cookiesAccept.get(0).click(); // tıkla-kapat     sayfa açılışında çıkabilecek uyar penceresi.
        //elementi bulamazsa implicitlyWait devreye girer ve verilen süre kadar bulmaya çalışır. Biz 30 sn ayarladık.


        WebElement jeweleryMenu = driver.findElement(By.id("catnav-primary-link-10855"));
        WebElement necklaces = driver.findElement(By.id("side-nav-category-link-10873"));
        WebElement bibNecklaces = driver.findElement(By.id("catnav-l3-10881"));

        Actions actions = new Actions(driver);


        actions.moveToElement(jeweleryMenu).build().perform();
        MyFunc.Wait(2);
        actions.moveToElement(necklaces).build().perform();
        MyFunc.Wait(2);
        actions.moveToElement(bibNecklaces).click().build().perform();
        MyFunc.Wait(2);

        Assert.assertTrue("URL de bib geçmiyor",driver.getCurrentUrl().contains("bib")); // mevcut sayfanın URL sini veriyor.



        MyFunc.Wait(1);

        driverWaitQuit(2);
    }
}
