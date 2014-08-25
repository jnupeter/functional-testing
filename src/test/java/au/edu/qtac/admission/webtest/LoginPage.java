/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package au.edu.qtac.admission.webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    
    public LoginPage withUsername(String username){
        driver.findElement(By.id("j_idt7:username")).sendKeys(username);
        return this;
    }
    
    public LoginPage withPassword(String password){
        driver.findElement(By.id("j_idt7:password")).sendKeys(password);
        return this;
    }

    public LoginPage login() {
        driver.findElement(By.id("j_idt7:btnLogin")).click();
        System.out.println("todo: wait api.");
        return this;
    }
    
    public String getResultMessage() {
        final String msg = driver.findElement(By.cssSelector("div.ui-growl")).getText();
        return msg;
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}
