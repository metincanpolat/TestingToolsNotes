package Gun13_Scroll;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class _01_Scrollintro extends BaseDriver {
    /*
    Selenium da Sayfayı aşağı kaydırılması gereken durumlar vardır:
    Bunlar , sayfa kaydırıldıkça yüklenen elemanlar için

    Bu işlem javascript executer ile yapılır.Bu interface sayesinde
    sayfa kaydırma işlemi ve javascript komutları çalıştırılabilir
    sayfa üzerinde.

    js.executeScript("window.scrollBy(0,3000);");
    js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
    js.executeScript("arguments[0].scrollIntoView(true);", element);
    js.executeScript("arguments[0].click();",element);
 */

    @Test
    public void Test1(){

        driver.get("https://triplebyte.com/");

        MyFunc.Wait(2);

        JavascriptExecutor js=(JavascriptExecutor) driver; // javaScript komutlarını çalıştırmak için önce js değişkeni tamamlandı.

        js.executeScript("window.scrollBy(0,3000);"); // içerideki ; ikinci bir komu yazılmadığı sürece konulmasa da olur.
        // (0,3000) ->  (x,y) Sayfayı sağa x kadar ve aşağı y kadar kaydırır.
        // 3000 px kadar aşağıya kaydıracak

        MyFunc.Wait(2);
        js.executeScript("window.scrollBy(0,-3000);"); //  - yani yukarıya

        // scrollTo : Verilen pixele gider. Direk hedef.
        // scrollBy : Verilen kadar daha ileri gider. Bulunduğu noktadan baz alır. (append, ekleyerek)






        driverWaitQuit(3);



    }
}
