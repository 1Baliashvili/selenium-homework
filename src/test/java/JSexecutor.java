import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
public class JSexecutor {
    WebDriver driver;
    public JSexecutor() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void hoverAndDelete() throws InterruptedException{
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement toDoItem = driver.findElement(By.xpath("//li[text()=' Practice magic']"));
        action.moveToElement(toDoItem);
        action.perform();
        System.out.println(driver.getPageSource());
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("$('i.fa.fa-trash').last().click()");
        Thread.sleep(1000);





    }
    @Test
    public void scrollAndValidate() throws InterruptedException{
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        driver.manage().window().maximize();

        WebElement entries = driver.findElement(By.xpath("//div[@id='zone2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",entries);
        String text = js.executeScript("return arguments[0].innerText;",entries).toString();
        System.out.println(text);
        Thread.sleep(10000);





    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}