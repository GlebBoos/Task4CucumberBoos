//Сценарий №1
//        1.Перейти на страницу http://www.sberbank.ru/ru/person
//        2.Нажать на – Застраховать себя и имущество
//        3.Выбрать – Страхование путешественников
//        4.Проверить наличие на странице заголовка – Страхование путешественников
//        5.Нажать на – Оформить Онлайн
//        6.На вкладке – Выбор полиса  выбрать сумму страховой защиты – Минимальная
//        7.Нажать Оформить
//        8.На вкладке Оформить заполнить поля:
//          •Фамилию и Имя, Дату рождения застрахованных
//          •Данные страхователя: Фамилия, Имя, Отчество, Дата рождения, Пол
//          •Паспортные данные
//          •Контактные данные не заполняем
//        9.Проверить, что все поля заполнены правильно
//        10.Нажать продолжить
//        11.Проверить, что появилось сообщение - Заполнены не все обязательные поля
//
// Author: Boos Gleb


import java.util.concurrent.TimeUnit;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task1 {
    private WebDriver driver;
    private String baseUrl;
    //SimpleDateFormat today = new SimpleDateFormat("dd.MM.yyyy");

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drv/geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "drv/chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = " http://www.sberbank.ru/ru/person";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    public void testInsurance() throws Exception {

        //Установка задержки для страницы
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

        //Доступ к необходимому URL
        driver.get(baseUrl);

        //Открытие вкладки "Застраховать себя и имущество"
        driver.findElement(By.xpath("//span[contains(text(),'Застраховать себя')]/parent::*/parent::*/parent::*"));
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//div[contains(@class,'header_more_nav')]//*[contains(text(), 'Застраховать себя')]")))).click();


        //Открыть вкладку "Страхование путешественников"
        wait.until(ExpectedConditions.elementToBeClickable(
                driver.findElement(By.xpath("//div[contains(@class,'header_more_nav')]//*[contains(text(), 'Страхование путешественников')]")))).click();

        //Проверка наличия "Страхование путешественников"
        assertEquals("Страхование путешественников",
                driver.findElement(By.xpath("//h1[contains(text(),'Страхование путешественников')]")).getText());

        //Открытие окна "Оформить онлайн" c переключением на новое окно
        String winHandleBefore = driver.getWindowHandle();
        driver.findElement(By.xpath("//a//img [contains(@src,'banner-zashita-traveler')]")).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        //Выбор минимального пакета
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//div [contains(text(),'Минимальная')]/parent::*/parent::*"))));
        driver.findElement(By.xpath("//div [contains(text(),'Минимальная')]/parent::*/parent::*")).click();

        //Нажать на кнопку "Оформить"
        driver.findElement(By.xpath("//span [contains(text(),'Оформить')]")).click();

        //Ввод данных в заявку по застрахованным
        fillField(By.name("insured0_surname"), "Gleb");
        fillField(By.name("insured0_name"), "Boos");
        fillField(By.name("insured0_birthDate"), "17.09.1994");
        driver.findElement(By.xpath("//*[@class=\"b-radio-field-entity ng-pristine ng-untouched ng-valid\"][@name=\"male\"]")).click();

        //Ввод данных в заявку по стразователю
        fillField(By.name("surname"), "Иванов");
        fillField(By.name("name"), "Иван");
        fillField(By.name("middlename"), "Иванович");
        fillField(By.name("birthDate"), "17.09.1994");

        //Ввод данных паспорта
        fillField(By.name("passport_series"), "1111");
        fillField(By.name("passport_number"), "111111");
        fillField(By.name("issuePlace"), "Москва");
        //fillField(By.name("issueDate"), "17.09.1994"); //Не заполняется для ошибки, что не все данные введены

        //Ввод данных телефона
        fillField(By.name("phone"), "(985) 683-3950");
        fillField(By.name("email"), "gboos@aplana.com");
        fillField(By.name("emailValid"), "gboos@aplana.com");

        //Проверка ввода данных в заявку по застрахованным
        Assert.assertEquals("Gleb",driver.findElement(By.name("insured0_surname")).getAttribute("value"));
        Assert.assertEquals("Boos",driver.findElement(By.name("insured0_name")).getAttribute("value"));
        Assert.assertEquals("17.09.1994",driver.findElement(By.name("insured0_birthDate")).getAttribute("value"));

        //Проверка ввода данных в заявку по стразователю
        Assert.assertEquals("Иванов",driver.findElement(By.name("surname")).getAttribute("value"));
        Assert.assertEquals("Иван",driver.findElement(By.name("name")).getAttribute("value"));
        Assert.assertEquals("Иванович",driver.findElement(By.name("middlename")).getAttribute("value"));
        Assert.assertEquals("17.09.1994",driver.findElement(By.name("birthDate")).getAttribute("value"));


        //Проверка ввода данных паспорта
        Assert.assertEquals("1111",driver.findElement(By.name("passport_series")).getAttribute("value"));
        Assert.assertEquals("111111",driver.findElement(By.name("passport_number")).getAttribute("value"));
        Assert.assertEquals("Москва",driver.findElement(By.name("issuePlace")).getAttribute("value"));
        //Assert.assertEquals("17.09.1994",driver.findElement(By.name("issueDate")).getAttribute("value")); //Не заполняется для ошибки, что не все данные введены

        //Проверка ввода данных телефона
        Assert.assertEquals("(985) 683-3950",driver.findElement(By.name("phone")).getAttribute("value"));
        Assert.assertEquals("gboos@aplana.com",driver.findElement(By.name("email")).getAttribute("value"));
        Assert.assertEquals("gboos@aplana.com",driver.findElement(By.name("emailValid")).getAttribute("value"));

        //Нажмимаем на кнопку "Продолжить"
        driver.findElement(By.xpath("//span [contains(text(),'Продолжить')]")).click();

        //Проверяем, что не все поля заполнены
        assertEquals("Заполнены не все обязательные поля",
                driver.findElement(By.xpath("//div [text()='Заполнены не все обязательные поля']")).getText());

    }

    private void fillField(By locator, String value){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(value);
    }


}