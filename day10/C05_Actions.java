package day10;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBaseBeforeAfter;

public class C05_Actions extends TestBaseBeforeAfter {

    @Test
    public void test1() {

        //https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
         //"Drag me" butonunu tutup "Drop here" kutusunun ustune birakalim
       WebElement dragme =driver.findElement(By.xpath("//*[@id='draggable']"));
       WebElement dropme=driver.findElement(By.xpath("(//*[@id='droppable'])[1]"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(dragme,dropme).perform();
        Assert.assertEquals("dropped!",driver.findElement(By.xpath("//*[text()='Dropped!']")).getText());




    }
}