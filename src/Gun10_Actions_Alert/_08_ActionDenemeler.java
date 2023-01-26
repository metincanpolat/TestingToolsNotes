package Gun10_Actions_Alert;

import Utility.BaseDriver;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class _08_ActionDenemeler extends BaseDriver {

    Actions actions=new Actions(driver);

    @Test
    public void denemeTest(){

        driver.get("https://www.browserstack.com/");

//        WebElement search = driver.findElement(By.xpath("(//button[@aria-label='Search'])[2]"));
//        actions.click(search).perform();
//
//        WebElement input = driver.findElement(By.xpath("(//input[@type='search'])[1]"));
//        actions.sendKeys(input, "Merhaba").moveToElement(input)
//                .sendKeys(" Merhaba")
//                .keyDown(Keys.getKeyFromUnicode('\uE03D'))
//                .sendKeys("A")
//                .keyUp(Keys.getKeyFromUnicode('\uE03D'))
//                .keyDown(Keys.DELETE)
//                .keyUp(Keys.DELETE)
//                .perform();

        actions.pause(Duration.ofSeconds(6)).perform();
        actions.scrollByAmount(0,1500).perform();




    }
}
