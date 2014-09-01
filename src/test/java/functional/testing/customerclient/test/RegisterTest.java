/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.test;

import functional.testing.customerclient.page.LoginPage;
import functional.testing.customerclient.page.RegisterPage;
import functional.testing.customerclient.page.registerpage.LoginDetailsTab;
import functional.testing.customerclient.page.registerpage.Tab;
import functional.testing.customerclient.util.ScreenCapturer;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;
import org.junit.Ignore;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
public class RegisterTest {

    private WebDriver driver;
    private RegisterPage rp;
    
    @Before
    public void setup() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("http://localhost:8080/admissions-customer-client/login.xhtml");
        LoginPage lp = new LoginPage(driver);
        rp = lp.clickRegisterAccount();
    }
    
    @Test
    public void shouldLoadRegisterPageCorrectly() {
        List<Tab> tabsOnRegisterPage = rp.getTabs();
        assertEquals("There should be 5 Tabs on register page.", 5, tabsOnRegisterPage.size());
        assertEquals("First Tab should be Login Details.", "Login Details", tabsOnRegisterPage.get(0).getTitle());
        assertEquals("Second Tab should be Personal Details.", "Personal Details", tabsOnRegisterPage.get(1).getTitle());
        assertEquals("Third Tab should be Addresses.", "Addresses", tabsOnRegisterPage.get(2).getTitle());
        assertEquals("First Tab should be Contact Details.", "Contact Details", tabsOnRegisterPage.get(3).getTitle());
        assertEquals("First Tab should be Security Questions.", "Security Questions", tabsOnRegisterPage.get(4).getTitle());
    }
    
    @Test
    public void loginDetailsShouldBeAbleToValid(){
        Tab currentTab = rp.getCurrentTab();
        assertEquals("Login Details", currentTab.getTitle());
        LoginDetailsTab lt = (LoginDetailsTab)currentTab;
        lt.clickContinueButton();
        
        assertEquals("email should be valided.", "This field is mandatory.", lt.getEmailValidationErrorMsg());
        assertEquals("retype email should be valided.", "This field is mandatory.", lt.getRetypeEmailValidationErrorMsg());
        assertEquals("password should be valided.", "This field is mandatory.", lt.getPasswordValidationErrorMsg());
        assertEquals("retype password should be valided.", "This field is mandatory.", lt.getRetypePasswordErrorMsg());
    }

    @Test
    public void loginDetailsPasswordStrenghtShouldBeChecked() {
        LoginDetailsTab lt = (LoginDetailsTab) rp.getCurrentTab();
        lt.typeEmail("ab@asfd.net").reTypeEmail("ab@asfd.net").typePassword("1234").reTypePassword("1234").clickContinueButton();

        //take a screen shot
        ScreenCapturer.takeAShot(driver, "passwordCheckedError.png");
        //        assertEquals("Login Details", rp.getCurrentTab().getTitle()); // still on Login Tabs
        assertEquals("password errormesssge is not correct.", "Your password must contain at least 1 lower case characters, 1 upper case characters and at least 1 number or special character (~!@#$) and a minimum of 8 characters.", lt.getPasswordValidationErrorMsg());
    }
    
    @Test
    public void loginDetailsShouldBeAblePassToNextTab() {
        LoginDetailsTab lt = (LoginDetailsTab) rp.getCurrentTab();
        lt.typeEmail("abc@cde.net").reTypeEmail("abc@cde.net").typePassword("Ctest1234").reTypePassword("Ctest1234").clickContinueButton();
        
        //take a photo
        ScreenCapturer.takeAShot(driver, "shouldBeOnNextTab.png");
        Tab newCurrentTab = rp.getCurrentTab();
        assertEquals("Should be on Personal Details tab now.", "Personal Details", newCurrentTab.getTitle());
        ScreenCapturer.takeAShot(driver, "shouldBeOnNextTab2.png");
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
