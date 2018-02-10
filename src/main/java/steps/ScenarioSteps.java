package steps;

import org.openqa.selenium.WebElement;
import cucumber.api.DataTable;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class ScenarioSteps {

    MainStep mainSteps = new MainStep();
    RequestStep requestSteps = new RequestStep();
    InsuranceTravelStep InsuranceSteps = new InsuranceTravelStep();


    //Блок 1: Работа в главном меню сайта
    //В главном меню выбирается вид стрхования "Страхования путешественников"
    @When("^Открывается пункт меню: \"(.+)\"$")
    public void stepSelectSectionItem(String nameSection) {
        mainSteps.selectSection(nameSection);
    }
    @When("^Запускается вид страхования: \"(.+)\"$")
    public void stepSelectTypeInsurance(String typeName){
        mainSteps.travelInsurance(typeName);
    }
    @Then("^Вид страхования: \"(.+)\"$")
    public void stepGetTypeOfInsurance(String typeName){
        mainSteps.waitElement(mainSteps.getTravelInsuranceElement(typeName));
    }


    //Блок 2: Работа в меню страхования путешественников
    @Then("^Проверка на ошибки заголовка \"(.+)\"$")
    public void stepCheckTitle (String title) {
        InsuranceSteps.checkSP(title);
    }

    //Переход на новую вкладку
    @Then("^Переход на новую вкладку")
    public void stepSwitchWindow() {
        InsuranceSteps.changeWindow();
    }




    //Блок 3: Оформление заявки
    //Выбор минимального пакета
    @When("^Выбран минимальный пакет страхования: \"(.+)\"$")
    public void stepChooseSum(String sum){
        requestSteps.PressMin();
    }
    @Then("^Переход к этапу ввода данных по заявке")
    public void stepExecute(String sum) {
        requestSteps.minrequest(sum);
    }

    //Ввод данных в поля
    @When("^Ввод данных:$")
    public void fillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> requestSteps.fillField(field, value));
    }

    //Проверка полей на введенные данные
    @Then("^Проверка данных:$")
    public void checkFillForm(DataTable fields) {
        fields.asMap(String.class, String.class)
                .forEach((field, value) -> requestSteps.checkField(field, value));
    }

    // Оформление заявки и вывод оповещения, что в заявке недостаточно данных
    @When("^Оформление заявки")
    public void stepClickContinue(){
        requestSteps.EndRequest();
    }
    @Then("^Вывод сообщения об ошибке: \"(.+)\"")
    public void stepCheckError(){
        requestSteps.checkZP();
    }
}