package PROJELER.Proje01;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)


public class Proje1_Akakce extends BaseDriver {
    ////1. https://www.akakce.com/ sitesinde bir hesap açınız,
    //        //2. Sitenin açılıp açılmadığını kontrol ediniz,
    //        // *** E-posta için gerçek bir hesap olmasına gerek yok
    //        // *** Şifre 8 karakterli büyük , küçük harf ve rakam içermelidir
    //        //3. Hesap açma işlemi tamamlandıktan sonra doğru hesabın açılıp açılmadığını
    //        //kontrol ediniz.
    //        //4. Profil sayfanızı açınız ve Siparişlerim butonuna tıklayınız
    //        //5. Siparişinizin olmadığını doğrulayınız,
    //        //6. Profil sayfanızı açınız ve Mesajlarım butonuna tıklayınız
    //        //7. Mesajınızın olmadığını doğrulayınız
    //        //8. Ana sayfaya tekrar dönün,
    //        //9. Hesabınızı silmek için gerekli adımları uygulayınız.
    //        //Not: Lütfen Gerçek MAİL adresinizi kullanmayınız




    @Test
    public void Test1(){

        driver.get("https://www.akakce.com/");

        WebElement akakce= driver.findElement(By.xpath("//*[@title='Anasayfaya gitmek için tıklayın']"));

        //System.out.println(akakce.getText());
        Assert.assertTrue("Site açılmadı",akakce.getText().equals("Akakce.com"));
        MyFunc.Wait(1);

        WebElement openPage=driver.findElement(By.linkText("Hesap Aç"));
        openPage.click();
        MyFunc.Wait(1);

        WebElement name=driver.findElement(By.id("rnufn"));
        name.sendKeys("Metin");
        MyFunc.Wait(1);

        WebElement surName=driver.findElement(By.id("rnufs"));
        surName.sendKeys("Can");
        MyFunc.Wait(1);

        WebElement email=driver.findElement(By.id("rnufe1"));
        email.sendKeys("ajk@hotmail.com");
        MyFunc.Wait(1);

        WebElement emailRep=driver.findElement(By.id("rnufe2"));
        emailRep.sendKeys("ajk@hotmail.com");
        MyFunc.Wait(1);

        WebElement password=driver.findElement(By.xpath("//input[@type='password' and @id='rnufp1']"));
        password.sendKeys("Ab123Ab123");
        MyFunc.Wait(1);

        WebElement passwordRep=driver.findElement(By.xpath("//input[@type='password' and @id='rnufp2']"));
        passwordRep.sendKeys("Ab123Ab123");
        MyFunc.Wait(1);

        WebElement sex = driver.findElement(By.xpath("//label[text()='Ad *']//following::input[8]"));
        sex.click();
        MyFunc.Wait(1);

        WebElement city = driver.findElement(By.xpath("//span[@class='radio_v8']/following-sibling::span/child::select"));
        Select cityMenu=new Select(city);
        cityMenu.selectByValue("35");
        MyFunc.Wait(1);

        WebElement town = driver.findElement(By.id("locds"));
        Select townMenu=new Select(town);
        townMenu.selectByValue("458");
        MyFunc.Wait(1);

        WebElement day = driver.findElement(By.id("bd"));
        Select dayMenu=new Select(day);
        dayMenu.selectByValue("5");
        MyFunc.Wait(1);

        WebElement month = driver.findElement(By.id("bm"));
        Select monthMenu=new Select(month);
        monthMenu.selectByValue("2");
        MyFunc.Wait(1);

        WebElement year = driver.findElement(By.id("by"));
        Select yearMenu=new Select(year);
        yearMenu.selectByValue("1984");
        MyFunc.Wait(1);

        WebElement userAgreement = driver.findElement(By.id("rnufpca"));
        userAgreement.click();
        MyFunc.Wait(1);

        WebElement campaign = driver.findElement(By.id("rnufnee"));
        campaign.click();
        MyFunc.Wait(1);

        WebElement createAccount = driver.findElement(By.id("rfb"));
        createAccount.click();
        MyFunc.Wait(1);

       // driverWaitQuit(3);
    }


    @Test
    public void Test2(){
        GirisYap();
        WebElement openPage=driver.findElement(By.linkText("Metin"));
        Assert.assertTrue("Giriş Başarısız",openPage.getText().contains("Metin"));

        WebElement account=driver.findElement(By.linkText("Metin"));
        account.click();
        MyFunc.Wait(1);

        WebElement ordersBut=driver.findElement(By.xpath("//li[@class='order first']/a[1]"));
        ordersBut.click();
        MyFunc.Wait(1);

        WebElement ordersCheck=driver.findElement(By.cssSelector("#user-order-info>div"));
        Assert.assertTrue("Test geçmedi",ordersCheck.getText().contains("bulunmuyor"));
        MyFunc.Wait(1);

        account=driver.findElement(By.linkText("Metin")); // burada kod tazeledik.
        account.click();
        MyFunc.Wait(1);

        WebElement messages=driver.findElement(By.xpath("//li[@class='order first']/a[2]"));
        messages.click();
        MyFunc.Wait(1);

        WebElement messagesCheck=driver.findElement(By.cssSelector(".wbb_v8>p"));
        Assert.assertTrue("Test geçmedi",messagesCheck.getText().contains("bulunamadı."));
        MyFunc.Wait(1);

        WebElement mainPage=driver.findElement(By.xpath("//a[text()='Akakce.com']"));
        mainPage.click();

        account=driver.findElement(By.linkText("Metin"));
        account.click();
        MyFunc.Wait(1);

        WebElement accountDel=driver.findElement(By.xpath("//li[@class='user']/a[4]"));
        accountDel.click();
        MyFunc.Wait(1);

        WebElement password=driver.findElement(By.id("p"));
        password.sendKeys("Ab123Ab123");

        WebElement accountDelBut=driver.findElement(By.xpath("//span[@class='tool']/input"));
        accountDelBut.click();
        MyFunc.Wait(1);



        driverWaitQuit(2);


    }

    public void GirisYap(){

        driver.get("https://www.akakce.com/");

        WebElement openPage=driver.findElement(By.linkText("Giriş Yap"));
        openPage.click();
        MyFunc.Wait(1);

        WebElement email=driver.findElement(By.id("life"));
        email.sendKeys("ajk@hotmail.com");
        MyFunc.Wait(1);

        WebElement password=driver.findElement(By.id("lifp"));
        password.sendKeys("Ab123Ab123");
        MyFunc.Wait(1);

        WebElement loginBut=driver.findElement(By.id("lfb"));
        loginBut.click();
        MyFunc.Wait(1);

    }
}

