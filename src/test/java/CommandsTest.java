import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class CommandsTest {
    @Test
    
    public void task1()throws InterruptedException   {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        Thread.sleep(4000);
        boolean input_is_enabled = driver.findElement(By.xpath("//input[@type='text']")).isEnabled();
        System.out.println("input is enabled - "+input_is_enabled);
        System.out.println("text 'It's enabled!' is displayed - " + driver.getPageSource().contains("It's enabled!"));
        String button_text = driver.findElement(By.xpath("//button[@onclick='swapInput()']")).getText();
        System.out.println("now button text is "+button_text);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bootcamp");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public  void yCoordinate()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        driver.manage().window().maximize();
        WebElement columnA = driver.findElement(By.id("column-a"));
        WebElement columnB = driver.findElement(By.id("column-b"));
        Point locationA = columnA.getLocation();
        int yA = locationA.getY();
        Point locationB = columnB.getLocation();
        int yB = locationB.getY();
        System.out.println("column a - "+ yA + " column b - " + yB);
        if(yA==yB)
        {
            System.out.println("y coordinate of both columns are the same");
        }
        else
        {
            System.out.println("y coordinates are different");

        }
        driver.quit();

    }
}
