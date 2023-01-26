package Gun05_Navigate_Finding_GetCSS;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class _02_Navigating extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://testpages.herokuapp.com/styled/index.html");

        //driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        WebElement element= driver.findElement(By.linkText("Alerts (JavaScript)"));
        element.click();

        System.out.println(driver.getCurrentUrl()); // o anda bulunduğum URL yi veriyor

        MyFunc.Wait(2);
        driver.navigate().back(); // tarayıcı history isinden geri geldim. geri gelme tuşu.

        System.out.println(driver.getCurrentUrl()); // o anda bulunduğum URL yi veriyor

        MyFunc.Wait(2);
        driver.navigate().forward(); // tarayıcı history isinden ileri gittim. ileri tuşu

        System.out.println(driver.getCurrentUrl()); // o anda bulunduğum URL yi veriyor

        //navigate den sonraki komuta geçerken sayfanın tamamen yüklenmesini beklemiyor, get ile yapınca bekliyor.







        driverWaitQuit(5);
    }
}
