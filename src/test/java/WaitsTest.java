import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitsTest {
    @Test
    public void task1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/progress-bar");
        driver.manage().window().maximize();

        driver.findElement(By.id("startStopButton")).click();


        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver)
            {
                return driver.findElement(By.xpath("//div[@class='progress-bar bg-success']")).getText()!="100%";
            }
        });

        System.out.println((driver.findElement(By.xpath("//div[@class='progress-bar bg-success']")).getText()));




        driver.quit();
    }
}