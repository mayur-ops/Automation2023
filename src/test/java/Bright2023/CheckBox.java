package Bright2023;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckBox {
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
    public void checkBox(){
        WebElement bmwCheckbox=driver.findElement(By.id("bmwcheck"));
        bmwCheckbox.click();
        Assert.assertTrue(bmwCheckbox.isSelected());

        WebElement benzCheckbox=driver.findElement(By.id("benzcheck"));
        benzCheckbox.click();
        Assert.assertTrue(benzCheckbox.isSelected());
    }

    @Test
    public void listOfElementsRadioButtons(){
        List<WebElement> radioButtons=driver.findElements(By.cssSelector("input[type=radio]"));  // common locator

        for(WebElement radioButton:radioButtons){
            System.out.println(radioButton.getAttribute("value"));
           if(radioButton.getAttribute("value").contains("benz")){
                radioButton.click();
                break;
           }
        }
    }

    @Test
    public void listOfElementsCheckBox(){
        List<WebElement> checkboxes=driver.findElements(By.cssSelector("input[type=checkbox]"));

        for(WebElement checkbox:checkboxes){
            System.out.println(checkbox.getAttribute("value"));
            if(checkbox.getAttribute("value").contains("benz")){
                checkbox.click();
                Assert.assertTrue(checkbox.isSelected());
            }
        }
    }

    @Test
    public void dropDownSelect(){
        WebElement dropDownBox = driver.findElement(By.id("carselect"));
        dropDownBox.click();

        Select sel= new Select(dropDownBox);
        sel.selectByIndex(0);
        sel.selectByValue("benz");
        sel.selectByVisibleText("Honda");

        List<WebElement> options = sel.getAllSelectedOptions();
        for(WebElement option:options){
            System.out.println(option.getText());
        }

    }

    @Test
    public void multipleSelect(){
        WebElement multipleSelect = driver.findElement(By.id("multiple-select-example"));
        multipleSelect.click();

        Select sel = new Select(multipleSelect);
        sel.selectByIndex(0);
        sel.deselectByIndex(0);
        sel.selectByValue("orange");
        sel.deselectByValue("orange");
        sel.selectByVisibleText("Peach");
        sel.deselectByVisibleText("Peach");

        List<WebElement> options = sel.getOptions();  // sel object used for options

        for(WebElement option:options){
            System.out.println(option.getText());
        }
    }

    @After
    public void teardown(){
        driver.quit();
    }

}
