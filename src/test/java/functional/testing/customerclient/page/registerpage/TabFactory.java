/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.page.registerpage;

import org.openqa.selenium.WebDriver;

/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
public class TabFactory {

    private TabFactory() {
        //to prevent initialation
    }
    
    public static Tab getTabInstance(WebDriver driver, String title) {
        if(title.equalsIgnoreCase("Login Details")) {
            return new LoginDetailsTab(driver, title);
        } else if (title.equalsIgnoreCase("Personal Details")) {
            return new PersonalDetailsTab(driver, title);
        } else if (title.equalsIgnoreCase("Addresses")) {
            return new AddressesTab(driver, title);
        } else if (title.equalsIgnoreCase("Contact Details")) {
            return new ContactDetailsTab(driver, title);
        } else if (title.equalsIgnoreCase("Security Questions")) {
            return new SecurityQuestionsTab(driver, title);
        } else {
            return null;
        }
    }
}
