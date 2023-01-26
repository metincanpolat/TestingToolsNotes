package PROJELER.Proje02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Proje02_Junkie extends BaseDriver {
    //Test Case 1:
    //➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
    //➢ E-book add to cart butonuna tıklatınız.
    //➢ Add promo code butonuna tıklatıp veri giriniz.
    //➢ Apply butonuna tıklayınız.
    //➢ Invalid promo code yazısının görüldüğünü doğrulayınız

    @Test
    public void Test1(){
        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebookAdd=driver.findElement(By.cssSelector("button[onclick*='1595015']"));
        ebookAdd.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait waitbutton =new WebDriverWait(driver, Duration.ofSeconds(5));

        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        MyFunc.Wait(2);

        WebElement addPromoCode=driver.findElement(By.xpath("//button[text()='Add Promo Code']"));
        waitbutton.until(ExpectedConditions.visibilityOf(addPromoCode));
        addPromoCode.click();

        WebElement promoCodeText=driver.findElement(By.className("Promo-Code-Value"));
        promoCodeText.sendKeys("BenMetin");
        WebElement promoCodeBut=driver.findElement(By.className("Promo-Apply"));
        promoCodeBut.click();

        WebElement greenBox=driver.findElement(By.xpath("//span[text()='Invalid promo code']"));
        Assert.assertTrue("greenBox Görülmedi",greenBox.isDisplayed());
        //driverWaitQuit(2);

    }

    @Test
    public void Test2(){
        //➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
        //➢ E-book add to cart butonuna tıklatınız.
        //➢ Pay using debit card a tıklatınız.
        //➢ Pay butonuna tıklatınız.
        //➢ Invalid Email, Invalid Email, invalid billing name mesajlarının görüldüğünü doğrulayınız.
        //driver.get("https://shopdemo.e-junkie.com/");

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebookAdd=driver.findElement(By.cssSelector("button[onclick*='1595015']"));
        ebookAdd.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait waitbutton =new WebDriverWait(driver, Duration.ofSeconds(5));

        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        MyFunc.Wait(2);

        WebElement debitCardBut=driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        debitCardBut.click();
        WebElement payBut=driver.findElement(By.cssSelector("[class='Pay-Button']"));
        payBut.click();

        WebElement greenBox= driver.findElement(By.cssSelector("[name='close-circle']+span"));
        waitbutton.until(ExpectedConditions.visibilityOf(greenBox));
        Assert.assertTrue("greenBox Görülmedi",greenBox.isDisplayed());

    }
    @Test
    public void Test3(){
        //➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
        //➢ E-book add to cart butonuna tıklatınız.
        //➢ Pay using debit card a tıklatınız.
        //➢ Card numarasına “1111 1111 1111 1111” giriniz
        //➢ “Your card number is invalid” mesajının görüldüğünü doğrulayınız

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebookAdd=driver.findElement(By.cssSelector("button[onclick*='1595015']"));
        ebookAdd.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait waitbutton =new WebDriverWait(driver, Duration.ofSeconds(5));

        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        MyFunc.Wait(2);

        WebElement debitCardBut=driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        debitCardBut.click();

        WebElement frame2 = driver.findElement(By.cssSelector("iframe[name*='privateStripeFrame']"));
        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame2));
        MyFunc.Wait(2);
        WebElement cardNumber=driver.findElement(By.name("cardnumber"));
        cardNumber.sendKeys("1111111111111111");

        driver.switchTo().parentFrame();

        WebElement greenBox= driver.findElement(By.cssSelector("[name='close-circle']+span"));
        waitbutton.until(ExpectedConditions.visibilityOf(greenBox));
        Assert.assertTrue("greenBox Görülmedi",greenBox.isDisplayed());


    }
    @Test()
    public void Test4(){
        //➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
        //➢ E-book add to cart butonuna tıklatınız.
        //➢ Pay using debit card a tıklatınız.
        //➢ Email, confirm Email, name, telefon, company, Card number(“4242 4242 4242 4242” ) giriniz,
        //expdate, cvc kodu bilgilerini doldurunuz
        //➢ Pay butonuna tıklayınız
        //➢ “Your order is confirmed. Thank you!” mesajının görüldüğünü doğrulayınız

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement ebookAdd=driver.findElement(By.cssSelector("button[onclick*='1595015']"));
        ebookAdd.click();

        WebElement frame = driver.findElement(By.xpath("//iframe[@class='EJIframeV3 EJOverlayV3']"));

        WebDriverWait waitbutton =new WebDriverWait(driver, Duration.ofSeconds(50));

        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
        MyFunc.Wait(2);

        WebElement debitCardBut=driver.findElement(By.cssSelector("[class='Payment-Button CC']"));
        debitCardBut.click();

        WebElement email=driver.findElement(By.cssSelector("input[placeholder='Email']"));
        email.sendKeys("abc@hotmail.com");
        WebElement confirmEmail=driver.findElement(By.cssSelector("input[placeholder='Confirm Email']"));
        confirmEmail.sendKeys("abc@hotmail.com");

        WebElement name=driver.findElement(By.cssSelector("input[placeholder='Name On Card']"));
        name.sendKeys("Metin C");

        WebElement phone=driver.findElement(By.cssSelector("[class='Billing-Phone Inline']>input[autocomplete='phone']"));
        phone.sendKeys("5325322232");

        WebElement company=driver.findElement(By.cssSelector("[class='Billing-Company']>input[autocomplete='company']"));
        company.sendKeys("TechnoStudy");

        WebElement frame2 = driver.findElement(By.cssSelector("iframe[name*='privateStripeFrame']"));
        waitbutton.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame2));
        MyFunc.Wait(2);
        WebElement cardNumber=driver.findElement(By.name("cardnumber"));
        cardNumber.sendKeys("42424242424242421026325");

        driver.switchTo().parentFrame();


        WebElement payButton=driver.findElement(By.cssSelector("button[class='Pay-Button']"));
        //waitbutton.until(ExpectedConditions.visibilityOf(payButton));
        payButton.click();

        waitbutton.until(ExpectedConditions.urlContains("www.fatfreecartpro.com"));



        WebElement greenText= waitbutton.until(ExpectedConditions.visibilityOfElementLocated(By.className("green_text_margin")));
        Assert.assertTrue("Onaylanmadı",greenText.getText().contains("order is confirmed."));

    }

    @Test
    public void Test5(){
        //➢ https://shopdemo.e-junkie.com/ sitesine gidiniz
        //➢ ContactUs butonuna tıklattınız
        //➢ Name, Email, Subject ve mesaj kısımlarını doldurun
        //➢ Send butonuna tıklatın
        //➢ Alert in görüldüğünü doğrulayın ve alert I kapatın

        driver.get("https://shopdemo.e-junkie.com/");

        WebElement contactUs=driver.findElement(By.className("contact"));
        contactUs.click();

        WebElement name=driver.findElement(By.cssSelector("input[id='sender_name']"));
        name.sendKeys("Metin");

        WebElement email=driver.findElement(By.cssSelector("input[id='sender_email']"));
        email.sendKeys("abc@hotmail.com");

        WebElement subject=driver.findElement(By.cssSelector("input[id='sender_subject']"));
        subject.sendKeys("senin ben...");

        WebElement message=driver.findElement(By.cssSelector("[id='sender_message']"));
        message.sendKeys("bu nasıl site arkadaş...");

        WebElement sendMessage=driver.findElement(By.cssSelector("[id='send_message_button']"));
        sendMessage.click();

        WebDriverWait waitbutton =new WebDriverWait(driver, Duration.ofSeconds(5));

        waitbutton.until(ExpectedConditions.alertIsPresent());


        Assert.assertTrue("olmadı",driver.switchTo().alert().getText().contains("Recapt"));






    }
//    @Test
//    public void Test6(){
//
//        driver.get("https://www.hepsiburada.com/");
//
//        WebElement acceptBut= driver.findElement(By.xpath("//button[text()='Kabul Et']"));
//        acceptBut.click();
//
//        WebElement philips=driver.findElement(By.xpath("//img[contains(@src,'thumbnailImage2122_20221104103149' )]"));
//        philips.click();

//    WebElement picture = driver.findElement(By.xpath("//img[contains(@src,'thumbnailImage2122_20221104103149' )]"));
//        action.scrollToElement(picture).build().perform();
//        wait.until(ExpectedConditions.elementToBeClickable(picture)).click();
//
//    }



}

//driver.get("https://shopdemo.e-junkie.com/%22);
//        List<WebElement> iframes = driver.findElements(By.xpath("//iframe"));
//        System.out.println("iframes adedi : " + iframes.size());
//        int s = 0;
//        for (WebElement i : iframes) {
//            System.out.println("i.getAttribute("class") = " + s + " : " + i.getAttribute("class"));
//            s++;
//        }