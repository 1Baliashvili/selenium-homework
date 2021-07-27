import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
public class SwitchToTest {
    @Test
    public void task1() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/iframe ");
        driver.manage().window().maximize();
        driver.switchTo().frame("mce_0_ifr");
        System.out.println(driver.getPageSource());
        WebElement k = driver.findElement(By.xpath("//p"));
        String text = k.getText();
        for(int i = 0;i<text.length();i++)
        {
            k.sendKeys(Keys.BACK_SPACE);
        }
        k.sendKeys("Here Goes");
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//button[@title='Align center']")).click();
        System.out.println(driver.getPageSource());
        driver.navigate().to("https://demoqa.com/alerts");
        driver.findElement(By.xpath("//button[@id='alertButton']")).click();
        Thread.sleep(1000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);




        driver.quit();
    }
}
