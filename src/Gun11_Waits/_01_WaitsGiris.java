package Gun11_Waits;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class _01_WaitsGiris extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");

        WebElement button=driver.findElement(By.xpath("//*[text()='Click me to start timer']"));
        button.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); // ideal kullanım 30 sn
        // girdiğimiz değerden daha önce işlem gerçekleşirse beklemeyi bırakıp devam ediyor.

        //MyFunc.Wait(120); // bu sistemi tamamen durdurduğu için kullanılmıyor. Girdiğimiz süre ihtiyaçtan fazla ise beklemeye devam ediyor.

        WebElement txtElement=driver.findElement(By.xpath("//p[text()='WebDriver']"));

        driverWaitQuit(1);

        /*
    Selenium Bekletme Konusu
    Thread.Sleep : bu selenium a özel değil, java ya ait yazılımın herhangi bir yerinde verilen süre kadar bekler.

    Implicitly Wait :
    Tüm sayfadaki elemanlar için bir bekleme süresi atanıyor.Ancak eleman bulunduğu anda daha fazla beklemiyor.
    Bütüm elemanlar için geçerli.NoSuchElement hatası nı vermek için verilen süre kadar,  eleman bulunana kadar bekler.

      driver.manage().timeouts().implicitlyWait(dr);


    pageLoadTimeout :
      driver.manage().timeouts().pageLoadTimeout(dr);
      30 sn süresinde sayfanın yüklenmesini bekliyor, bu süreden sonra timeout düşerek hata verir.
 */

    }
}
