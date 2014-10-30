/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package au.edu.qtac.admission.webtest;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import test.rule.ScreenOnFailureTestCase;

/**
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 */

public class LoginTest extends ScreenOnFailureTestCase {
    private WebDriver driver;
    protected static DesiredCapabilities dCaps;
    
    @Rule
    public TestRule getRule() {
        return this;
    }
    
    @Override
    public void before() throws Throwable {
//       driver = new FirefoxDriver();
       dCaps = new DesiredCapabilities();
       dCaps.setJavascriptEnabled(true);
       dCaps.setCapability("takesScreenshot", true);
       System.setProperty("phantomjs.binary.path",new File("src/test/resources/phantomjs_driver/phantomjs.exe").getAbsolutePath());
       driver = new PhantomJSDriver(dCaps);
               
       driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
       driver.navigate().to("http://pfdemo-peterdemo101.rhcloud.com/pfdemo/login/login.xhtml");
    }
    
    @Test
    public void loginPageShouldBeLoaded() {
        LoginPage loginPage = new LoginPage(driver);
        assertEquals("Welcome to our system", loginPage.getTitle());
    }
    
    @Test
    public void errorMessageShouldBeShown() {
        LoginPage loginPage = new LoginPage(driver);
        LoginPage nLoginPage = loginPage.loginWithFailure("peter", "dd");
        assertEquals("Welcome to our system", nLoginPage.getTitle());
        assertTrue(nLoginPage.getResultMessage().contains("error"));
    }
    
    @Test
    public void successfulMessageShouldBeShown() {
        LoginPage loginPage = new LoginPage(driver);
        IndexPage ip = loginPage.loginWithSuccessfully("peter", "iampeter");
        System.out.println("new title:" + ip.getTitle());
        assertEquals("Welcome Online Service", ip.getTitle());
    }


    @Override
    public void after() {
        driver.quit();
    }

    @Override
    protected WebDriver getDriver() {
        return this.driver;
    }
}