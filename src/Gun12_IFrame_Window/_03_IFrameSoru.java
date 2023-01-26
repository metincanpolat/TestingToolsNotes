package Gun12_IFrame_Window;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _03_IFrameSoru extends BaseDriver {
    /*
   1-driver.get("http://chercher.tech/practice/frames); sayfasına gidiniz.
   2-Inputa ülke adı yazınız
   3-CheckBox ı çekleyiniz.
   4-Select in 4.elemanını seçiniz.
 */
    @Test
    public void Test1() {
        driver.get("http://chercher.tech/practice/frames");

        driver.switchTo().frame(0);
        WebElement input= driver.findElement(By.cssSelector("#topic+input"));

        input.sendKeys("Türkiye");

        driver.switchTo().frame(0).findElement(By.id("a")).click();
        driver.switchTo().defaultContent().switchTo().frame(1);

        WebElement animals= driver.findElement(By.id("animals"));
        Select dropDownAnimal=new Select(animals);

        dropDownAnimal.selectByIndex(3);

        driverWaitQuit(2);






    }
}
