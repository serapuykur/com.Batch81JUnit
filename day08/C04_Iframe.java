package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Iframe {

    //Iframe bir websayfasi icine yerlestirilmis baska bir websayfasidir
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
    public void test1() {
      //  https://www.youtube.com/embed/owsfdh4gxyc   adresine gidiniz
        //Youtube videosunu calistiriniz
        WebElement youtubeFrame= driver.findElement(By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame);
       driver.findElement(By.xpath("//*[@aria-label='Oynat']")).click();

    }
}