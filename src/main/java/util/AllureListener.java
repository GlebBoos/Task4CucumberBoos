package util;

import steps.BaseStep;
import org.junit.runner.notification.Failure;
import ru.yandex.qatools.allure.junit.AllureRunListener;


public class AllureListener extends AllureRunListener {
    @Override
    public void testFailure(Failure failure){
        BaseStep.AllureScreenshot();
        super.testFailure(failure);
    }
}