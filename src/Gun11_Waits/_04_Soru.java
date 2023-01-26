package Gun11_Waits;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _04_Soru extends BaseDriver {
    /*
Senaryo
1-  https://www.demoblaze.com/index.html  siteyi açınız.
2- Samsung galaxy s6  linkine tıklayınız.
3- Sepete ekleyiniz.
4- Daha Sonra PRODUCT STORE yazısına tıklatarak ana ekrana geri dönününz
 */

    @Test
    public void Test1() {
        driver.get("https://www.demoblaze.com/index.html");

        WebElement samsungS6= driver.findElement(By.linkText("Samsung galaxy s6"));// a taglerde linkText öncelikli.
        samsungS6.click();

        WebElement addToCart= driver.findElement(By.xpath("//a[@class='btn btn-success btn-lg']"));
        addToCart.click();

        WebDriverWait bekle=new WebDriverWait(driver, Duration.ofSeconds(5));
        bekle.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WebElement mainPage= driver.findElement(By.cssSelector("[id='nava']"));
        mainPage.click();

        driverWaitQuit(2);


    }
}
