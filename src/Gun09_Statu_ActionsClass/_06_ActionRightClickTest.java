package Gun09_Statu_ActionsClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _06_ActionRightClickTest extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("https://demoqa.com/buttons");

        WebElement element= driver.findElement(By.id("rightClickBtn"));
        MyFunc.Wait(2);

        Actions aksiyonlar=new Actions(driver); // sınıf oluşturma
        Action aksiyon=aksiyonlar.moveToElement(element).contextClick().build();
        aksiyon.perform();

        MyFunc.Wait(2);

        //aksiyonlar.contextClick(element).build().perform();

        driverWaitQuit(2);

    }
}
