package adapters;

import io.restassured.response.Response;
import objects.Project;

public class ProjectsAdapter extends BaseAdapter {

    public String create(Project project) {
        return post(API_PROJECT_URI, converter.toJson(project)).body().path("result.code");
    }

    public Response getProject(String code) {
        return get(API_PROJECT_URI + code);
    }
}
