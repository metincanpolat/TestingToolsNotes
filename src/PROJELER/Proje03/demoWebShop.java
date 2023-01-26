package PROJELER.Proje03;

import Utility.BaseDriver;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class demoWebShop extends BaseDriver {
    @Test
    public void Test1(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement registerBtn= driver.findElement(By.linkText("Register"));
        registerBtn.click();

        WebElement gender= driver.findElement(By.id("gender-male"));
        gender.click();

        WebElement name= driver.findElement(By.id("FirstName"));
        name.sendKeys("Met");

        WebElement lastName= driver.findElement(By.id("LastName"));
        lastName.sendKeys("Can");

        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("abs1365ab6@technostudy.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("abc123");

        WebElement passwordRe= driver.findElement(By.id("ConfirmPassword"));
        passwordRe.sendKeys("abc123");

        WebElement registerSign= driver.findElement(By.id("register-button"));
        registerSign.click();

        WebElement messageCheck= driver.findElement(By.cssSelector("div[class='result']"));

        Assert.assertTrue(messageCheck.getText().contains("completed"));

        WebElement logOut=driver.findElement(By.linkText("Log out"));
        logOut.click();

    }
    @Test
    public void Test2(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement registerBtn= driver.findElement(By.linkText("Register"));
        registerBtn.click();

        WebElement gender= driver.findElement(By.id("gender-male"));
        gender.click();

        WebElement name= driver.findElement(By.id("FirstName"));
        name.sendKeys("Met");

        WebElement lastName= driver.findElement(By.id("LastName"));
        lastName.sendKeys("Can");

        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("abs@technostudy.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("abc123");

        WebElement passwordRe= driver.findElement(By.id("ConfirmPassword"));
        passwordRe.sendKeys("abc123");

        WebElement registerSign= driver.findElement(By.id("register-button"));
        registerSign.click();

        WebElement messageCheck= driver.findElement(By.xpath("//li[text()='The specified email already exists']"));

        Assert.assertTrue(messageCheck.getText().contains("exists"));


    }
    @Test
    public void Test3(){

        driver.get("https://demowebshop.tricentis.com/");

        WebElement logInBtn= driver.findElement(By.linkText("Log in"));
        logInBtn.click();

        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("abs@technostudy.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("abc123");

        WebElement logInBtn2= driver.findElement(By.cssSelector("[value='Log in']"));
        logInBtn2.click();

        WebElement logInCheck= driver.findElement(By.linkText("abs@technostudy.com"));

        Assert.assertTrue(logInCheck.getText().contains("technostudy"));

        WebElement logOut=driver.findElement(By.linkText("Log out"));
        logOut.click();

    }
    @Test
    public void Test4(){
        driver.get("https://demowebshop.tricentis.com/");

        waitAWhile.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
        WebElement logInBtn= driver.findElement(By.linkText("Log in"));
        logInBtn.click();

        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("wrongMail@technostudy.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("abc123");

        WebElement logInBtn2= driver.findElement(By.cssSelector("[value='Log in']"));
        logInBtn2.click();

        WebElement logInCheck= driver.findElement(By.className("validation-summary-errors"));

        Assert.assertTrue(logInCheck.getText().contains("try again."));

    }
    @Test
    public void Test5(){
        driver.get("https://demowebshop.tricentis.com/");

        WebElement logInBtn= driver.findElement(By.linkText("Log in"));
        logInBtn.click();

        WebElement email= driver.findElement(By.id("Email"));
        email.sendKeys("abs@technostudy.com");

        WebElement password= driver.findElement(By.id("Password"));
        password.sendKeys("abc123");

        WebElement logInBtn2= driver.findElement(By.cssSelector("[value='Log in']"));
        logInBtn2.click();

        WebElement laptop= driver.findElement(By.linkText("14.1-inch Laptop"));
        laptop.click();

        WebElement addToCart= driver.findElement(By.cssSelector("[value='Add to cart'][id='add-to-cart-button-31']"));
        addToCart.click();

        waitAWhile.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p.content")));
        WebElement messageCheck= driver.findElement(By.cssSelector("p.content"));

        Assert.assertTrue(messageCheck.getText().contains("added"));

        WebElement shoppingCart= driver.findElement(By.linkText("Shopping cart"));
        shoppingCart.click();

        WebElement laptopCheck= driver.findElement(By.linkText("14.1-inch Laptop"));

        Assert.assertTrue("Listede ilgili ürün yok",laptopCheck.isDisplayed());

        WebElement agree= driver.findElement(By.id("termsofservice"));
        agree.click();

        WebElement checkOut= driver.findElement(By.id("checkout"));
        checkOut.click();

        WebElement country= driver.findElement(By.cssSelector("select[id='BillingNewAddress_CountryId']"));

        Select ddcountry=new Select(country);

        ddcountry.selectByValue("86");

        WebElement city= driver.findElement(By.cssSelector("input[id='BillingNewAddress_City']"));
        city.sendKeys("test");

        WebElement address=driver.findElement(By.cssSelector("input[id='BillingNewAddress_Address1']"));
        address.sendKeys("test_test");

        WebElement zip= driver.findElement(By.cssSelector("input[id='BillingNewAddress_ZipPostalCode']"));
        zip.sendKeys("12345");

        WebElement phone= driver.findElement(By.cssSelector("input[id='BillingNewAddress_PhoneNumber']"));
        phone.sendKeys("123456789");

        WebElement continueButton=driver.findElement(By.cssSelector("input[onclick='Billing.save()']"));
        continueButton.click();

        WebElement shippingSave= driver.findElement(By.cssSelector("[onclick='Shipping.save()']"));
        shippingSave.click();

        WebElement methodSave= driver.findElement(By.cssSelector("[onclick='ShippingMethod.save()']"));
        methodSave.click();

        WebElement paymentSave= driver.findElement(By.cssSelector("[onclick='PaymentMethod.save()']"));
        paymentSave.click();

        WebElement infoSave= driver.findElement(By.cssSelector("[onclick='PaymentInfo.save()']"));
        infoSave.click();

        WebElement confirmOrder= driver.findElement(By.cssSelector("[onclick='ConfirmOrder.save()']"));
        confirmOrder.click();

        WebElement buySuccess= driver.findElement(By.xpath("//strong[text()='Your order has been successfully processed!']"));
        Assert.assertTrue(buySuccess.getText().contains("successfully"));

        WebElement finish= driver.findElement(By.cssSelector("input[type='button']"));
        finish.click();

        WebElement logOut=driver.findElement(By.linkText("Log out"));
        logOut.click();







    }
}
