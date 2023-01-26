package Gun13_Scroll;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class _02_ScrollToBottomOfThePage extends BaseDriver {

    @Test
    public void Test1() {

        driver.get("https://triplebyte.com/");

        JavascriptExecutor js=(JavascriptExecutor) driver;

        MyFunc.Wait(2);

        js.executeScript("window.scrollTo(0,document.body.scrollHeight);"); // sayfa sonuna götürür.

        MyFunc.Wait(2);

        js.executeScript("window.scrollTo(0,0);"); //-document.body.scrollHeight buda basa gidiyor.

        driverWaitQuit(2);



    }
}
