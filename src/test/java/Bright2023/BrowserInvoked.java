package Bright2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserInvoked {

    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver","/Users/mayurkumarpatel/Downloads/chromedriver_mac64 (1)/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:10437567247%7cagid:107552644710%7ctid:kwd-18880550%7ccrid:535779513016%7cnw:g%7crnd:5516819416255548165%7cdvc:c%7cadp:%7cmt:e%7cloc:9044952&utm_source=Google&utm_medium=cpc&utm_campaign=10437567247&utm_term=argos%20uk&utm_content=text&utm_custom1=107552644710&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=EAIaIQobChMI9ubSwqmMgQMVmeztCh1dRAnbEAAYASAAEgJIIfD_BwE&gclsrc=aw.ds");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
        driver.quit();
    }
}

class FindElement{
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:10437567247%7cagid:107552644710%7ctid:kwd-18880550%7ccrid:535779513016%7cnw:g%7crnd:5516819416255548165%7cdvc:c%7cadp:%7cmt:e%7cloc:9044952&utm_source=Google&utm_medium=cpc&utm_campaign=10437567247&utm_term=argos%20uk&utm_content=text&utm_custom1=107552644710&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=EAIaIQobChMI9ubSwqmMgQMVmeztCh1dRAnbEAAYASAAEgJIIfD_BwE&gclsrc=aw.ds");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();  //cookies accepts
        WebElement searchbox=driver.findElement(By.className("_1Rz0y"));  // create object
        searchbox.sendKeys("Nike");
        searchbox.submit();
        driver.quit();
    }
}

class FindElementLinktext{
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:10437567247%7cagid:107552644710%7ctid:kwd-18880550%7ccrid:535779513016%7cnw:g%7crnd:5516819416255548165%7cdvc:c%7cadp:%7cmt:e%7cloc:9044952&utm_source=Google&utm_medium=cpc&utm_campaign=10437567247&utm_term=argos%20uk&utm_content=text&utm_custom1=107552644710&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=EAIaIQobChMI9ubSwqmMgQMVmeztCh1dRAnbEAAYASAAEgJIIfD_BwE&gclsrc=aw.ds");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
//        WebElement accountButton=driver.findElement(By.linkText("Account")); // tag have 'href' word used Element name for
//        accountButton.click();

        String URL=driver.getCurrentUrl();
        System.out.println(URL);

        String title=driver.getTitle();
        System.out.println(title);

        WebElement wishlist=driver.findElement(By.linkText("Wishlist"));
        wishlist.click();
        driver.quit();
    }
}

class NavigatePages{

    public static void main(String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().maximize();

        String currentURL=driver.getCurrentUrl();
        System.out.println(currentURL);

        driver.navigate().to("https://sso.teachable.com/secure/42299/identity/login/password");
        String nevigatedURL=driver.getCurrentUrl();
        System.out.println(nevigatedURL);

        driver.navigate().back();
        driver.navigate().forward();

        driver.quit();
    }
}

class Assertion{
    public static void main(String[] args){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://letskodeit.teachable.com/");
        driver.manage().window().maximize();

        String URL=driver.getCurrentUrl();
        System.out.println(URL);

        //Assert.assertEquals(URL,"https://letskodeit.teachable.com/");
        //Assert.assertThat(URL, Matchers.containsString("https://letskodeit.teachable.com/"));
        //Assert.assertThat(URL,Matchers.equalToIgnoringCase("https://letskodeit.teachable.com/"));
        Assert.assertThat(URL,Matchers.endsWith("letskodeit.teachable.com/"));

        driver.quit();
    }
}

class AssertionText{
    public static void main(String[] args){
        //System.setProperty("webdriver.chrome.driver","/Users/mayurkumarpatel/Downloads/chromedriver_mac64 (1)/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:10437567247%7cagid:107552644710%7ctid:kwd-18880550%7ccrid:535779513016%7cnw:g%7crnd:5516819416255548165%7cdvc:c%7cadp:%7cmt:e%7cloc:9044952&utm_source=Google&utm_medium=cpc&utm_campaign=10437567247&utm_term=argos%20uk&utm_content=text&utm_custom1=107552644710&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=EAIaIQobChMI9ubSwqmMgQMVmeztCh1dRAnbEAAYASAAEgJIIfD_BwE&gclsrc=aw.ds");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
        WebElement searchbox=driver.findElement(By.className("_1Rz0y"));  // create object
        searchbox.sendKeys("Nike");
        WebElement searchButton=driver.findElement(By.className("_1gqeQ"));
        searchButton.click();

        String URL=driver.getCurrentUrl();
        System.out.println(URL);
        Assert.assertEquals(URL,"https://www.argos.co.uk/search/nike/?clickOrigin=searchbar:home:term:nike");

//        WebElement nikeWord=driver.findElement(By.xpath("//h1[contains(text(),'nike')]"));
//        String actual=nikeWord.getText();
//        Assert.assertThat(actual,Matchers.containsString("nike"));

        driver.quit();
    }
}
