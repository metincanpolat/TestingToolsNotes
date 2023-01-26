package Gun09_Statu_ActionsClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class _07_ActionDragAndDropTestSoru extends BaseDriver {
    @Test
    public void Test1(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        List<WebElement> capitals= driver.findElements(By.xpath("//div[@class='dragableBox'][contains(@id,'box')]"));
        List<WebElement> countries= driver.findElements(By.xpath("//div[@class='dragableBoxRight'][contains(@id,'box')]"));

        Actions actions=new Actions(driver);

        MyFunc.Wait(2);
        for (WebElement e : capitals) {
            for (WebElement j : countries) {
                actions.clickAndHold(e).moveToElement(j).release().build().perform();
                if (e.getCssValue("background-color").equals("rgba(0, 255, 0, 1)")) {
                    countries.remove(j);
                    break;
                }
            }
        }
        // 2.ÇÖZÜM
//        for (int i = 0; i < capitals.size(); i++) {
//            for (int j = 0; j < countries.size(); j++) {
//                actions.clickAndHold(capitals.get(i)).moveToElement(countries.get(j)).release().build().perform();
//                if (capitals.get(i).getCssValue("background-color").equals("rgba(0, 255, 0, 1)")) {
//                    countries.remove(j);break;
//                }
//            }
//        }

        // 3.ÇÖZÜM
//        for (WebElement capital : capitals) {
//            for (int j = 0; j < countries.size(); j++) {
//                actions.clickAndHold(capital).moveToElement(countries.get(j)).release().build().perform();
//                if (capital.getCssValue("background-color").equals("rgba(0, 255, 0, 1)")) {
//                    countries.remove(j);
//                    break;
//                }
//            }
//        }


        driverWaitQuit(3);

        new Actions(driver).pause(Duration.ofSeconds(2));


    }
}
