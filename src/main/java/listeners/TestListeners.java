package listeners;

import driverprovider.WebDriverProvider;
import org.testng.*;

import java.util.Collection;

public class TestListeners implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " method was invoked for " + WebDriverProvider.parameter);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " test passed successfully for " + WebDriverProvider.parameter);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " test failed for " + WebDriverProvider.parameter);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() + " test was skipped for " + WebDriverProvider.parameter);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(result.getMethod().getMethodName() +
                " method failed but was annotated with @successPercentage annotation for " + WebDriverProvider.parameter);
    }

    @Override
    public void onStart(ITestContext context) {
        Collection<ITestNGMethod> allMethods = context.getPassedTests().getAllMethods();
        for (ITestNGMethod allMethod : allMethods) {
            System.out.println(allMethod.getMethodName());
        }
        System.out.println("Invoked after the test class is instantiated and before any configuration method is called.");
    }

    @Override
    public void onFinish(ITestContext context) {
        Collection<ITestNGMethod> allMethods = context.getPassedTests().getAllMethods();
        for (ITestNGMethod allMethod : allMethods) {
            System.out.println(allMethod.getMethodName());
        }
        System.out.println("Invoked after all the tests have run and all their Configuration methods have been called."
                + WebDriverProvider.parameter);
    }
}
