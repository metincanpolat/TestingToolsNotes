package Gun08_SelectClass;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class _02_Soru extends BaseDriver {
    //        Test Senaryosu
//        1- https://www.facebook.com/  sayfasına gidiniz
//        2- CreateNewAccount a tıklatınız.
//        3- Açılan yeni pencerede isim, soyisim ve emaili giriniz.
//        4- Doüum tarihinizi Select sınıfı ile seçiniz
//        5- Email i tekrar girmenizi isteyen bir input daha açıldığını
//        öncesinde de görünmediğini assert ile doğrulayınız.

    @Test
    public void Test1(){
        driver.get("https://www.facebook.com/");

        WebElement newAccountBut= driver.findElement(By.xpath("//a[contains(@data-testid,'open-registration')]"));
        newAccountBut.click();
        MyFunc.Wait(1);

        WebElement firstName= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Metin");
        MyFunc.Wait(1);

        WebElement lastName= driver.findElement(By.name("lastname"));
        lastName.sendKeys("Canpolat");
        MyFunc.Wait(1);

        WebElement hiddenObj= driver.findElement(By.cssSelector("#fullname_field+div+div"));
        Assert.assertTrue("Email girmeden önce gizli değil.",hiddenObj.getAttribute("class").equals("hidden_elem") );
        MyFunc.Wait(1);

        String email="metin@technostudy.com";
        WebElement emailText= driver.findElement(By.xpath("//input[contains(@aria-label,'Cep telefonu')]"));
        emailText.sendKeys(email);
        MyFunc.Wait(1);

        hiddenObj= driver.findElement(By.cssSelector("#fullname_field+div+div"));
        Assert.assertTrue("Email girişi yapılınca ortaya çıkmadı",!hiddenObj.getAttribute("class").equals("hidden_elem") );
        MyFunc.Wait(1);

        //Burada hoca 2. çözüm olarak findElements kullanıp hidden olan elementi listeye ekledi eğer liste size ı 1 se element var 0 sa yok.

        WebElement emailAgain= driver.findElement(By.cssSelector("input[aria-label^='E-posta adresini']"));
        emailAgain.sendKeys(email);
        MyFunc.Wait(1);

        WebElement password=driver.findElement(By.xpath("//input[@data-type='password']"));
        password.sendKeys("Ab123Ab123");
        MyFunc.Wait(1);

        WebElement day=driver.findElement(By.id("day"));
        Select dayMenu=new Select(day);
        dayMenu.selectByValue("25");
        MyFunc.Wait(1);

        WebElement month=driver.findElement(By.id("month"));
        Select monthMenu=new Select(month);
        monthMenu.selectByValue("3");
        MyFunc.Wait(1);

        WebElement year=driver.findElement(By.id("year"));
        Select yearMenu=new Select(year);
        yearMenu.selectByValue("1984");
        MyFunc.Wait(1);

        WebElement sex= driver.findElement(By.cssSelector("input[value='2'][name='sex']"));
        sex.click();


        driverWaitQuit(3);








    }





}
