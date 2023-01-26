package Gun04.Odev;

import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _Soru01 {
    public static void main(String[] args) {
        //    1) Bu siteye gidin. ->  http://demoqa.com/text-box
        //    2) Full Name kısmına "Automation" girin.
        //    3) Email kısmına "Testing@gmail.com" girin.
        //    4) Current Address kısmına "Testing Current Address" girin.
        //    5) Permanent Address kısmına "Testing Permanent Address" girin.
        //    6) Submit butonuna tıklayınız.
        //    7) Full Name'in, "Automation"ı içinde bulundurduğunu doğrulayın.
        //    8) Email'in, "Testing"ı içinde bulundurduğunu doğrulayın.

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/text-box");


        WebElement fullName= driver.findElement(By.id("userName"));
        fullName.sendKeys("Automation");
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("Testing@gmail.com");
        WebElement adress=driver.findElement(By.id("currentAddress"));
        adress.sendKeys("Testing Current Address");
        MyFunc.Wait(5); // Ekranda submit butonu göremediği için bu sürede manuel kaydırdım.
        WebElement perAdress=driver.findElement(By.id("permanentAddress"));
        perAdress.sendKeys("Testing Permanent Address");
        WebElement submitButton=driver.findElement(By.id("submit"));
        submitButton.click();
        WebElement nameCheck =driver.findElement(By.id("name"));
        System.out.println("Name Automation içeriyor mu?: " + nameCheck.getText().contains("Automation"));
        WebElement emailCheck=driver.findElement(By.id("email"));
        System.out.println("Email Testing içeriyor mu?: " + emailCheck.getText().contains("Testing"));


        MyFunc.Wait(5);
        driver.quit();






    }
}
