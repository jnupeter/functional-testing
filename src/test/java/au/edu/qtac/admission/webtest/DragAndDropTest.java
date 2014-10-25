/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.qtac.admission.webtest;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author peter
 */
@Ignore
public class DragAndDropTest {
   private WebDriver driver;
   
    @Before
    public void loadPage() {
         driver = new FirefoxDriver();
    }
    
    @After
    public void closeBrowser() {
        driver.quit();
    }
    
    @Test
    public void shouldBeAbleToDragAndDrop() {
        driver.navigate().to("http://pfdemo-peterdemo101.rhcloud.com/pfdemo/dragdrop.xhtml");
        Actions builder = new Actions(driver);
        
//        Action dragAndDrop = builder.clickAndHold(driver.findElement(By.id("j_idt11_header")))
//                .moveByOffset(100, 300).release().build();
        
        
        Action dragAndDrop = builder.dragAndDrop(driver.findElement(By.className("ui-draggable")),
                driver.findElement(By.className("ui-droppable"))).build();
        
        dragAndDrop.perform();
       
        try {
           Thread.sleep(5000);
        } catch (InterruptedException ex) {
           Logger.getLogger(DragAndDropTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
