package Gun04;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _01_OpeningWebsite {
    public static void main(String[] args) {


        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // web sayfasını kontrol eden görevli
        driver.get("https://www.techno.study/"); // web sayfasını aç

        MyFunc.Wait(5);
        driver.quit();
    }
}
