package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfter {
    WebDriver driver;
    @Before
    //before notasyonu her testen once calsir
    public  void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public  void method1(){
        //1 defa befor() methodu calisir
        //1 defa da after() methodu calisir
        driver.get("https://amazon.com");
    }
    public  void method2(){
        //1 defa befor() methodu calisir
        //1 defa da after() methodu calisir
        driver.get("https://techproeducation.com");
    }
    public  void method3(){
        //1 defa befor() methodu calisir
        //1 defa da after() methodu calisir
        driver.get("https://hepsiburada.com");
    }
    @After
    //after notasyonu her testen sonra calisir
    public  void tearDown(){
        driver.close();
    }
}
