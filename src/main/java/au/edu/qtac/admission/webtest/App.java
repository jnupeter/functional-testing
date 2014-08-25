package au.edu.qtac.admission.webtest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException
    {
        WebDriver driver = new ChromeDriver();
//        WebDriver driver = new InternetExplorerDriver();
        
//        driver.get("http://localhost:8080/admissions-customer-client-1.0-SNAPSHOT/login.xhtml");
        driver.navigate().to("http://localhost:8080/admissions-customer-client-1.0-SNAPSHOT/login.xhtml");
        
        WebElement usernameInput = driver.findElement(By.id("login:email"));
        usernameInput.sendKeys("peter.cai@qtac.edu.au");
        
        WebElement passwordInput = driver.findElement(By.id("login:password"));
        passwordInput.sendKeys("Ctest1234");
        
       //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //WebDriverWait wait10s = new WebDriverWait(driver, 10);
        
        driver.quit();
    }
}
