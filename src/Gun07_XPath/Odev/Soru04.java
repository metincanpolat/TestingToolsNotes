package Gun07_XPath.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Soru04 extends BaseDriver {
    //Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]
    //Calculate'e tıklayınız.
    //İlk input'a herhangi bir sayı giriniz.
    //İkinci input'a herhangi bir sayı giriniz
    //Calculate button'una tıklayınız.
    //Sonucu alınız.
    //Sonucu yazdırınız.

    @Test
    public void Test1(){
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Wait(5);
        WebElement calculate=driver.findElement(By.xpath("//a[@id='calculate']"));
        calculate.click();
        WebElement number1=driver.findElement(By.xpath("//input[@id='number1']"));
        number1.sendKeys("8");
        WebElement number2=driver.findElement(By.xpath("//input[@id='number2']"));
        number2.sendKeys("2");
        WebElement CalcButton=driver.findElement(By.xpath("//input[@id='calculate']"));
        CalcButton.click();
        WebElement answerCheck=driver.findElement(By.xpath("//span[@id='answer']"));
        System.out.println("Cevap: "+answerCheck.getText());
    }
}
