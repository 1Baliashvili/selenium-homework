import com.gargoylesoftware.htmlunit.BrowserVersion;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.Test;


import org.openqa.selenium.interactions.Actions;




public class JSexecutor {


    WebDriver driver;
    @Test
    public void hoverAndDelete() throws InterruptedException{


        driver = new HtmlUnitDriver(BrowserVersion.CHROME,true);
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement toDoItem = driver.findElement(By.xpath("//li[text()=' Practice magic']"));
        action.moveToElement(toDoItem);
        action.perform();
//        //System.out.println(driver.getPageSource());
//        //Thread.sleep(2000);
        WebElement element = driver.findElement(By.xpath("//*[@id='container']/ul/li[3]/span"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
//        //Thread.sleep(1000);
       driver.close();
       driver.quit();





    }
    @Test
    public void scrollAndValidate() throws InterruptedException{

        driver = new HtmlUnitDriver(BrowserVersion.CHROME,true);
        driver.get("http://webdriveruniversity.com/Scrolling/index.html");
        driver.manage().window().maximize();

        WebElement entries = driver.findElement(By.xpath("//div[@id='zone2']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",entries);
        String text = js.executeScript("return arguments[0].innerText;",entries).toString();
        System.out.println(text);
        Thread.sleep(10000);
        driver.close();
        driver.quit();





    }

}