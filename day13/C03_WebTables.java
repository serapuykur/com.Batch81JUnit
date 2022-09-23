package day13;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBaseBeforeAfter;

public class C03_WebTables extends TestBaseBeforeAfter {
    @Test
    public void test1(){
      //bir onceki classta verilen adrese gidelim
      //login() metodunu kullanarak sayfaya giris yapalim
      //input olarak verilen satir sayisini ve sutun sayisina sahip celldeki texti yazdiralim

      int satir=3;
      int sutun=4;
        WebElement tekilHucre = driver.findElement(By.xpath("//tbody//tr[6]//td[4]"));

    }
}
