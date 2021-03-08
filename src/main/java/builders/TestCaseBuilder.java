package builders;

import lombok.extern.log4j.Log4j2;
import objects.TestCase;
import org.apache.commons.lang3.RandomStringUtils;

import static constants.Constants.TEST_CASE_PREFIX_NAME;
import static objects.enums.AutomationStatus.TO_BE_AUTOMATED;
import static objects.enums.Behavior.POSITIVE;
import static objects.enums.Priority.LOW;
import static objects.enums.Severity.MINOR;
import static objects.enums.Status.DRAFT;
import static objects.enums.Suite.WITHOUT_SUITE;
import static objects.enums.Type.SMOKE;

@Log4j2
public class TestCaseBuilder {

    public static TestCase getTestCase() {
        TestCase testCase = TestCase.builder()
                .title(getTestCaseName())
                .status(DRAFT)
                .description("Any text for description")
                .suite(WITHOUT_SUITE)
                .severity(MINOR)
                .priority(LOW)
                .type(SMOKE)
                .behavior(POSITIVE)
                .automationStatus(TO_BE_AUTOMATED)
                .preConditions("Any text for pre-conditions")
                .postConditions("Any text for post-conditions")
                .build();
        return testCase;
    }

    private static String getTestCaseName() {
        String name = TEST_CASE_PREFIX_NAME + RandomStringUtils.randomAlphabetic(5);
        log.debug(String.format("Getting test case name %s", name));
        return name;
    }
}