package Gun09_Statu_ActionsClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _01_ElemaninStatusu extends BaseDriver {
    public static void main(String[] args) {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");

        WebElement sali= driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));
        WebElement pazar= driver.findElement(By.id("gwt-debug-cwCheckBox-Sunday-input"));
        WebElement CSSStyleBut=driver.findElement(By.xpath("//a[text()='CSS Style']"));

        System.out.println("sali.isDisplayed() = " + sali.isDisplayed());
        System.out.println("sali.isEnabled() = " + sali.isEnabled());
        System.out.println("sali.isSelected() = " + sali.isSelected());
        System.out.println("pazar.isEnabled() = " + pazar.isEnabled()); // buton aktif mi diye kontrol ediyor.
        System.out.println("CSSStyleBut.isEnabled() = " + CSSStyleBut.isEnabled());



        MyFunc.Wait(2);

        sali.click();

        System.out.println("sali.isSelected() = " + sali.isSelected());

        driverWaitQuit(2);

    }
}
