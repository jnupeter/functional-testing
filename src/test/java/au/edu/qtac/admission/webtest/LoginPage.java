/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package au.edu.qtac.admission.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
public class LoginPage {

    private WebDriver driver;

    public LoginPage(final WebDriver driver) {
         this.driver = driver;
         if(!driver.getTitle().equals("Welcome to our system")) {
             throw new IllegalStateException("Not on login page");
         }
    }
    
    private LoginPage withUsername(String username){
        driver.findElement(By.id("j_idt7:username")).sendKeys(username);
        return this;
    }
    
    private LoginPage withPassword(String password){
        driver.findElement(By.id("j_idt7:password")).sendKeys(password);
        return this;
    }

    private void login() {
        driver.findElement(By.id("j_idt7:btnLogin")).click();
    }
    
    public LoginPage loginWithFailure(String username, String password) {
        this.withUsername(username).withPassword(password).login();
        return this;
    }
    
    public IndexPage loginWithSuccessfully(String username, String password) {
        this.withUsername(username).withPassword(password).login();
        
        //it is important: it makes Browser to look for the element that 
        //the locator shows, it make driver implicitily waits
        //the most important is to set implicitly waits timeout long enough!!!!
        driver.findElement(By.xpath("//html/body/button"));

        // explicit wait 
//        WebElement e = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>(){
//            @Override
//            public WebElement apply(WebDriver d) {
//                return d.findElement(By.xpath("//html/body/button"));
//            }
//        });

//          Another explicit wait
//        WebDriverWait wait =  new WebDriverWait(driver, 10);
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//html/body/button")));
        return new IndexPage(driver);
    }
    
    public String getResultMessage() {
        final String msg = driver.findElement(By.cssSelector("div.ui-growl-item-container")).getText();
        return msg;
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}
