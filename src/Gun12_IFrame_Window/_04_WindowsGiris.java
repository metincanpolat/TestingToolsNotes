package Gun12_IFrame_Window;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _04_WindowsGiris extends BaseDriver {
    @Test
    public void Test1() {
        driver.get("https://www.selenium.dev/");

        // a tag lerinde target="_blank" varsa bu onun başka sekmede açılacağını söylüyor.
        // a[target='blank'] bu şekilde ayrı sayfada açılan linkleri bulmuş oluyoruz.

        List<WebElement> links=driver.findElements(By.cssSelector("a[target='_blank']"));

//        for (WebElement l : links)
//            if (!l.getAttribute("href").contains("mailto")) // mail sayfası haricindekileri aç
//                l.click();

        //driver.getWindowHandle() -> aktif olan tab(window) un id sini verir.
        Set<String> windowID=driver.getWindowHandles(); // açık olan tüm sayfaların win ID lerini verir

        for (String id : windowID)
            System.out.println("id= " + id);

        driverWaitQuit(2);





    }
}
