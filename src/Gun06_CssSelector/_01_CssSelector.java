package Gun06_CssSelector;

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.Assert; // Java nın kendi Test kontrol ve organıze sınıfı.
import org.openqa.selenium.support.FindBy;

public class _01_CssSelector extends BaseDriver {
    public static void main(String[] args) {

        driver.get("https://demo.seleniumeasy.com/basic-first-form-demo.html");

        String messageText="Merhaba Selenium";
        WebElement message= driver.findElement(By.cssSelector("input#user-message")); // input[id='user-message'] şeklinde de yazılabilir

                                                                                      // input#user-message[class='form-control'] birden fazla yazılacağı zaman
        message.sendKeys(messageText);

        WebElement messageButton= driver.findElement(By.cssSelector("button[onclick='showInput();']"));
        messageButton.click();

        WebElement messageOutput=driver.findElement(By.cssSelector("span#display")); // span[id='display']

//        if (messageOutput.getText().contains(messageText))
//            System.out.println("test passed");
//        else
//            System.out.println("test failed");


        Assert.assertTrue(messageText+" mesajı bulunamadı",messageOutput.getText().contains(messageText)); // beklenen expect
        // assertTrue: içindeki değer True mu? True ise hiç bir şey yapmaz, mesaj vermez.
        // değilse beklenen olmamışsa hata mesajı verir
        // yani genel kural : Hata var ise göster.
        // başına istersek hata mesajı ekleyebiliyoruz.

        driverWaitQuit(3);

    }
}
