//Страница 1: Главная страница

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.BaseStep;


public class MainPage {
    WebDriver driver;

    @FindBy(xpath = "//div[contains(@class,'bp-area header-container')]")
    WebElement menu;



    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void waitElement (WebElement element) {
        Wait<WebDriver> wait = new WebDriverWait(BaseStep.getDriver(), 30, 1000);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void selectSection (String name) {
        menu.findElement(By.xpath(".//a[@aria-label='Раздел " + name +"']")).click();
    }

    public void travelInsurance (String name) {
        menu.findElement(By.xpath(".//a[contains(text(),'" + name + "')]")).click();
    }

    public WebElement getTravelInsuranceElement (String name) {
        return menu.findElement(By.xpath(".//a[contains(text(),'" + name + "')]"));
    }


}