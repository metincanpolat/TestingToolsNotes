package Gun05_Navigate_Finding_GetCSS;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _01_FindingElements_tag {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // web sayfasını kontrol eden görevli
        driver.get("https://www.hepsiburada.com/"); // web sayfasını aç

        List<WebElement> linkler = driver.findElements(By.tagName("a")); // tag ine göre bulma (ul,img,input,...)
        // bu bana sayfadaki tüm linkleri verir.

        for (WebElement e : linkler){
            if (e.getText().equals("")) // kırık link yani ekranda görünen kısmı yok.HTML ye birşeyler yazılmış ama metin yazılmamış
                                         // o yüzden ekranda gözükmüyor.
            {
                System.out.println("e.getAttribute(\"href\") = " + e.getAttribute("href"));
                System.out.println("e.getAttribute(\"href\") = " + e.getAttribute("title"));
                System.out.println("e.getAttribute(\"href\") = " + e.getAttribute("rel"));
            }
        }

        MyFunc.Wait(5);
        driver.quit();
    }
}
