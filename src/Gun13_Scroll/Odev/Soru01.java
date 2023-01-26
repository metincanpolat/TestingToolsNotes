package Gun13_Scroll.Odev;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Soru01 extends BaseDriver {
//Senaryo
//1- https://testsheepnz.github.io/BasicCalculator.html sitesine gidiniz.
//2- random 100 e kadar 2 sayı üretiniz.
//3- Sayıları hesap makinesinin bütün fonksiyonları için çalıştırınız.
//4- Sonuçları Assert ile kontrol ediniz.
//5- Yukarıdaki işlemi 5 kez tekrar ettiriniz.
    @Test
    public void Test1() {

        driver.get("https://testsheepnz.github.io/BasicCalculator.html");

        WebElement number1= driver.findElement(By.id("number1Field"));
        WebElement number2= driver.findElement(By.id("number2Field"));
        WebElement selectLocate= driver.findElement(By.id("selectOperationDropdown"));
        WebElement calculate= driver.findElement(By.id("calculateButton"));
        WebElement answer= driver.findElement(By.id("numberAnswerField"));
        Select selectMenu=new Select(selectLocate);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", number1);

        int num1=(int) (Math.random()*100);
        int num2=(int) (Math.random()*100);
        number1.sendKeys(Integer.toString(num1));
        number2.sendKeys(Integer.toString(num2));

        selectMenu.selectByValue("0");
        calculate.click();
        WebDriverWait waitAWhile=new WebDriverWait(driver, Duration.ofSeconds(5));
        waitAWhile.until(ExpectedConditions.visibilityOf(answer));
        Assert.assertEquals((num1+num2),Integer.parseInt(answer.getAttribute("value")));

        selectMenu.selectByValue("1");
        calculate.click();
        waitAWhile.until(ExpectedConditions.visibilityOf(answer));
        Assert.assertEquals((num1-num2),Integer.parseInt(answer.getAttribute("value")));

        selectMenu.selectByValue("2");
        calculate.click();
        waitAWhile.until(ExpectedConditions.visibilityOf(answer));
        Assert.assertEquals((num1*num2),Integer.parseInt(answer.getAttribute("value")));

        selectMenu.selectByValue("3");
        calculate.click();
        waitAWhile.until(ExpectedConditions.visibilityOf(answer));
        Assert.assertEquals((num1/num2),(int)Double.parseDouble(answer.getAttribute("value")));

        driverWaitQuit(2);













    }
}
