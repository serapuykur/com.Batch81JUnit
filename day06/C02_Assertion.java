package day06;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertion {
    /*Amazon sayfasina gidelim
    3 farkli test methodu olusturalim
    a=url nin amazon icerdigini test edelim
    b=titlenin facebook icermedigini test edelim
    c=sol ust kosede amazon logosunun gorundugunu test edelim
    d-urlnin facebook.com oldugunu test ediniz

     */
    static WebDriver driver;
    @BeforeClass

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown(){
       // driver.close();
    }
    @Test
    public void test1(){

       // url nin amazon icerdigini test edelim
        String expectedUrl="amazon";
        String actuelUrl=driver.getCurrentUrl();
        Assert.assertTrue(actuelUrl.contains(expectedUrl));

    }
    @Test
    public void test2(){
        //titlenin facebook icermedigini test edelim
        String actualTitle=driver.getTitle();
        String expectedTitle="facebook";
        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
    @Test
    public void Test3(){
        //sol ust kosede amazon logosunun gorundugunu test edelim
      WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
      Assert.assertTrue(logo.isDisplayed());

    }

    /*
    /assertTrue
//beklenen bir sonucun true olduğunun kabul edilmesi gerektiği zaman kullanılır.
// Parametre olarak iki değer alır.
// İlk parametre de bir mesaj gönderilir ikinci parametrede ise gönderilen mesajın doğruluğu için koşul belirlenir.
//assertFalse
//beklenen bir sonucun false olması durumunda kullanılır.
// İki parametre alır. Parametrelerden biri mesajdır diğeri ise koşuldur.
// assertFalse ile koşul yerine getirilmez ise assertionError hatası fırlatır.

   */

    @Test
    public void test4(){
        //d-urlnin facebook.com oldugunu test ediniz
        String actualUrl="www.facebook.com";
        String expectedUrl=driver.getCurrentUrl();
        Assert.assertNotEquals(expectedUrl,actualUrl);

    }


}
