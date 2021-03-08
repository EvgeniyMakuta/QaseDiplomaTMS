package adapters;

import com.google.gson.Gson;
import constants.Constants;
import groovy.beans.PropertyReader;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static java.lang.System.getProperty;

public class BaseAdapter implements Constants {
    Gson converter = new Gson();

    /**
     *
     * @param uri e.g. project (will be concatenated with API_BASE_PATH)
     * @param body request body
     * @return whole body of the response.
     */
    public Response post(String uri, String body) {
        return
        given()
                .header(API_TOKEN_KEY, API_TOKEN_VALUE)
                .header(CONTENT_TYPE_HEADER_KEY, CONTENT_TYPE_HEADER_VALUE)
                .body(body)
        .when()
                .post(API_BASE_PATH + uri)
        .then()
                .log().all()
                .extract().response();
    }

    /**
     *
     * @param uri e.g. project (will be concatenated with API_BASE_PATH)
     * @return whole body of the response to get status code
     */
    public Response get(String uri) {
        return
        given()
                .header(API_TOKEN_KEY, API_TOKEN_VALUE)
                .header(CONTENT_TYPE_HEADER_KEY, CONTENT_TYPE_HEADER_VALUE)
        .when()
                .get(API_BASE_PATH + uri)
        .then()
                .log().all()
                .extract().response();
    }
}