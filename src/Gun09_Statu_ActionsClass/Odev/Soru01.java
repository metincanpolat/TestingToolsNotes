package Gun09_Statu_ActionsClass.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Soru01 extends BaseDriver {
    //http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html
    //buradaki ülke ve şehirleri findElements ile topluca bularak bir döngü ile bütün şehirleri doğru ülkere dağıtınız.

    @Test
    public void Test1() {
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");

        List<WebElement> capitals= driver.findElements(By.cssSelector("div[id=answerDiv]>[id^='a']"));
        List<WebElement> countries= driver.findElements(By.cssSelector("[id='questionDiv']>div[class='destinationBox']"));

        Actions actions=new Actions(driver);

        MyFunc.Wait(2);

        for (WebElement e : capitals) {
            for (WebElement j : countries) {
                actions.clickAndHold(e).build().perform();
                MyFunc.Wait(1);
                actions.moveToElement(j).release().build().perform();
                if (e.getAttribute("class").equals("correctAnswer")) {
                    countries.remove(j);
                    break;
                }

            }
        }
            // 2.ÇÖZÜM
//        for (int i = 0; i < capitals.size(); i++) {
//            for (int j = 0; j < capitals.size(); j++) {
//                actions.clickAndHold(capitals.get(i)).build().perform();
//                MyFunc.Wait(1);
//                actions.moveToElement(countries.get(j)).release().build().perform();
//                if (capitals.get(i).getAttribute("class").equals("correctAnswer"))break;
//            }
//        }




        //driverWaitQuit(2);




    }
}
