import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
public class WebElementsTest {
    @Test

    public void task1()throws InterruptedException   {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();

        WebElement Button=driver.findElement(By.xpath("//button[@onclick='addElement()']"));

        for (int i = 0; i <3 ; i++) {
            Button.click();
        }
        Thread.sleep(2000);
        String txt1 = driver.findElement(By.xpath("//button[@onclick='deleteElement()'][3]")).getText();


        System.out.println(txt1);

        String txt2 = driver.findElements(By.cssSelector("button[class^='added']")).get(2).getText();
        System.out.println(txt2);
        String txt3 = driver.findElement(By.xpath("//button[contains(@class,'manually') and text()='Delete'][3]")).getText();
        System.out.println(txt3);


        driver.quit();
    }
    @Test
    public  void table()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/challenging_dom");
        driver.manage().window().maximize();
        String txt4 = driver.findElement(By.xpath("//td[text()='Apeirian9']//parent::tr//child::td[1]")).getText();
        String txt5 = driver.findElement(By.xpath("//td[text()='Apeirian9']//parent::tr//child::td[3]")).getText();
        System.out.println(txt4);
        System.out.println(txt5);
        driver.quit();

    }
}
