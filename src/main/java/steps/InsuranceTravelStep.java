//Step для страницы с выбором страхования путешественников

package steps;

import pages.InsuranceTravelPage;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;


public class InsuranceTravelStep {
    //WebDriver driver;

    // Проверка на наличие вкладки для страницы страхования путешественников
    @Step("Проверка на ошибки")
    public void checkSP(String errorMessage){
        new InsuranceTravelPage(BaseStep.getDriver()).checkSP();
    }

    //Открытие нового окна и переход указателя к новой вкладке
    @Step("Переход на новую вкладку")
    public void changeWindow () {
        new InsuranceTravelPage(BaseStep.getDriver()).changeWindow();
    }

}