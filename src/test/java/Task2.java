//Задание 2
//Доработать сценарий из задания № 1:
//        1.  Переписать тест с использованием PageObject и PageFactory
//        2.  Вынести в environment.properties переменные:
//          1. Браузер, в котором запускаются тесты
//          2. Путь к драйверу браузера
//        3. Настроить запуск тестов с использованием maven
//        4. Выделить класс BaseTest,  методы которого могут быть переиспользованы в дргуих тестах

// Author: Boos Gleb


import org.junit.Test;
import pages.MainPage;
import pages.RequestPage;
import pages.InsuranceTravelPage;

public class Task2 extends BaseTest{
    @Test
    public void Task2Selenium(){

        //Инициализация страниц
        MainPage mainPage = new MainPage(driver);
        InsuranceTravelPage insuranceTravelPage = new InsuranceTravelPage(driver);
        RequestPage RequestPage = new RequestPage(driver);

        //Выполнение команд для основной страницы
        mainPage.selectSection("Застраховать себя  и имущество");
        mainPage.waitElement(mainPage.getTravelInsuranceElement("Страхование путешественников"));
        mainPage.travelInsurance("Страхование путешественников");

        //Выполнение команд для страницы страхования путешественников
        insuranceTravelPage.checkSP();
        insuranceTravelPage.changeWindow();

        //Выбор минимального макета для страхования на третьей странице
        RequestPage.minrequest("Минимальная");
        RequestPage.PressMin();

        //Ввод данных в заявку по застрахованным
        RequestPage.fillField("фамилия застрахованного", "Boos");
        RequestPage.fillField("имя застрахованного", "Gleb");
        RequestPage.fillField("дата рождения застрахованного", "17.09.1994");

        //Ввод данных в заявку по стразователю
        RequestPage.fillField("фамилия", "Иванов");
        RequestPage.fillField("имя", "Иван");
        RequestPage.fillField("отчество", "Иванович");
        RequestPage.fillField("день рождения", "17.09.1994");

        //Ввод данных паспорта
        RequestPage.fillField("серия паспорта", "1111");
        RequestPage.fillField("номер паспорта", "111111");
        RequestPage.fillField("дата выдачи", "17.09.1994");
        RequestPage.fillField("место выдачи", "Москва");

        //Ввод контактных данных
        RequestPage.fillField("phone", "(985) 683-3950");
        RequestPage.fillField("email", "gboos@aplana.com");
        RequestPage.fillField("emailValid", "gboos@aplana.com");

        //Проверка ввода данных в заявку по застрахованным
        RequestPage.checkFields("фамилия застрахованного","Boos");
        RequestPage.checkFields("имя застрахованного","Gleb");
        RequestPage.checkFields("дата рождения застрахованного", "17.09.1994");

        //Проверка ввода данных в заявку по стразователю
        RequestPage.checkFields("фамилия", "Иванов");
        RequestPage.checkFields("имя", "Иван");
        RequestPage.checkFields("отчество", "Иванович");
        RequestPage.checkFields("день рождения", "17.09.1994");

        //Проверка ввода данных паспорта
        RequestPage.checkFields("серия паспорта", "1111");
        RequestPage.checkFields("номер паспорта", "111111");
        RequestPage.checkFields("дата выдачи", "17.09.1994");
        RequestPage.checkFields("место выдачи", "Москва");

        //Проверка ввода контактных данных
        RequestPage.checkFields("phone", "(985) 683-3950");
        RequestPage.checkFields("email", "gboos@aplana.com");
        RequestPage.checkFields("emailValid", "gboos@aplana.com");

        //Утверждение данных
        RequestPage.EndRequest();

        //Проверка заполненных полей
        RequestPage.checkZP();

    }
}