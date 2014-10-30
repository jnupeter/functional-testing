/*
 * Copyright (c) 2013 QTAC
 * This work contains proprietary information of QTAC.
 * Distribution is limited to authorised licensees of QTAC. Any unauthorised
 * reproduction or distribution of this work is strictly prohibited.
 */

package test.rule;

import java.io.File;
import java.io.FileOutputStream;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;
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
public abstract class ScreenOnFailureTestCase implements TestRule {
     public Statement apply(final Statement statement, final Description d) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                try {
                    before(); //mind that before() throws Throwable too
                    statement.evaluate();
                } catch (Throwable t) {
                    takeScreenShot(getDriver(), getName(d.getClassName(), d.getMethodName()));
                    throw t;
                } finally {
                    after();
                }
            }
        };
    }
    
    private String getName(String className, String methodName) {
        return className.substring(className.lastIndexOf(".") + 1) + "_" + methodName;
    }

    private void takeScreenShot(WebDriver driver, String fileName) {
        try {
            new File("target/surefire-reports/screenshots/").mkdirs();
            FileOutputStream out = new FileOutputStream("target/surefire-reports/screenshots/" + fileName + ".png");
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
            System.out.println("Screenshot saved. (" + fileName + ".png).");
        } catch (Exception e) {
            System.err.println("Failed to save screenshot. (" + fileName + ".png).");
        }
    }
    
    public abstract void before() throws Throwable;
    public abstract void after();
    protected abstract WebDriver getDriver();
}
