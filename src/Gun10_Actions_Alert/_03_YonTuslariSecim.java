package Gun10_Actions_Alert;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _03_YonTuslariSecim extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("https://demoqa.com/auto-complete");

        WebElement element= driver.findElement(By.id("autoCompleteSingleInput"));
        Actions actions=new Actions(driver);

        Action action=actions.moveToElement(element)
                .click()
                .sendKeys("b")
                .build();
        action.perform();
                                            // Burada aşağı ok tuşuna basarak çıkmış dropdown menüden tavsiyelerden seçiyoruz.
        MyFunc.Wait(1);

        action=actions
                .sendKeys(Keys.DOWN) // her aşağıya inmek istediğimizde DOWN yapıyoruz. DropDown pencerelerde ilk basamak seçili olduğu için 2. sırada gözüken için bir kere DOWN gerekiyor.
                .sendKeys(Keys.ENTER)
                .build();
        action.perform();

        driverWaitQuit(2);





    }
}
