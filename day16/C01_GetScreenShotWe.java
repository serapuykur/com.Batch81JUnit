package day16;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C01_GetScreenShotWe extends TestBaseBeforeAfter {
    @Test
    public void test1() throws IOException {
        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //nutella aratalim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        //arama sonucunun resmini alalim

        WebElement aramaSonucu= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        File nutellaAramaSonucu=aramaSonucu.getScreenshotAs(OutputType.FILE);
        //Sadece Web elementin resmini alacaksak TakeScreenShot classını kullanmama gerek yok
        //Locate ettiğimiz webelementi direk geçici bir file'a atıp FileUtils ile kopyalayıp yolunu(path) belirtiriz
        FileUtils.copyFile(nutellaAramaSonucu,new File("target/ekranGoruntusuWE/WebESS"+tarih+".jpeg"));

    }
}
