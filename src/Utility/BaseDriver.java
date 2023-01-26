package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BaseDriver {
    public static WebDriver driver;
    public static WebDriverWait waitAWhile;

    static
    {
        // ilk adımda çalışan kod kısmı
        KalanOncekileriKapat();

        Logger logger= Logger.getLogger(""); // Sisteme ait bütün log ları üreten objeye/servise ulaştım.
        logger.setLevel(Level.SEVERE); // Sadece errorları göster
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,"true"); // Chrome servisi sessiz modda çalışır.
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver(); // web sayfasını kontrol eden görevli

        driver.manage().window().maximize();  // Ekranı max yapıyor. minimize simge durumuna düşüüyor
        driver.manage().deleteAllCookies();  // sitenin senin bilgisayarında yaptığı ayarlar siliniyor, sayfa başlangıç ayarlarına dönüyor
                                             // Bazen siteler bizim bot olduğumuzu düşünüp çerezlere imza bırakabiliyor.
                                             // bu noktada siteye her girişimizde çerezleri sıfırlarsak bu durumu önleyebiliyoruz.
                                             // bu bazen her komutta bir yapmak gerekebiliyor.

        Duration dr=Duration.ofSeconds(20); // zaman aralığı
        //driver.manage().timeouts().pageLoadTimeout(dr); // Sadece tüm sayfanın kodlarının bilgisyarınıza inmesi süresiyle ilgili
        //bu eklenmezse Selenium sayfa yüklenene kadar (sonsuza) bekler.: 30 sn süresince sayfanın yüklenmesini bekle yüklenmezse hata ver
        // eğer 2 sn yüklerse 30 sn. beklemez.

        driver.manage().timeouts().implicitlyWait(dr); // Bütün weblementlerin element bazında, elemente özel işlem yapılmadan önce
        // hazır hale gelmesi için verilen mühlet yani süre. O element hazır olana kadar. Mesela tıklayacağı button un hazır olması için verilen
        // süre kadar bekliyor.

        waitAWhile=new WebDriverWait(driver,Duration.ofSeconds(30));
    }

    public static void KalanOncekileriKapat() {

        try {
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /T");
        } catch (Exception ignored) {

        }
    }

    public static void driverWaitQuit(int second)
    {
        MyFunc.Wait(second);
        driver.quit();
    }















//    public static void printMsgWithProgressBar(String message, int length, long timeInterval) {
//        char incomplete = '░'; // U+2591 Unicode Character
//        char complete = '█'; // U+2588 Unicode Character
//        StringBuilder builder = new StringBuilder();
//        Stream.generate(() -> incomplete).limit(length).forEach(builder::append);
//        System.out.println(message);
//        for (int i = 0; i < length; i++) {
//            builder.replace(i, i + 1, String.valueOf(complete));
//            String progressBar = "\r" + builder;
//            System.out.print(progressBar);
//            try {
//                Thread.sleep(timeInterval);
//            } catch (InterruptedException ignored) {
//
//            }
//        }
//
//    }

}
