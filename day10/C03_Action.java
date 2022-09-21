package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

import javax.swing.*;

public class C03_Action extends TestBaseBeforeAfter {
    @Test
    public  void test1(){
        //amazon sayfasina gidelim
        // account  menusunden create a list linkine tiklayalim
        driver.get("https://amazon.com");
        WebElement accountList= driver.findElement(By.xpath("//*[text()='Hello, sign in']"));
        Actions actions=new Actions(driver) ;
    //actions.moveToElement(accountList).perform();
        /*
        bir web sitesinde bir mause ile acilan bir web elementine ulasmak istersek actions.moveToElement()methodunu
        kullanmamiz gerekir.Aksi takdirde html kodlari arasinda web elementi bulur ama ulasamadigi icin
        ElementNotInteractableException: element not interactable exception'ı fırlatır
         */

        driver.findElement(By.xpath("//*[text()='Create a List']")).click();


    }
}
