package Gun12_IFrame_Window;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

public class _05_WindowsSwitch extends BaseDriver {
    /*
    Senaryo:
    https://www.selenium.dev/ adresindeki ayrı tab da açılan linklere tıklatınız.
    Açılan bütün yeni tablardaki sayfaların title ve url lerini yazdırınız.
    Daha sonra ana sayfa ya dönününüz.
    ipucu : driver.switchTo().window(id) ile istenilen tab a geçiş yapılır
 */
    @Test
    public void Test1() {
        driver.get("https://www.selenium.dev/ ");

        String anasayfaWindowId= driver.getWindowHandle(); // bulunduğum sayfanın id sini aldık.
        System.out.println("anasayfaWindowId = " + anasayfaWindowId);




        List<WebElement> links=driver.findElements(By.cssSelector("a[target='_blank']"));

        for (WebElement l : links)
            if (!l.getAttribute("href").contains("mailto")) // mail adresi haricindekileri aç
                l.click();

        Set<String> windowIdler=driver.getWindowHandles(); //açık olan tüm sayfaların win id leri

        for (String id : windowIdler) {
            driver.switchTo().window(id); // diğer tab (window) a geçiş yaptık.
            System.out.println(id+" -Title = "+driver.getTitle()+" - URL: "+driver.getCurrentUrl());

        }
        driver.switchTo().window(anasayfaWindowId); // burada ana sayfaya geri döndük

        // şimdi de ana sayfa haricindekileri kapatacağız.
        for (String id : windowIdler) {
            if (id.equals(anasayfaWindowId))
                continue; // sadece bu adımı pass geçti, kendinden sonra gelenleri çalıştırmadı
            driver.switchTo().window(id);
            driver.close(); // sadece bulunduğum window u kapatır.
        }



        driverWaitQuit(2);

        







    }
}

// for (String id :windowIds){
//            driver.switchTo().window(id);
//            if (!driver.getWindowHandle().equals(mainId)){
//                driver.close();justWait(1); // ceyhun