package Gun10_Actions_Alert;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class _01_DragAndDropBy extends BaseDriver {
    // http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php
    // sürgüyü 200$ ve 400$ arasını gösterecek şekilde konumlandırınız


    @Test
    public void Test1() {
        driver.get("http://talkerscode.com/webtricks/demo/demo_price-range-slider-using-jquery-css-and-php.php");

        WebElement solSurgu=driver.findElement(By.xpath("//*[@id='slider-range']/span[1]"));
        System.out.println(solSurgu.getLocation());



        MyFunc.Wait(2);

        //Actions aksiyonlar=new Actions(driver);
        //Action aksiyon=aksiyonlar.dragAndDropBy(solSurgu,100,0).build(); // x yatay y dikey // sola gitmek için başına - koyuyoruz

        MyFunc.Wait(2);

        //aksiyon.perform();

        driverWaitQuit(2);






    }

}
