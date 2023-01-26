package Gun07_XPath;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _02_Senaryo extends BaseDriver {
    //1- https://www.saucedemo.com/  sitesini açın
    //2- login işlemini yapınız.
    //3- Sauce Labs Backpack  a tıklatın ve sepete ekletin.
    //4- Sonra geri dönün (Back to products e tıklatın)
    //5- Sauce Labs Bolt T-Shirt  a tıklatın ve sepete ekleyin.
    //6- sepete tıklatın
    //7- CheckOut a tıklatın
    //8- kullanıcı bilgilerini doldurup Continue ya tıklatın
    //9- Burada her bir eşyanın ücretlerinin toplamının aşağıdaki
    //Item total e eşit olup olmadığını if/Assert ile test ediniz.


    @Test
    public void Test1(){
        driver.get("https://www.saucedemo.com/");

        //String userNameText= driver.getTitle();
        //System.out.println("userNameText.getText() = " + userNameText.getText());
        WebElement userNameParent= driver.findElement(By.xpath("//*[@id='login_credentials']"));
        String[] userNameList=userNameParent.getText().split("\n"); // Burada n kısmına \\R de yazabiliyoruz. Sadece ilk eleman geresiz bu listede.
        MyFunc.Wait(2);

        for (int i = 0; i < userNameList.length; i++)
            System.out.println(i+" .userName = " + userNameList[i]);

        MyFunc.Wait(2);
        WebElement userN=driver.findElement(By.xpath("//input[@id='user-name']"));
        userN.sendKeys(userNameList[1]);

        WebElement passwordParent= driver.findElement(By.xpath("//*[@id='login_credentials']/following-sibling::div"));
        String[] passwordList=passwordParent.getText().split("\n"); // Burada n kısmına \\R de yazabiliyoruz. Sadece ilk eleman geresiz bu listede.
        MyFunc.Wait(2);

        for (int i = 0; i < passwordList.length; i++)
            System.out.println(i+" .password = " + passwordList[i]);



        WebElement passwordButton=driver.findElement(By.xpath("//input[@id='password']"));
        passwordButton.sendKeys(passwordList[1]);
        MyFunc.Wait(1);


        WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();
        MyFunc.Wait(1);

        WebElement backpack=driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']"));
        backpack.click();
        MyFunc.Wait(1);

        WebElement backpackAdd=driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        backpackAdd.click();
        MyFunc.Wait(1);

        WebElement backToProduct=driver.findElement(By.xpath("//button[@id='back-to-products']"));
        backToProduct.click();
        MyFunc.Wait(1);

        WebElement boltTshirt=driver.findElement(By.xpath("//div[text()='Sauce Labs Bolt T-Shirt']"));
        boltTshirt.click();
        MyFunc.Wait(1);

        WebElement boltTshirtAdd=driver.findElement(By.xpath("//button[text()='Add to cart']")); //text() yerine . koyabiliriz
        boltTshirtAdd.click();
        MyFunc.Wait(1);

        WebElement shoppingCart=driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shoppingCart.click();
        MyFunc.Wait(1);

        WebElement checkoutBut=driver.findElement(By.xpath("//button[@id='checkout']"));
        checkoutBut.click();
        MyFunc.Wait(1);

        WebElement firstName=driver.findElement(By.xpath("//input[@name='firstName']"));
        firstName.sendKeys("Metin");
        MyFunc.Wait(1);

        WebElement lastName=driver.findElement(By.xpath("//input[@id='last-name']"));
        lastName.sendKeys("Canpolat");
        MyFunc.Wait(1);

        WebElement zipCode=driver.findElement(By.xpath("//input[@id='postal-code']"));
        zipCode.sendKeys("48000");
        MyFunc.Wait(1);

        WebElement continueBut=driver.findElement(By.xpath("//input[@id='continue']"));
        continueBut.click();
        MyFunc.Wait(1);



        // ürünlerin ücretleri
        List<WebElement> ucretler=driver.findElements(By.xpath("//div[@class='inventory_item_price']"));

        double toplam=0;
        for (WebElement e : ucretler)
        {
            System.out.println(e.getText()); // $29.99
            toplam += Double.parseDouble(e.getText().substring(1)); // [$]."" veya replace("$","")
        }
        System.out.println("toplam = " + toplam);

        WebElement webAltToplam=driver.findElement(By.xpath("//div[@class='summary_subtotal_label']"));

        double altToplam = Double.parseDouble(webAltToplam.getText().substring(13));
        System.out.println("altToplam = " + altToplam);

        Assert.assertTrue("Değerler eşit değil= ",(toplam==altToplam));






        driverWaitQuit(2);

    }

}
