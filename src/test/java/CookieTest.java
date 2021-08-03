import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.Driver;
import java.util.Iterator;
import java.util.Set;

public class CookieTest {
    WebDriver driver;


    public CookieTest() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.chromedriver().proxy("192.168.100.50:3128");
        driver = new ChromeDriver();
    }

    @Test
    public void getCookies() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("http://demo.guru99.com/test/cookie/selenium_aut.php");
        //driver.switchTo().frame(0);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Baliashvili");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("bachana12341");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        Thread.sleep(4000);

        Set<Cookie> cookies = driver.manage().getCookies();
        for (Cookie value : cookies)
        {
            if(value.getName().equals("Selenium"))
            {
                //Cookie delitem = driver.manage().getCookieNamed("Selenium");
                driver.manage().deleteCookieNamed("Selenium");
            }
            if(value.getExpiry()==null)
            {
                driver.manage().deleteCookieNamed(value.getName());
            }

        }
        cookies = driver.manage().getCookies();
        for (Cookie value : cookies) {
            System.out.println(value.getName()
                    + ", " + value.getValue());
            System.out.println();
        }
        driver.quit();


//    }
    }
}