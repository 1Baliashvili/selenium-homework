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

public class Exceptions {
    WebDriver driver;
    public Exceptions() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void dateExceptions() throws InterruptedException{
        driver.get("https://jqueryui.com/datepicker/ ");
        driver.manage().window().maximize();
        try {
            driver.switchTo().frame(0);
            //System.out.println(driver.getPageSource());
            driver.findElement(By.xpath("//input[@id='datepicker']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[@title='Prev']")).click();
            Thread.sleep(1000);
            //System.out.println(driver.getPageSource());
            String lastDay =   driver.findElement(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr[last()]//td[@data-handler='selectDay'][last()]//child::a")).getText();
            System.out.println(lastDay);
        }
        catch(NoSuchFrameException  e){
            System.out.println("no such frame");
            System.out.println(e.getMessage());
        }





    }
        @Test
        public void alertException() throws InterruptedException{
            driver.get("https://demoqa.com/alerts ");
            driver.manage().window().maximize();


            WebElement element = driver.findElement(By.id("timerAlertButton"));
            element.click();

            //Try to invoke TimeOutException exception

            try {
                WebDriverWait waitForDialog = new WebDriverWait(driver, 3);
                waitForDialog.until(ExpectedConditions.alertIsPresent());

                driver.switchTo().alert().accept();
            }
            catch (TimeoutException e)
            {
                System.out.println(e.getMessage());
            }
            //Try to avoid NoAlertPresentException and Handle possible exception
            try {
                WebElement element1 = driver.findElement(By.id("timerAlertButton"));
                element1.click();
                driver.navigate().refresh();
                driver.switchTo().alert().accept();
            }
            catch (NoAlertPresentException e)
            {
                System.out.println(e.getMessage());
            }

            //Try to invoke StaleElementReferenceException
            try {
                WebElement element2 = driver.findElement(By.id("timerAlertButton"));
                driver.navigate().to("https://facebook.com");
                element2.click();
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