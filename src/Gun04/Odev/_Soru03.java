package Gun04.Odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _Soru03 {
    public static void main(String[] args) {
        //1) Bu siteye gidin. -> https://www.snapdeal.com/
        //2) "teddy bear" aratın ve  Search butonuna tıklayın.
        //3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
        //Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.snapdeal.com/");

        WebElement seachBox=driver.findElement(By.id("inputValEnter"));
        String aranacak="canpolat";
        seachBox.sendKeys(aranacak);
        WebElement searchButton=driver.findElement(By.className("searchTextSpan"));
        searchButton.click();
        WebElement searchResult= driver.findElement(By.id("searchMessageContainer"));
        if (searchResult.getText().contains("We've got")&&searchResult.getText().contains("results for "+aranacak))
            System.out.println("true");





    }
}
