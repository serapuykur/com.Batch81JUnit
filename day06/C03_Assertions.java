package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
 /*
   1) Bir class oluşturun: BestBuyAssertions
   2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki
   testleri yapin
        ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
        ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        ○ logoTest => BestBuy logosunun görüntülendigini test edin
        ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
    */
   static WebDriver driver;

 @BeforeClass
 public static void setUp(){
  WebDriverManager.chromedriver().setup();
  driver= new ChromeDriver();
  driver.manage().window().maximize();
  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
  driver.get("https://www.bestbuy.com/");
 }
 @AfterClass
 public static void tearDown(){
  driver.close();

 }
 @Test
 public  void  test1(){
    //  ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin
  String expectedUrl="https://www.bestbuy.com/";
  String actuelUrl=driver.getCurrentUrl();
  Assert.assertEquals(expectedUrl,actuelUrl);

 }
 @Test
 public void test2(){
   //○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
  String expectedTitle="Rest";
  String actualTitle=driver.getTitle();
  Assert.assertFalse(actualTitle.contains(expectedTitle));

 }
 @Test
 public void Test3(){
     // ○ logoTest => BestBuy logosunun görüntülendigini test edin
 Assert.assertTrue(driver.findElement(By.xpath("//*[@class='logo'][1]")).isDisplayed());

 }
 @Test
 public void Test4(){
   //○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
  WebElement FrancaisLinkTest =driver.findElement(By.className("is-active"));
  Assert.assertTrue(FrancaisLinkTest.isDisplayed());

 }


}
