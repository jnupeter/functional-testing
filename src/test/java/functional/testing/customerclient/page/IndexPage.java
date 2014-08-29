/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.page;

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
public class IndexPage {
    private WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }

    public MyDetailPage clickCreate2015() {
        driver.findElement(By.linkText("Create Application for year 2015")).click();
        return new MyDetailPage(driver);
    }
    public MyDetailPage clickEdit2015() {
        driver.findElement(By.linkText("Edit Application for year 2015")).click();
        return new MyDetailPage(driver);
    }
    
    public String getTitle() {
        return driver.getTitle();
    }
}
