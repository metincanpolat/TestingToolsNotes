package Gun11_Waits;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class _03_FillingFormTask extends BaseDriver {
    /*
Bu siteye gidiniz.  http://demo.seleniumeasy.com/ajax-form-submit-demo.html
        Name giriniz.
        Comment giriniz.
        Submit'e tıklayınız.
        Form submited Successfully! yazısı görüntülenmelidir.
        assert ile kontrol ediniz
 */

    @Test
    public void Test1() {
        driver.get("http://demo.seleniumeasy.com/ajax-form-submit-demo.html");

        WebElement name = driver.findElement(By.cssSelector("[id='title']"));
        name.sendKeys("Metin");

        WebElement comment = driver.findElement(By.cssSelector("[id='description']"));
        comment.sendKeys("Selam");

        WebElement submitButton = driver.findElement(By.cssSelector("[id='btn-submit']"));
        submitButton.click();

        // bu locator daki elementin text i bu olana kadar bekle
        WebDriverWait bekle=new WebDriverWait(driver, Duration.ofSeconds(5));
        bekle.until(ExpectedConditions.textToBe(By.id("submit-control"),"Form submited Successfully!"));


        WebElement textControl = driver.findElement(By.cssSelector("[id='submit-control']"));

        Assert.assertEquals("Form submited Successfully!",textControl.getText());
        // Assert equals da önce istediğimiz mesajı sonra adresi yazıyoruz.



    }
}
