package Gun12_IFrame_Window;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_IFrameGiris extends BaseDriver {

    //<html>
    //<head></head>
    //
    //<body>
    //
    //  ...
    //  ...
    //  <iframe id="frame1"  ... >
    //     <iframe id="frame3"  ... ></iframe>
    //  </iframe>
    //
    //  <iframe id="frame2"  ... ></iframe>
    //
    //</body>
    //</html>

    @Test
    public void Test1() {

        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0); // "frame1" id ve name ve webElement ile geçiş çok yavaş tercih etmiyoruz.
        WebElement input= driver.findElement(By.cssSelector("#topic+input"));

        input.sendKeys("Türkiye");

        // şu anda frame1 ile gösterilen sayfadayız, diğer frame2 veya frame3 veya ilk sayfadaki
        // locator ları bulamayız, çünkü driver şu anda frame1 simli sayfayı DRIVE etmekte.

        //driver.switchTo().frame(0); --> içteki frame3 e geçiş olur.
        //driver.switchTo().parentFrame(); --> bir önceki sayfaya geri dönerim
        //driver.switchTo().defaultContent(); --> hangi sayfada olursan ol ana sayfaya dönüş


        driverWaitQuit(2);

    }
}
