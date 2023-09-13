package Bright2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ArgosRadioButtons {
    public static WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:10437567247%7cagid:107552644710%7ctid:kwd-18880550%7ccrid:535779513016%7cnw:g%7crnd:5516819416255548165%7cdvc:c%7cadp:%7cmt:e%7cloc:9044952&utm_source=Google&utm_medium=cpc&utm_campaign=10437567247&utm_term=argos%20uk&utm_content=text&utm_custom1=107552644710&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=EAIaIQobChMI9ubSwqmMgQMVmeztCh1dRAnbEAAYASAAEgJIIfD_BwE&gclsrc=aw.ds");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
        WebElement searchbox=driver.findElement(By.className("_1Rz0y"));  // create object
        searchbox.sendKeys("Nike");
//        WebElement searchButton=driver.findElement(By.className("_1gqeQ"));
//        searchButton.click();
    }

    @Test
    public void argosRadioButtons(){
        List<WebElement> nikeStarRadioButtons = driver.findElements(By.cssSelector(".RadioListstyles__Label-sc-1atiffa-5.iGLFSX"));
        for(WebElement nikeStarRadioButton:nikeStarRadioButtons){
            System.out.println(nikeStarRadioButton.getAttribute("id"));
            if(nikeStarRadioButton.getAttribute("id").contains("3 or more-label")){
                nikeStarRadioButton.click();
            }
        }
    }

    @Test
    public void searchDropdownSelect(){
        List<WebElement> searchResults = driver.findElements(By.cssSelector("._3a8zN"));
        for (WebElement searchResult:searchResults){
            System.out.println(searchResult.getText());
            if(searchResult.getText().contains("cloud nine")){
                searchResult.click();
                //Assertion steps below
                String result = driver.findElement(By.id("searchTerm")).getAttribute("value");
                Assert.assertEquals(result,"cloud nine");
                break;
            }
        }
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
