package Gun07_XPath.Odev;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru03 extends BaseDriver {
    //1) Bu siteye gidin. -> https://www.snapdeal.com/
    //2) "teddy bear" aratın ve  Search butonuna tıklayın.
    //3) Bu yazının göründüğünü doğrulayınız. -> (We've got 297 results for 'teddy bear')
    //Not: Bu yazıdaki sayı değişiklik gösterebilir. Önemli olan cümle kalıbı.

    @Test
    public void Test1(){

        driver.get("https://www.snapdeal.com/");

        WebElement seachBox=driver.findElement(By.xpath("//input[@id='inputValEnter']"));
        String aranacak="teddy bear";
        seachBox.sendKeys(aranacak);
        WebElement searchButton=driver.findElement(By.xpath("//span[@class='searchTextSpan']"));
        searchButton.click();
        WebElement searchResult= driver.findElement(By.xpath("//div[@id='searchMessageContainer']/descendant::span"));
        Assert.assertTrue("Text doğrulanmadı",searchResult.getText().contains("We've got")&&searchResult.getText().contains("results for "+aranacak));

        driverWaitQuit(2);
    }
}
