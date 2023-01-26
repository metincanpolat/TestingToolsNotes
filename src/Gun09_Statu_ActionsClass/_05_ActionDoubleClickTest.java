package Gun09_Statu_ActionsClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _05_ActionDoubleClickTest extends BaseDriver {
    @Test
    public void Test1(){

        driver.get("https://demoqa.com/buttons");

        WebElement element= driver.findElement(By.id("doubleClickBtn"));
        //element.click(); // normal tek click
        MyFunc.Wait(2);

        Actions actions=new Actions(driver);
        Action doubleClickAction=actions.moveToElement(element).doubleClick().build(); // doubleClick de içersine target element alabiliyor.
        doubleClickAction.perform();

        //new Actions(driver).doubleClick(element).build().perform(); // en kısa hali

        driverWaitQuit(2);




    }
}
