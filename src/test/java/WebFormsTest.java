import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebFormsTest {
    @Test
    public void task1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://webdriveruniversity.com/Dropdown-Checkboxes-RadioButtons/index.html ");
        driver.manage().window().maximize();

        Select objSelect = new Select(driver.findElement(By.id("dropdowm-menu-1")));
        objSelect.selectByVisibleText("SQL");
        String a = objSelect.getFirstSelectedOption().getText();
        System.out.println("selected programming language is "+a);
        //Thread.sleep(3000);
        List<WebElement> element = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //System.out.println(name.size());
        for(int i = 0;i< element.size();i++)
        {
            WebElement k = element.get(i);
            if(!(k.isSelected()))
            {
                k.click();
            }
        }
        driver.findElement(By.xpath("//input[@value='yellow']")).click();
        WebElement orng = driver.findElement(By.xpath("//option[@value='orange']"));
        String u = orng.getAttribute("Disabled");
        if(u=="true")
        {
            System.out.println("orange is disabled");

        }
        else System.out.println("orange is enabled");
        //Thread.sleep(10000);
        driver.close();
        driver.quit();
    }
}