package Gun12_IFrame_Window;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _02_IFramelerGecis extends BaseDriver {
    /*
   Senaryo :
   https://chercher.tech/practice/frames sitesine gidiniz
   Ekranda gözüken ilk kutucuğa Türkiye yazınız.
   Daha sonra select in seçeneklerinden animals ı seçiniz.
 */


    @Test
    public void Test1() {
        driver.get("https://chercher.tech/practice/frames");

        driver.switchTo().frame(0);
        WebElement input= driver.findElement(By.cssSelector("#topic+input"));

        input.sendKeys("Türkiye");

        //driver.switchTo().parentFrame(); // 1 kademe içeride olduğundan yine default page e ulaşıyor.
        //driver.switchTo().defaultContent(); // default page yani asıl giriş sayfasına ulaştım, aynı şekilde
        //driver.switchTo().frame(1); // ana sayfadaki 2.frame(index olarak 1) ulaşıldı. Burası select in olduğu yer

        driver.switchTo().defaultContent().switchTo().frame(1); // en kısa hali ikisi bir arada

        WebElement animals= driver.findElement(By.id("animals"));

        Select dropDownAnimal=new Select(animals);

        dropDownAnimal.selectByValue("avatar");
        //dropDownAnimal.selectByVisibleText("Avatar");// Alternatif bulma şekli.

        driverWaitQuit(2);






    }
}
