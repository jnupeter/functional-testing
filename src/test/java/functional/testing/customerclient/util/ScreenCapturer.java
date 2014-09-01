/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package functional.testing.customerclient.util;

import functional.testing.customerclient.test.RegisterTest;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * <p>
 * 
 *
 * @author Peter Cai <peter.cai@qtac.edu.au>
 * @version %I%,%G%
 * @since 1.0
 */
public class ScreenCapturer {
    private ScreenCapturer() {
        
    }

    public static void takeAShot(WebDriver driver, String filename) {
        File passwordChecked = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File failureImageFile = new File("target/" + filename);
        try {
            FileUtils.moveFile(passwordChecked, failureImageFile);
        } catch (IOException ex) {
            Logger.getLogger(RegisterTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
