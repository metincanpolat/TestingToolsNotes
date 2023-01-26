package Gun13_Scroll.Odev;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class Soru07 extends BaseDriver {

    //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin
    //1) “Add Element” butona basin
    //2) “Delete” butonu gorunur oluncaya kadar bekleyin
    //3) “Delete” butonunun gorunur oldugunu test edin
    //4) Delete butonuna basarak butonu silin
    //5) Delete butonunun gorunmedigini test edin

    @Test
    public void Test1() {

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        WebElement addElement= driver.findElement(By.xpath("//button[text()='Add Element']"));
        addElement.click();

        WebElement delete= driver.findElement(By.xpath("//button[text()='Delete']"));

        waitAWhile.until(ExpectedConditions.visibilityOf(delete));

        Assert.assertTrue(delete.isDisplayed());

        delete.click();

        //waitAWhile.until(ExpectedConditions.invisibilityOf(delete));

        List<WebElement> list=driver.findElements(By.xpath("//button[text()='Delete']"));

        if (list.size()==0)
            System.out.println("Delete butonu görünmüyor");
        else System.out.println("Delete butonu görünüyor");

        driverWaitQuit(2);





    }
}
