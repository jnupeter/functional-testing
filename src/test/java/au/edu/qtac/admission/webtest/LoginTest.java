/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.qtac.admission.webtest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

/**
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 */
public class LoginTest {
    
  
    private LoginPage loginPage;
    
    private WebDriver driver;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void openPage(){
        driver = new FirefoxDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        
//        loginPage = new LoginPage();
        loginPage.setDriver(driver);
    }
    
    @After
    public void closePage(){
        loginPage.close();
    }
    
    @Test
    public void loginPageShouldBeLoaded(){
        loginPage.open("http://localhost:8080/admissions-customer-client/");
        assertEquals("Customer Login", loginPage.getTitle());
    }
    
    @Test
    public void loginShouldSucceed(){
        loginPage.open("http://localhost:8080/admissions-customer-client/");
        
        
        loginPage.withUsername("peter.cai@qtac.edu.au").withPassword("Ctest1234");
    }
}