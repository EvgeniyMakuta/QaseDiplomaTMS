package constants;

public interface IConstants {
    String API_TOKEN = "apiToken";

    // URL's
    String MAIN_PAGE_URL = "https://qase.io/";
    String BASE_PATH = "https://app.qase.io/";
    String LOGIN_PAGE_URL = BASE_PATH + "login";
    String PROJECTS_PAGE_URL = BASE_PATH + "projects";
    String PROJECT_PAGE_URL = BASE_PATH + "project/%s";
    String CREATE_NEW_PROJECT_PAGE_URL = BASE_PATH + "project/create";
    String CREATE_NEW_TEST_CASE_URL = BASE_PATH + "case/%s/create";
    String SETTINGS_URL = PROJECT_PAGE_URL + "/settings/general";

    int IMPLICIT_WAIT = 5;

    //PAGE NAMES
    String MAIN_PAGE = "Main";
    String LOGIN_PAGE = "Login";
    String PROJECTS_PAGE = "Projects";
    String PROJECT_PAGE = "Project";
    String NEW_PROJECT_PAGE = "New Project";
    String NEW_TEST_CASE_PAGE = "Create test case";
    String SETTINGS_PAGE = "Settings";

    //API
    String API_BASE_PATH = "https://api.qase.io/v1/";
    String API_PROJECT_URI = "project/";
    String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    String CONTENT_TYPE_HEADER_VALUE = "application/json";
    String API_TOKEN_KEY = "Token";
    // TODO read from PropertyFile or SystemVariables
    String API_TOKEN_VALUE = "70c308e9c09568164087e115ad6d245daeec9f57";

    //Project fields values
    String PROJECT_PREFIX_NAME = "PR-";
    String PROJECT_GROUP = "null";
    String PROJECT_DESCRIPTION = "New Project created by Evgeniy";
    String PROJECT_UPDATE_ALERT_MSG = "Project settings were successfully updated!";
    String PROJECT_CODE = "MK24Hy";

    // Test case fields values
    String TEST_CASE_PRE_CONDITIONS_VALUE = "Any text for pre-conditions";
    String TEST_CASE_POST_CONDITIONS_VALUE = "Any text for post-conditions";
    String TEST_CASE_DESCRIPTION_VALUE = "Any text for description";

    //Project field labels
    String PROJECT_NAME_INPUT_LABEL = "Project name";
    String PROJECT_CODE_INPUT_LABEL = "Project Code";
    String PROJECT_DESCRIPTION_TEXT_AREA_LABEL = "Description";
    String PROJECT_ACCESS_TYPE_RADIO_LABEL = "Project access type";

    //Test case labels
    String TEST_CASE_TITLE_INPUT_LABEL = "Title";
    String TEST_CASE_PREFIX_NAME = "TC-";
    String TEST_CASE_PRIORITY_LABEL = "Priority";
    String TEST_CASE_STATUS_LABEL = "Status";
    String TEST_CASE_SUITE_LABEL = "Suite";
    String TEST_CASE_SEVERITY_LABEL = "Severity";
    String TEST_CASE_TYPE_LABEL = "Type";
    String TEST_CASE_BEHAVIOR_LABEL = "Behavior";
    String TEST_CASE_AUTO_STATUS_LABEL = "Automation status";
    String TEST_CASE_DESCRIPTION_LABEL = "Description";
    String TEST_CASE_PRECONDITIONS_LABEL = "Pre-conditions";
    String TEST_CASE_POSTCONDITIONS_LABEL = "Post-conditions";
}
