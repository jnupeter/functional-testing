/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.qtac.admission.webtest;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 */
public class LoginTest {
    private WebDriver driver;

    
    @Before
    public void setup() {
       driver = new FirefoxDriver();
       driver.navigate().to("http://pfdemo-peterdemo101.rhcloud.com/pfdemo/login/login.xhtml");
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void loginPageShouldBeLoaded() {
        LoginPage loginPage = new LoginPage(driver);
        assertEquals("Welcome to our system", loginPage.getTitle());
    }
    
    @Test
    public void errorMessageShouldBeShown() {
        LoginPage loginPage = new LoginPage(driver);
        LoginPage nLoginPage = loginPage.withUsername("peter").withPassword("dd").login();
        assertEquals("Welcome to our system", nLoginPage.getTitle());
        assertTrue(nLoginPage.getResultMessage().contains("error"));
    }
    
    @Test
    public void successfulMessageShouldBeShown() {
        LoginPage loginPage = new LoginPage(driver);
        LoginPage nLoginPage = loginPage.withUsername("peter").withPassword("iampeter").login();
        assertTrue(nLoginPage.getResultMessage().contains("successfully"));
    }
}