import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class deneme  extends BaseDriver{

    @Test

    public void  Test1(){

        driver.get("https://demoqa.com/text-box");

        WebElement username=driver.findElement(By.id("userName"));
        username.sendKeys("canpolat");
//        WebElement username1=driver.findElement(By.name("metin"));
//        WebElement username2=driver.findElement(By.className("canpolat")); // id #     class .
//        WebElement username3=driver.findElement(By.linkText("No Content"));


//        WebElement name=driver.findElement(By.id("userName-label"));
//        System.out.println(name.getText());
//
//        WebElement button=driver.findElement(By.id("submit"));
//        MyFunc.Wait(5);

//        button.click();

//        System.out.println(button.getAttribute("type"));

        List<WebElement> liste=driver.findElements(By.tagName("a"));
        System.out.println("liste.size() = " + liste.size());

        for (int i = 0; i < liste.size(); i++) {
                if (liste.get(i).getText().equals("")){
            System.out.println(i+" nci"+liste.get(i).getAttribute("href"));
            System.out.println(i+" nci"+liste.get(i).getAttribute("title"));
            System.out.println(i+" nci"+liste.get(i).getAttribute("rel"));}
        }



//        driver.navigate().to("https://www.youtube.com/");
//
//        MyFunc.Wait(2);
//
//        driver.navigate().back();

        driverWaitQuit(2);








    }





}
