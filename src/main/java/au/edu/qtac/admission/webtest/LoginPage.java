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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
    
    @FindBy(id="login_form:email")
    private WebElement username;
    
    @FindBy(id="login_form:password")
    private WebElement password;
    
    @FindBy(name="login_form:loginBtn")
    private WebElement loginButton;
    
    public void setDriver(WebDriver driver){
        this.driver = driver;
    }
    
    public LoginPage withUsername(String username){
        this.username.sendKeys(username);
          return this;
    }
    
    public LoginPage withPassword(String password){
        this.password.sendKeys(password);
        return this;
    }
    
    public void login(){
       loginButton.click();
       (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
          public Boolean apply(WebDriver d){
             return d.getTitle().toLowerCase().startsWith("qtac");
          }
       });
    }
    
    public void open(String url){
        driver.get(url);
    }
    
    public void close(){
        driver.quit();
    }
    
    public String getTitle(){
        return driver.getTitle();
    }
}
