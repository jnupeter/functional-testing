/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.test;

import functional.testing.customerclient.page.IndexPage;
import functional.testing.customerclient.page.LoginPage;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
@Ignore
public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;
    
    @Before
    public void beforeTest() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:8080/admissions-customer-client/login.xhtml");
        loginPage = new LoginPage(driver);
    }

    @After
    public void quit() {
        driver.quit();
    }
    
    @Test
    public void shouldBeAbleToLoginSuccessfully() {
        IndexPage indexPage = loginPage.loginWithSuccess("jnupeter@gmail.com", "Ctest5678");
        assertEquals("QTAC online Services", indexPage.getTitle());
    }
    
    @Test
    public void shouldBeAbleToGetErrorMessages() {
        LoginPage lg = loginPage.loginWithFailure("", "");
        assertEquals("This field is mandatory.", lg.getEmailValidationMsg());
        assertEquals("This field is mandatory.", lg.getPasswordValidationMsg());
    }
    
    @Test
    public void shouldBeAbleToGetLoginErrorMessages() {
        LoginPage lg = loginPage.loginWithFailure("jnupeter@gmail.com", "asdf");
        assertTrue(lg.getLoginErrorMessage().contains("Your email address or password is incorrect"));
    }
    
    @Test
    public void shouldAlertOnIncorrectEmailFormat() {
        LoginPage lg = loginPage.loginWithFailure("asf@123", "");
        assertEquals("The format of your email address is invalid.", lg.getEmailValidationMsg());
    }
}
