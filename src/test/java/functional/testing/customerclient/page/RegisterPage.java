/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.page;

import functional.testing.customerclient.page.registerpage.Tab;
import functional.testing.customerclient.page.registerpage.TabFactory;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
public class RegisterPage {

    private WebDriver driver;
    
    public RegisterPage(WebDriver driver) {
       this.driver = driver;
    }
    
    //helpers
    public List<Tab> getTabs() {
        List<Tab> tabs = new ArrayList<Tab>();
        
        //get header for Tabs
        List<WebElement> headers = driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/h3"));
        //get body for Tabs
        List<WebElement> bodies = driver.findElements(By.xpath("/html/body/div[4]/div/div[2]/div"));
        if(headers.size() != bodies.size()) {
            throw new IllegalStateException("Accordion not rendered correctly.");
        }
        for(int i = 0; i < headers.size(); i++) {
            final String headerText = headers.get(i).getText();
            Tab t = TabFactory.getTabInstance(driver, headerText);
            if (bodies.get(i).isDisplayed()) {
                t.setCurrentTab(true);
            }
            tabs.add(t);
        }
        return tabs;
    }
    
    public Tab getCurrentTab() {
        for(Tab t : getTabs()) {
            if(t.isCurrentTab()) {
                return t;
            }
        }
        return null; //should not happen
    }
}
