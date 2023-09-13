package Bright2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PriceRangeAssertion {

    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver","/Users/mayurkumarpatel/Downloads/chromedriver_mac64 (1)/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("https://www.argos.co.uk/?&_$ja=tsid:11705%7cacid:224-060-0086%7ccid:10437567247%7cagid:107552644710%7ctid:kwd-18880550%7ccrid:535779513016%7cnw:g%7crnd:5516819416255548165%7cdvc:c%7cadp:%7cmt:e%7cloc:9044952&utm_source=Google&utm_medium=cpc&utm_campaign=10437567247&utm_term=argos%20uk&utm_content=text&utm_custom1=107552644710&utm_custom2=224-060-0086&cmpid=GG05X&GPDP=true&gclid=EAIaIQobChMI9ubSwqmMgQMVmeztCh1dRAnbEAAYASAAEgJIIfD_BwE&gclsrc=aw.ds");
        driver.manage().window().maximize();
        driver.findElement(By.id("consent_prompt_submit")).click();
        WebElement searchbox = driver.findElement(By.className("_1Rz0y"));  // create object
        searchbox.sendKeys("puma");
        WebElement searchButton = driver.findElement(By.className("_1gqeQ"));
        searchButton.click();

        List<WebElement> checkBoxes = driver.findElements(By.cssSelector(".Checkboxstyles__CheckboxOption-b61uwr-3.cKQGxN"));
        for(WebElement checkBoxe : checkBoxes){
            System.out.println(checkBoxe.getText());
            if (checkBoxe.getText().contains("£10 - £15"));
            checkBoxe.click();
            break;
        }
        Thread.sleep(2000);
        List<WebElement> priceranges = driver.findElements(By.cssSelector(".ProductCardstyles__ValueMessagingContainer-h52kot-14.ejTbAz"));
        for(WebElement pricerange : priceranges){
            System.out.println(pricerange.getText());

            String pricewithoutpound = pricerange.getText().replace("£", "");
            double Priceindouble = Double.parseDouble(pricewithoutpound);
            System.out.println(Priceindouble);
            Assert.assertThat(Priceindouble, Matchers.greaterThanOrEqualTo(10.00));
            Assert.assertThat(Priceindouble, Matchers.lessThanOrEqualTo(15.00));
        }

        driver.quit();

//        WebElement priceCheckBox = driver.findElement(By.xpath("//body/main[@id='app']/div[1]/div[3]/div[6]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/div[1]/div[1]/*[1]"));
//        priceCheckBox.click();
//
//        Thread.sleep(2000);
//        WebElement postcodecross = driver.findElement(By.xpath("//*[@id=\"findability\"]/div[6]/div/div[5]/div[2]/div/div/div/div[2]/div[2]/button/svg/path"));
//        postcodecross.click();
//
//        WebElement pricerange = driver.findElement(By.linkText("£25.00"));
//        pricerange.click();
//
//        WebElement priceText = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/main[1]/div[2]/div[2]/div[1]/section[2]/section[1]/ul[1]"));
//        priceText.getText();
//
//        //double Priceindouble = Double.parseDouble(price);
//        //System.out.println(Priceindouble);
//
//
////        String price = pricerange.getText();
////            System.out.println(price);
////
////            String pricewithoutpound = pricerange.getText().replace("£","");
////
////            double Priceindouble = Double.parseDouble(pricewithoutpound);
////            System.out.println(Priceindouble);
////
////            Assert.assertThat(Priceindouble,Matchers.greaterThanOrEqualTo(25.00));
////            Assert.assertThat(Priceindouble,Matchers.lessThanOrEqualTo(50.00));
////
    }
}
