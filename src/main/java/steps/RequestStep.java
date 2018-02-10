//Step для страницы с вводо данных и оформлением заявки

package steps;

import pages.RequestPage;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.HashMap;


public class RequestStep {
    //WebDriver driver;

    //Блок по выбору минимального пакета страхования путешественника
    @Step("Поиск минимального пакета страхования путешественников")
    public void PressMin () { new RequestPage(BaseStep.getDriver()).PressMin(); }
    @Step ("Выбор минимального пакета страхования путешественников")
    public void minrequest (String sum) { new RequestPage(BaseStep.getDriver()).minrequest(sum); }

    //Заполнение полей данными
    @Step ("Заполнение полей")
    public void fillField(String fieldName, String value) { new RequestPage(BaseStep.getDriver()).fillField(fieldName,value); }
    @Step("Хэш-таблица для ввода данных")
    public void fillFields(HashMap<String,String> fields){ fields.forEach((k,v)->fillField(k,v)); }

    //Проверка полей данными
    @Step ("Проверка данных")
    public void checkField (String field, String expected){ new RequestPage(BaseStep.getDriver()).checkFields(field,expected); }
    @Step("Хэш-таблица для проверки данных")
    public void checkFields(HashMap<String, String>hashMap){ hashMap.forEach((k,v)->checkField(k,v)); }

    //Оформление заявки
    @Step("Офомрление заявки")
    public void EndRequest (){ new RequestPage(BaseStep.getDriver()).EndRequest(); }

    //Проверка наличия оповещения, что не все данные заполнены
    @Step ("Проверка на наличие ошибки")
    public void checkZP(){ new RequestPage(BaseStep.getDriver()).checkZP(); }
}