import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;;
import org.testng.annotations.Test;

public class BonusHomeWorkTest {
    @Test
    public void flipkarttask(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://www.flipkart.com/");

        driver.findElement(By.xpath("//input[@class='_2IX_2- VJZDxU']")).sendKeys("Bachana Baliashvili");
        driver.findElement(By.xpath("//div/input[@type='password']")).sendKeys("987632");
        driver.findElement(By.xpath("//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")).click();

        WebElement element = driver.findElement(By.xpath("//span[@class='_2YULOR']"));
        if (element.getText().equals("Please enter valid Email ID/Mobile number")){
            System.out.println("It is not Valid");
        }
        driver.close();
        driver.quit();
    }
}