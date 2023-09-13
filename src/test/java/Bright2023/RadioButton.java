package Bright2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().maximize();
        WebElement practice=driver.findElement(By.linkText("Practice"));
        practice.click();
        WebElement PracticeURL=driver.findElement(By.linkText("https://www.letskodeit.com/practice"));
        PracticeURL.click();
    }

    @Test
    public void RadioButton(){
        WebElement BMW=driver.findElement(By.id("bmwradio"));
        BMW.click();
        Assert.assertTrue(BMW.isSelected());

        WebElement Benz=driver.findElement(By.id("benzradio"));
        Benz.click();
        Assert.assertTrue(Benz.isSelected());
    }

    @Test
    public void javaScriptScroll() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1900);");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-1700);");
        Thread.sleep(2000);

        WebElement mouseHover = driver.findElement(By.id("mousehover"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView(true);",mouseHover);
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-190);");
    }

    @After
    public void teardown(){
        driver.quit();
    }
}
