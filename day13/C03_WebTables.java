package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import java.util.List;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1() {
        //bir onceki classta verilen adrese gidelim
        //login() metodunu kullanarak sayfaya giris yapalim
        login();

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        int satir = 3;
        int sutun = 4;
        //input olarak verilen satir sayisini ve sutun sayisina sahip celldeki texti yazdiralim
        WebElement cell= driver.findElement(By.xpath("//tbody//tr[3]//td[4]"));
        System.out.println("satir ve sutundaki text"+cell.getText());//happy Hotel
        //price basligindaki tum numaralari yazdirin
        List<WebElement> priceBasligi=driver.findElements(By.xpath("//tbody//tr//td[6]"));
        for (WebElement w:priceBasligi){
            System.out.println("price basligindaki tum numaralar"+w.getText());


        }


    }

    private void login() {

        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //driver.findElement(By.xpath("//*[@id='UserName']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.xpath("//*[@id='UserName']"));
        actions.click(userName).sendKeys("manager").
                sendKeys(Keys.TAB).sendKeys("Manager1!").sendKeys(Keys.ENTER).perform();



    }
}