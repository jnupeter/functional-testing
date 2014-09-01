/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.page.registerpage;

import functional.testing.customerclient.util.HoldOn;
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
public class LoginDetailsTab extends Tab {

    public LoginDetailsTab(WebDriver driver) {
        super(driver);
    }
    public LoginDetailsTab(WebDriver driver, String title) {
        super(driver, title);
    }
    
    //actions
    @Override
    public void clickContinueButton() {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[5]/button")).click();
        HoldOn.seconds(1);
    }

    @Override
    public void clickBackButton() {
        throw new UnsupportedOperationException("No Back button on this tab.");
    }

    public LoginDetailsTab typeEmail(String email) {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[1]/div[1]/input")).sendKeys(email);
        HoldOn.seconds(1);
        return this;
    }
    
    public LoginDetailsTab reTypeEmail(String email) {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[2]/div[1]/input")).sendKeys(email);
        HoldOn.seconds(1);
        return this;
    }
    
    public LoginDetailsTab typePassword(String password) {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[3]/div[1]/input")).sendKeys(password);
        HoldOn.seconds(1);
        return this;
    }
    
    public LoginDetailsTab reTypePassword(String password) {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[4]/div[1]/input")).sendKeys(password);
        HoldOn.seconds(1);
        return this;
    }
    
    //helpers
    public String getEmailValidationErrorMsg() {
        return getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[1]/div[2]/span")).getText();
    }
    
    public String getRetypeEmailValidationErrorMsg() {
        return getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[2]/div[2]/span")).getText();
    }
    
    public String getPasswordValidationErrorMsg() {
       return getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[3]/div[2]/span")).getText();         
    }
    
    public String getRetypePasswordErrorMsg() {
        return getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[1]/form/div[4]/div[2]/span")).getText(); 
    }
   
}
