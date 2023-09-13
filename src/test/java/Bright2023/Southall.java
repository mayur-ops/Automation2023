package Bright2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Southall {

    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.southalltravel.co.uk/?gclid=EAIaIQobChMIiebd2LuRgQMVFLztCh1kWABsEAAYASAAEgJYL_D_BwE");
        driver.manage().window().maximize();
    }

    @Test
    public void calender(){
    WebElement dateBox = driver.findElement(By.id("depdateit"));
    dateBox.click();

        List<WebElement> dateLists = driver.findElements(By.cssSelector(".ui-state-default"));
        for(WebElement dateList:dateLists){
            System.out.println(dateList.getText());
            if(dateList.getText().equals("17")){
                dateList.click();
                break;
            }
        }
    }

     @After
    public void tearDown(){
        driver.quit();
    }
}
