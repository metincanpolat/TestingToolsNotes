package Gun10_Actions_Alert;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _05_IntroAlert extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("http://demo.seleniumeasy.com/javascript-alert-box-demo.html");

        WebElement clickMe1= driver.findElement(By.cssSelector("button[class='btn btn-default']")); // css de class isminde boşluk varsa sıkıntı yok.
        clickMe1.click();

        MyFunc.Wait(2);

        driver.switchTo().alert().accept(); // Alert kutucuğunu onaylandı. Dismiss cancel demek, bir de gettext ve sendkeys var.

        driverWaitQuit(3);

        /*
      Interview sorusu
      - Alertleri nasıl kullanırsın ?

      driver.switch().alert() bunula kullanırım.

      komutları;
      accept -> OK, TAMAM butonuna basmamızı sağlıyor.
      dismiss -> CANCEL, HAYIR yani olumsuz butonuna basmamızı sağlıyor.
      gettext -> alertin mesajını alıyoruz.
      SendKeys -> prompt(Alertin giriş kutusu olan hali) , yazı gönderiyoruz.
 */
    }
}
