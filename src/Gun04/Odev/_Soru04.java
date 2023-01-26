package Gun04.Odev;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _Soru04 {
    public static void main(String[] args) {
        //Bu websitesine gidiniz.  [https://testpages.herokuapp.com/styled/index.html]
        //Calculate'e tıklayınız.
        //         İlk input'a herhangi bir sayı giriniz.
        //         İkinci input'a herhangi bir sayı giriniz
        //Calculate button'una tıklayınız.
        //Sonucu alınız.
        //Sonucu yazdırınız.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        MyFunc.Wait(5);
        WebElement calculate=driver.findElement(By.id("calculate"));
        calculate.click();
        WebElement number1=driver.findElement(By.id("number1"));
        number1.sendKeys("8");
        WebElement number2=driver.findElement(By.id("number2"));
        number2.sendKeys("2");
        WebElement CalcButton=driver.findElement(By.id("calculate"));
        CalcButton.click();
        WebElement answerCheck=driver.findElement(By.id("answer"));
        System.out.println("Cevap: "+answerCheck.getText());


        MyFunc.Wait(5);
        driver.quit();
    }
}
