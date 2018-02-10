//Задание 4
//     Доработать автотест из предыдущих лекций с использованием библиотеки - Cucumber.


// Author: Boos Gleb

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/"}, glue = {"steps"},
        plugin = {
            "util.AllureReporter",
        }
)
public class Task4 {
}