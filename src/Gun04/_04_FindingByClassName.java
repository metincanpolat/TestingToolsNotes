package Gun04;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class _04_FindingByClassName {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // web sayfasını kontrol eden görevli
        driver.get("https://form.jotform.com/221934510376353"); // web sayfasını aç

        //WebElement submitButton=driver.findElement(By.className("form-submit-button")); // Arama yaparken başına . koyarsan sadece class larda arar.(#gibi)
       // submitButton.click();

        // Chrome ctrl+f ye basıldığında inspect bölümünde
        // first_name yazarsak bütün kelimelerde arar
        // #first_name yazarsak bütün ID paramtrelerinde arar
        // .first_name yazarsak bütün CLASS paramatrelerinde arar

        // birden fazla aynı locator a sahip eleman bulursa findElement ne yapar?
        // cevap : ilk element i bulur.
        WebElement element=driver.findElement(By.className("form-sub-label"));
        System.out.println("element.getText() = " + element.getText());

        // Bu locator a ait elemanların hepsini nasıl alırım?
        List<WebElement> labellar=driver.findElements(By.className("form-sub-label"));
        System.out.println("labellar.size() = " + labellar.size());
        for (WebElement e : labellar)
            System.out.println("e.getText() = " + e.getText());

        // aranan eleman bulunamazsa;
        // findElement, NoSuchElement hatası verir
        // findElements, size ı 0 olan bir liste verir, hata vermez. En önemli farkları bu.



        MyFunc.Wait(5);
        driver.quit();
    }
}
