//Задание 3
//     К автотесту, разработанному в предыдущих заданиях добавить возможность формирования allure отчета

// Author: Boos Gleb

import steps.BaseStep;
import steps.MainStep;
import steps.RequestStep;
import steps.InsuranceTravelStep;
import org.junit.Test;
import java.util.HashMap;



public class Task3 extends BaseStep {

    MainStep mainStep = new MainStep();
    InsuranceTravelStep insuranceTravelStep = new InsuranceTravelStep();
    RequestStep requestStep = new RequestStep();
    HashMap <String, String> testData = new HashMap<>();


    @Test
    public void task3selenuim(){

        //Переход к вкладке Застраховать себя и имущество-выбор страхования путешественников
        mainStep.selectSection("Застраховать себя  и имущество");
        mainStep.waitElement(mainStep.getTravelInsuranceElement("Страхование путешественников"));
        mainStep.travelInsurance("Страхование путешественников");


        //Переход к вкладке Страхования путешественников, проверка на наличие соответствующего окна и переход
        //к новому окну
        //insuranceTravelStep.waitElement(insuranceTravelStep.getTitle());
        insuranceTravelStep.checkSP("Страхование путешественников");
        insuranceTravelStep.changeWindow();


        //Поиск и выбор минимального пакета для заявки страхования
        requestStep.minrequest("Минимальная");
        requestStep.PressMin();


        //Ввод данных в заявку по застрахованным
        testData.put("фамилия застрахованного", "Boos");
        testData.put("имя застрахованного", "Gleb");
        testData.put("дата рождения застрахованного", "17.09.1994");

        //Ввод данных в заявку по стразователю
        testData.put("фамилия", "Иванов");
        testData.put("имя", "Иван");
        testData.put("отчество", "Иванович");
        testData.put("день рождения", "17.09.1994");

        //Ввод данных паспорта
        testData.put("серия паспорта", "1111");
        testData.put("номер паспорта", "111111");
        //testData.put("дата выдачи", "17.09.1994"); // Не вводится, чтобы возникла ошибка неполноты заявки
        testData.put("место выдачи", "Москва");

        //Ввод контактных данных
        testData.put("phone", "(985) 683-3950");
        testData.put("email", "gboos@aplana.com");
        testData.put("emailValid", "gboos@aplana.com");

        //Ввод в поля по тестовым данным
        requestStep.fillFields(testData);

        //Проверка полей на соответствие тестовым данным
        requestStep.checkFields(testData);

        //Завершение заявки
        requestStep.EndRequest();

        //Ппроверка оповещения, что заполнены не все поля
        requestStep.checkZP();
    }

}