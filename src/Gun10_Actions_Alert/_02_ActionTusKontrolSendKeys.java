package Gun10_Actions_Alert;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _02_ActionTusKontrolSendKeys extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://demoqa.com/auto-complete");

        WebElement element= driver.findElement(By.id("autoCompleteSingleInput"));

        Actions actions=new Actions(driver);

        Action action=actions.moveToElement(element) // kutucuğa git
                .click() // içine tıklat
                .keyDown(Keys.SHIFT) // shift bas
                .sendKeys("a") // a yaz
                .keyUp(Keys.SHIFT) // shift i bırak
                .sendKeys("hmet") //hmet yaz
                .build();
        MyFunc.Wait(2);
        action.perform();

        driverWaitQuit(2);








    }



}
