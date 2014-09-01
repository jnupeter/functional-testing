/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.page.registerpage;

import org.openqa.selenium.WebDriver;

/**
 * A page object represents Accordian Tab
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
public abstract class Tab {
    
    private WebDriver driver;
    private String title;
    private boolean currentTab;
    
    public Tab(WebDriver driver) {
        this.driver = driver;
    }
    
    public Tab(WebDriver driver, String title) {
        this.driver = driver;
        this.title = title;
    }
    
    //actions
    public abstract void clickContinueButton();
    public abstract void clickBackButton();
    
    //helpers
    public String getTitle() {
        return this.title;
    }
    
    public boolean isCurrentTab() {
        return this.currentTab;
    }
    
    public void setCurrentTab(boolean currentTab) {
        this.currentTab = currentTab;
    }
    
    protected WebDriver getDriver() {
        return driver;
    }
}
