package Gun13_Scroll.Odev;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Soru02 extends BaseDriver {
    //Senaryo
    //1- https://www.youtube.com/ adresine gidiniz
    //2- "Selenium" kelimesi ile video aratınız.
    //3- Listelenen sonuçlarda 80 videoaya kadar lsiteyi uzatınız.
    //4- Son videonun title ını yazdırınız.

    @Test
    public void Test1() {

        driver.get("https://www.youtube.com/");
        //WebDriverWait waitAWhile=new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement search= driver.findElement(By.cssSelector("input[id='search']"));
        search.sendKeys("Selenium");
        WebElement searchBut= driver.findElement(By.cssSelector("button>yt-icon[class='style-scope ytd-searchbox']"));
        searchBut.click();

        List<WebElement> searchList=driver.findElements(By.cssSelector("[class='style-scope ytd-item-section-renderer'][lockup='true']"));
        JavascriptExecutor js=(JavascriptExecutor) driver;

        do {
            js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
            searchList.addAll(driver.findElements(By.cssSelector("[class='style-scope ytd-item-section-renderer'][lockup='true']")));
            while (searchList.size()>80)
                searchList.remove(searchList.size()-1);

        }while (searchList.size()<80);

        System.out.println("searchList = " + searchList.size());

        js.executeScript("window.scrollTo(0,document.body.scrollHeight);");

        searchList.get(79).click();

        MyFunc.Wait(4);

        //waitAWhile.until(ExpectedConditions.urlContains("watch"));

        System.out.println("80. sıradaki videonun Title'ı : "+driver.getTitle());


        //div[id='contents'][class='style-scope ytd-item-section-renderer']
    }
}
