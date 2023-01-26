package Gun08_SelectClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class deneme1 extends BaseDriver {
    @Test
    public void Test4(){

        driver.get("https://www.facebook.com/");

        WebElement newAccountBut= driver.findElement(By.xpath("//a[contains(@data-testid,'open-registration')]"));
        newAccountBut.click();
        MyFunc.Wait(1);

        WebElement sex= driver.findElement(By.cssSelector("input[value='2'][name='sex']"));
        System.out.println("sex.tagname = " + sex.getTagName());
        System.out.println("sex.getAccessibleName() = " + sex.getAccessibleName());
        System.out.println("sex.getAttribute() = " + sex.getAttribute("label"));
    }
    
}
