import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class ActionClassTest {
    @Test
    public void slider(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/slider");
        WebElement element = driver.findElement(By.xpath("//input[@class='range-slider range-slider--primary']"));

        Actions act = new Actions(driver);
        act.dragAndDropBy(element,0,0).perform();
        act.release();
        driver.close();
        driver.quit();
    }
}