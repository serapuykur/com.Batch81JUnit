package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Iframe {
    /*
  ● Bir class olusturun: IframeTest
  ● https://the-internet.herokuapp.com/iframe adresine gidin.
  ● Bir metod olusturun: iframeTest
     ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
     ○ Text Box’a “Merhaba Dunya!” yazin.
     ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu
       dogrulayin ve konsolda yazdirin
   */
    WebDriver driver;

    @Before
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        // driver.close();
    }

    @Test
    public void test1() throws InterruptedException {



// 1- https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
// 2- Bir metod olusturun: iframeTest
//  3-  ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve konsolda yazdirin.
        WebElement iframeYazisi= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());
        System.out.println(iframeYazisi.getText());
//  4-  ○ Text Box’a “Merhaba Dunya!” yazin.
        WebElement textBox= driver.findElement(By.id("mce_0_ifr"));//frame gecmeden once orayi id ile locate edelim
        driver.switchTo().frame(textBox);
        WebElement textBoxFrame = driver.findElement(By.xpath("//p"));

       textBoxFrame.clear();//clear methodu texbox icini temizler
        Thread.sleep(3000);
        textBoxFrame.sendKeys("Merhaba Dunya");
//  5-  ○ TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu   dogrulayin ve konsolda yazdirin
        driver.switchTo().defaultContent();//iframe cikip ama anasayfaya gecmek iicn bu method kullanilir

        WebElement elemental= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elemental.isDisplayed());
        System.out.println(elemental.getText());


    }
}