package day11;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class Calisma  extends TestBaseBeforeAfter {
    @Test
    public void test1() {


//1- "http://webdriveruniversity.com/Actison" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");
//2- Hover over Me First" kutusunun ustune gelin
        WebElement hover=driver.findElement(By.xpath("(//*[@class='dropbtn'])[1]"));
        Actions actions=new Actions(driver);
        actions.moveToElement(hover).perform();

//            3 Link 1" e tiklayin
        driver.findElement(By.xpath("(//*[@class='list-alert'])[1]")).click();
//            4 Popup mesajini yazdirin
        System.out.println("Popup mesaji = "+driver.switchTo().alert().getText());

//5 Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
//            6 “Click and hold" kutusuna basili tutun
       WebElement clickHold= driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.moveToElement(clickHold).clickAndHold().perform();
//            7-“Click and hold" kutusunda cikan yaziyi yazdirin
        System.out.println("test "+driver.findElement(By.xpath("//*[@id='click-box']")).getText());
//            8- “Double click me" butonunu cift tiklayi
        WebElement doubleclick=driver.findElement(By.xpath("//*[@id='double-click']"));
        actions.doubleClick(doubleclick).perform();
    }
}