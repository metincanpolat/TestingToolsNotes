package Gun09_Statu_ActionsClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _04_ActionClickTest extends BaseDriver {

    @Test
    public void Test1(){
        driver.get("https://demoqa.com/buttons");

        WebElement element= driver.findElement(By.xpath("//button[text()='Click Me']"));
        //element.click();

        Actions aksiyonlar=new Actions(driver); //1
        System.out.println("aksiyon öncesi tüm aksiyonları çalıştıracağımız ana Aksiyonlar sınıfı oluşturuldu");

        Action clickAction=aksiyonlar.moveToElement(element).click().build();
              //elementin üzerine gidildi, Click aksiyonu hazırda bekliyor, henüz click olmadı.
        System.out.println("Aksiyon hazırlandı");

        MyFunc.Wait(2);
        clickAction.perform(); // aksiyonu gerçekleştir.
        System.out.println("Aksiyon gerçekleşti");

        //aksiyonlar.moveToElement(element).click().build().perform(); // kısa hali

        driverWaitQuit(2);
    }
}
