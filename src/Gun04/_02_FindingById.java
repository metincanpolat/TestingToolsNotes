package Gun04;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _02_FindingById {
    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // web sayfasını kontrol eden görevli
        driver.get("https://form.jotform.com/221934510376353"); // web sayfasını aç

        WebElement name= driver.findElement(By.id("first_8")); // elemanı bulma
        name.sendKeys("metin"); // kutucuklara yazı gönderme

        WebElement labelFirstName= driver.findElement(By.id("sublabel_8_first"));
        System.out.println(labelFirstName.getText()); // burada kutucuğun altındaki yazıyı aldık.

        WebElement surNameID=driver.findElement(By.id("last_8"));
        surNameID.sendKeys("canpolat");

        // ID yi bulduğumuzda # ile arama yaptırabiliriz. Aynısından başka kullanılmış mı diye buluyor. Varsa bu bir bug.






        MyFunc.Wait(5);
        driver.quit();


    }
}
