package listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.concurrent.TimeUnit;

public class TestListener implements ITestListener {
    private static final Logger logger = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        logger.info("Starting test: {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logTestResult(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test failed: {} - {}", 
            result.getName(), 
            result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logTestResult(result, "SKIPPED");
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Starting test suite: {}", context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Finished test suite: {}", context.getName());
        logTestSummary(context);
    }

    private void logTestResult(ITestResult result, String status) {
        long durationMs = result.getEndMillis() - result.getStartMillis();
        long durationSec = TimeUnit.MILLISECONDS.toSeconds(durationMs);
        
        logger.info("Test {} - {} (Duration: {} seconds)", 
            result.getName(), 
            status, 
            durationSec);
    }

    private void logTestSummary(ITestContext context) {
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        int total = passed + failed + skipped;

        logger.info("Test Summary:");
        logger.info("Total Tests: {}", total);
        logger.info("Passed: {}", passed);
        logger.info("Failed: {}", failed);
        logger.info("Skipped: {}", skipped);
        logger.info("Success Rate: {}%", (total > 0) ? (passed * 100 / total) : 0);
    }
} 