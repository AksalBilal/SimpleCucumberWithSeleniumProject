package helpers;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestListener implements ConcurrentEventListener {
    static final Logger logger = Logger.getLogger(TestListener.class);
    private int i = 0;

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestStepFinished.class, this::handleTestStepFinished);
        publisher.registerHandlerFor(TestStepStarted.class, this::takeScreenShotBeforeTestStep);
    }

    private void takeScreenShotBeforeTestStep(TestStepStarted testStepStarted) {
        ScreenShoot.TakeScreenShoot(testStepStarted);
    }

    private void handleTestStepFinished(TestStepFinished event) {
        TestCase testCase = event.getTestCase();
        Result result = event.getResult();
        Status status = result.getStatus();
        Throwable error = result.getError();
        String scenarioName = testCase.getName();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SS");
        String date = simpleDateFormat.format(new Date());
        List<TestStep> testSteps = testCase.getTestSteps();
        TestStep testStep;
        if (i != testSteps.size() - 2) {
            testStep = testSteps.get(i);
            i++;
        }
        String stepName = (((PickleStepTestStep) testSteps.get(i)).getStep()).getText();
        BasicConfigurator.configure();
        switch (status) {
            case PASSED:
                logger.info("The case named '" + stepName + "' in '"+scenarioName+"' scenario became PASSED on'" + date + "'");
                break;
            case FAILED:

                logger.error("The case named '" + stepName + "' in '"+scenarioName+"' scenario became FAILED on'" + date + "'\nError Details:\n" + error);
                break;
            case SKIPPED:
            case PENDING:
            case UNDEFINED:
            case AMBIGUOUS:
            case UNUSED:
                break;

        }
    }
}