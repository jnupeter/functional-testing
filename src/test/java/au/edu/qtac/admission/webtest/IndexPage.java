/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package au.edu.qtac.admission.webtest;

import org.openqa.selenium.WebDriver;

/**
 *
 * @author peter
 */
public class IndexPage {

    private WebDriver driver;
    
    public IndexPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public String getTitle() {
        return driver.getTitle();
    }
}
