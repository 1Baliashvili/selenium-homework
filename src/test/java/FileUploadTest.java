import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class FileUploadTest {
    WebDriver driver;
    public FileUploadTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void uploading() throws InterruptedException{
        driver.get("http://the-internet.herokuapp.com/upload ");
        driver.manage().window().maximize();
        WebElement uploadInput = driver.findElement(By.xpath("//input[@id='file-upload']"));
        uploadInput.sendKeys("C:\\Users\\Administrator\\Downloads\\selenium.png");
        driver.findElement(By.xpath("//input[@id='file-submit']")).click();
        Thread.sleep(2000);

        try {
            uploadInput.sendKeys("C:\\Users\\Administrator\\Downloads\\selenium.png");
        }
        catch (StaleElementReferenceException e)
        {
            System.out.println(e.getMessage());
        }






    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}