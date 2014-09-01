/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.page;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
        if (!"Customer Login".equals(driver.getTitle())) {
            throw new IllegalStateException("Not on login page.");
        }
    }
    
    private LoginPage withUsername(String username) {
        driver.findElement(By.id("login_form:email")).sendKeys(username);
        return this;
    }
    
    private LoginPage withPassword(String password) {
        driver.findElement(By.id("login_form:password")).sendKeys(password);
        return this;
    }
    
    private void login() {
        driver.findElement(By.id("login_form:loginBtn")).click();
    }
    
    private void loginAs(String username, String password) {
        this.withUsername(username).withPassword(password).login();
    }
    
    public LoginPage loginWithFailure(String username, String password) {
        this.loginAs(username, password);
        return this;
    }
    
    public IndexPage loginWithSuccess(String username, String password) {
        this.loginAs(username, password);
        //wait until Logout button is present
        driver.findElement(By.xpath("/html/body/form/input[2]"));
        return new IndexPage(driver);
    }
    
    public RegisterPage clickRegisterAccount() {
        driver.findElement(By.linkText("Register New Account")).click();
        //wait until
        driver.findElement(By.id("registerAPanel"));
        return new RegisterPage(driver);
    }

    //helper
    public String getEmailValidationMsg() {
        final String msg = driver.findElement(By.xpath("/html/body/div[4]/div/form/fieldset/div[1]/div[2]/span")).getText();
        return msg;
    }
    
    public String getPasswordValidationMsg() {
        final String msg = driver.findElement(By.xpath("/html/body/div[4]/div/form/fieldset/div[2]/div[2]/span")).getText();
        return msg;
    }
    
    public String getLoginErrorMessage() {
        final String msg = driver.findElement(By.xpath("/html/body/div[4]/div/form/div[1]/div")).getText();
        return msg;
    }
}
