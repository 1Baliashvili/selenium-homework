import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablesTest {
    WebDriver driver;
    public WebTablesTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void hondaPrice() {
        driver.get("http://techcanvass.com/Examples/webtable.html");
        driver.manage().window().maximize();
        String price = driver.findElement(By.xpath("//td[text()='Honda']//parent::tr//child::td[3]")).getText();
        System.out.println(price);



    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}