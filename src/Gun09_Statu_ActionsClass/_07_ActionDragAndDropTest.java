package Gun09_Statu_ActionsClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _07_ActionDragAndDropTest extends BaseDriver {

    @Test
    public void Test1() {
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement oslo= driver.findElement(By.id("box1"));
        WebElement norway= driver.findElement(By.id("box101"));

        MyFunc.Wait(2);
        //1.Yöntem

        Actions aksiyonlar=new Actions(driver);
        Action aksiyon=aksiyonlar.dragAndDrop(oslo,norway).build();
        aksiyon.perform();


        //2.Yöntem

        WebElement seul= driver.findElement(By.id("box5"));
        WebElement korea= driver.findElement(By.id("box105"));
        aksiyon=aksiyonlar.clickAndHold(seul).build();
        aksiyon.perform(); // sürüklenecek elementi mouse ile tuttum
        //new Actions(driver).clickAndHold(seul).build().perform();  //kısa yol

        aksiyon=aksiyonlar.moveToElement(korea).release().build();
        aksiyon.perform(); // hedefe götür ve bırak
       //new Actions(driver).clickAndHold(seul).build().perform(); // kısa yol

        System.out.println("seul = " + seul.getCssValue("background-color"));




        //new Actions(driver).clickAndHold(seul).release(korea).build().perform(); // en kısa hali



        driverWaitQuit(5);




    }




}
