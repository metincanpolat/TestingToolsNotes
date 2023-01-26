package Gun05_Navigate_Finding_GetCSS;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _03_GetCssValue extends BaseDriver {
    public static void main(String[] args) {

        driver.get("https://www.snapdeal.com/");
        WebElement inputValEnter = driver.findElement(By.id("inputValEnter"));

        //HTML kodlarını kopyalamak için sağ tuş Edit as HTML yapıyoruz.

        // Class ın karşılığı olan CSS değerlerini almak için getCSSValue kulanılır
        System.out.println("inputValEnter.getCssValue(\"color\") = " + inputValEnter.getCssValue("color"));
        System.out.println("inputValEnter.getCssValue(\"background\") = " + inputValEnter.getCssValue("background"));
        System.out.println("inputValEnter.getCssValue(\"font-size\") = " + inputValEnter.getCssValue("font-size"));

        driverWaitQuit(2);





    }
}
