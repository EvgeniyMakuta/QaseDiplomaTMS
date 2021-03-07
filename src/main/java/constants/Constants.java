package constants;

public interface Constants {
    // URL's
    String BASE_PATH = "https://app.qase.io/";
    String LOGIN_PAGE_URL = BASE_PATH + "login";
    String PROJECTS_PAGE_URL = BASE_PATH + "projects";
    String PROJECT_PAGE_URL = BASE_PATH + "project/%s";
    String CREATE_NEW_PROJECT_PAGE_URL = BASE_PATH + "project/create";

    int IMPLICIT_WAIT = 15;

    //PAGE NAMES
    String LOGIN_PAGE = "Login";
    String PROJECTS_PAGE = "Projects";
    String PROJECT_PAGE = "Project";
    String NEW_PROJECT_PAGE = "New Project";

    //API
    String API_BASE_PATH = "https://api.qase.io/v1/";
    String API_PROJECT_URI = "project/";
    String CONTENT_TYPE_HEADER_KEY = "Content-Type";
    String CONTENT_TYPE_HEADER_VALUE = "application/json";
    String API_TOKEN_KEY = "Token";
    // TODO read from PropertyFile or SystemVariables
    String API_TOKEN_VALUE = "70c308e9c09568164087e115ad6d245daeec9f57";

    //Project fields values
    String PROJECT_PREFIX_NAME = "MK";
    String PROJECT_GROUP = "null";
    String PROJECT_DESCRIPTION = "New Project created by Evgeniy";

    //Project field names
    String PROJECT_NAME_INPUT_LABEL = "Project name";
    String PROJECT_CODE_INPUT_LABEL = "Project Code";
    String PROJECT_DESCRIPTION_TEXT_AREA_LABEL = "Description";
    String PROJECT_ACCESS_TYPE_RADIO_LABEL = "Project access type";
}
