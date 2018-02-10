//Страница 2: Страхование путешественников

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


import static org.junit.Assert.assertEquals;


public class InsuranceTravelPage {
    WebDriver driver;

    public InsuranceTravelPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void changeWindow (){
        driver.findElement(By.xpath("//a//img [contains(@src,'banner-zashita-traveler')]")).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
    public void checkSP(){
        assertEquals("Страхование путешественников",
                driver.findElement(By.xpath("//div[@class='sbrf-rich-outer']//h1")).getText());

    }

}