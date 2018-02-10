//Страница 3: Страница оформления заявки

package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertEquals;


public class RequestPage {
    WebDriver driver;

    // Инициализация кнопок и параметров ввода
    @FindBy(xpath = "//section[@class='b-form-section']//div[contains(@class,'b-form-box-block')]")
    WebElement minS;
    @FindBy (xpath = "//*[contains(text(),\"Продолжить\")]")
    WebElement endRequest;
    @FindBy(name = "insured0_surname")
    WebElement surname_s;
    @FindBy(name = "insured0_name")
    WebElement name_s;
    @FindBy(name = "insured0_birthDate")
    WebElement birthday_s;
    @FindBy(name = "surname")
    WebElement surname;
    @FindBy(name = "name")
    WebElement name;
    @FindBy(name = "birthDate")
    WebElement birthDate;
    @FindBy(name = "middlename")
    WebElement middlename;
    @FindBy(name = "passport_series")
    WebElement passport_series;
    @FindBy(name = "passport_number")
    WebElement passport_number;
    @FindBy(name = "issueDate")
    WebElement issueDate;
    @FindBy(name = "issuePlace")
    WebElement issuePlace;
    @FindBy(name = "phone")
    WebElement Phone;
    @FindBy(name = "email")
    WebElement Email;
    @FindBy(name = "emailValid")
    WebElement EmailValid;

    public RequestPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void minrequest (String sum) {
        minS.findElement(By.xpath(".//*[contains(text(),'" + sum + "')]")).click();
    }

    public void PressMin () {
        driver.findElement(By.xpath("//span[@class=\"b-button-block-center\"]//*[contains(text(),\"Оформить\")]")).click();
    }


    public void fillField(String fieldName, String value) {
        switch (fieldName){
            case "фамилия застрахованного":
                fillField(surname_s, value);
                break;
            case "имя застрахованного":
                fillField(name_s, value);
                break;
            case "дата рождения застрахованного":
                fillField(birthday_s, value);
                break;
            case "фамилия":
                fillField(surname, value);
                break;
            case "имя":
                fillField(name, value);
                break;
            case "день рождения":
                fillField(birthDate, value);
                break;
            case "отчество":
                fillField(middlename, value);
                break;
            case "серия паспорта":
                fillField(passport_series, value);
                break;
            case "номер паспорта":
                fillField(passport_number, value);
                break;
            case "дата выдачи":
                fillField(issueDate, value);
                break;
            case "место выдачи":
                fillField(issuePlace, value);
                break;
            case "email":
                fillField(Email, value);
                break;
            case "phone":
                fillField(Phone, value);
                break;
            case "emailValid":
                fillField(EmailValid, value);
                break;
            default:
                throw new AssertionError("Поле '"+fieldName+"' не объявлено на странице");
        }
    }




    public void checkFields (String field, String expected){
        switch (field){
            case "фамилия застрахованного":
                Assert.assertEquals(expected, surname_s.getAttribute("value"));
                break;
            case "имя застрахованного":
                Assert.assertEquals(expected, name_s.getAttribute("value"));
                break;
            case "дата рождения застрахованного":
                Assert.assertEquals(expected, birthday_s.getAttribute("value"));
                break;
            case "фамилия":
                Assert.assertEquals(expected, surname.getAttribute("value"));
                break;
            case "имя":
                Assert.assertEquals(expected, name.getAttribute("value"));
                break;
            case "день рождения":
                Assert.assertEquals(expected, birthDate.getAttribute("value"));
                break;
            case "отчество":
                Assert.assertEquals(expected, middlename.getAttribute("value"));
                break;
            case "серия паспорта":
                Assert.assertEquals(expected, passport_series.getAttribute("value"));
                break;
            case "номер паспорта":
                Assert.assertEquals(expected, passport_number.getAttribute("value"));
                break;
            case "дата выдачи":
                Assert.assertEquals(expected, issueDate.getAttribute("value"));
                break;
            case "место выдачи":
                Assert.assertEquals(expected, issuePlace.getAttribute("value"));
                break;
            case "email":
                Assert.assertEquals(expected, Email.getAttribute("value"));
                break;
            case "phone":
                Assert.assertEquals(expected, Phone.getAttribute("value"));
                break;
            case "emailValid":
                Assert.assertEquals(expected, EmailValid.getAttribute("value"));
                break;
            default:
                throw new AssertionError("Поле '"+field+"' не объявлено на странице");
        }

    }
    public void fillField(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void EndRequest (){
        endRequest.click();
    }

    public void checkZP(){
        assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div [text()='Заполнены не все обязательные поля']")).getText());
    }
}