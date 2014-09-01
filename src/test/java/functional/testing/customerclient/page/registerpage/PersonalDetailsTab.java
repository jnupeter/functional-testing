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
public class PersonalDetailsTab extends Tab{

    public PersonalDetailsTab(WebDriver driver, String title) {
        super(driver, title);
    }
    
    //actions
    @Override
    public void clickContinueButton() {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[5]/button[2]")).click();
        HoldOn.seconds(1);
    }

    @Override
    public void clickBackButton() {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[5]/button[1]")).click();
        HoldOn.seconds(1);
    }
    
    public PersonalDetailsTab typeFamilyName(String familyName) {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[1]/div[1]/input")).sendKeys(familyName);
        HoldOn.seconds(1);
        return this;
    }
    
    public PersonalDetailsTab typeGivenName(String givenName) {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[2]/div[1]/input")).sendKeys(givenName);
        HoldOn.seconds(1);
        return this;
    }
    
    public PersonalDetailsTab typeSecondGivenName(String secGivenName) {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[3]/div[1]/input")).sendKeys(secGivenName);
        HoldOn.seconds(1);
        return this;
    }
    
    public PersonalDetailsTab typeDateOfBirth(String dateOfBirth) {
        getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[4]/div[1]/span/input")).sendKeys(dateOfBirth);
        HoldOn.seconds(1);
        return this;
    }
    //helpers
    public String getFamilyNameErrorMsg() {
        return getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[1]/div[2]/span")).getText();
    }

    public String getGivenNameErrorMsg() {
        return getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[2]/div[2]/span")).getText();
    }
    
    public String getSecGivenNameErrorMsg() {
        return getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[3]/div[2]/span")).getText();
    }
    
    public String getDateOfBirthErrorMsg() {
        return getDriver().findElement(By.xpath("/html/body/div[4]/div/div[2]/div[2]/form/div[4]/div[2]/span")).getText();
    }
}
