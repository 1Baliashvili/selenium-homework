import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class AutoComplete {
    @Test

    public void auto()throws InterruptedException   {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Automation");

        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("UUbT9")));
        List<WebElement> suggestions =  driver.findElements(By.xpath("//ul[@role='listbox']/li"));

        Thread.sleep(5000);
        suggestions.get(suggestions.size()-1).click();
        Thread.sleep(5000);





        driver.quit();
    }
}
