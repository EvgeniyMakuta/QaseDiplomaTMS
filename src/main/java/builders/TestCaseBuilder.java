package builders;

import lombok.extern.log4j.Log4j2;
import objects.TestCase;
import org.apache.commons.lang3.RandomStringUtils;

import static constants.Constants.*;
import static objects.enums.AutomationStatus.TO_BE_AUTOMATED;
import static objects.enums.Behavior.POSITIVE;
import static objects.enums.Priority.LOW;
import static objects.enums.Severity.MINOR;
import static objects.enums.Status.DRAFT;
import static objects.enums.Suite.WITHOUT_SUITE;
import static objects.enums.Type.SMOKE;

@Log4j2
public class TestCaseBuilder {

    private TestCaseBuilder() {
    }

    public static TestCase getTestCase() {
        TestCase testCase = TestCase.builder()
                .title(getTestCaseName())
                .status(DRAFT)
                .description(TEST_CASE_DESCRIPTION_VALUE)
                .suite(WITHOUT_SUITE)
                .severity(MINOR)
                .priority(LOW)
                .type(SMOKE)
                .behavior(POSITIVE)
                .automationStatus(TO_BE_AUTOMATED)
                .preConditions(TEST_CASE_PRE_CONDITIONS_VALUE)
                .postConditions(TEST_CASE_POST_CONDITIONS_VALUE)
                .build();
        log.debug(String.format("Getting testCase %s", testCase.toString()));
        return testCase;
    }

    private static String getTestCaseName() {
        String name = TEST_CASE_PREFIX_NAME + RandomStringUtils.randomAlphabetic(5);
        log.debug(String.format("Getting test case name %s", name));
        return name;
    }
}
