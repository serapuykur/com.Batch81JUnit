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
import java.util.ArrayList;
import java.util.List;

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

        //Youtube videosunu calistiriniz
        driver.get("https://html.com/tags/iframe/");
        /*
        bir web sitesinde bir video(youtube vb) varsa <iframe>tagi icerisindeyse bu videoyu direk locate edip calistirmak
        dinamik olma cunku link degisebilir ve locatemiz calismaz.
        bunun icin butun frameleri bir array liste atip index ile framei secip sonrasinda play tusu nu locate edip
        calistirabiliriz
         */

       List<WebElement> iframeList=new ArrayList<>(driver.findElements(By.xpath("//iframe")));
       driver.switchTo().frame(iframeList.get(0));
       driver.findElement(By.xpath("//*[@aria-label='Oynat']"));

    }
}