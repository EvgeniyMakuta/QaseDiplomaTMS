package builders;

import lombok.extern.log4j.Log4j2;
import objects.Project;
import org.apache.commons.lang3.RandomStringUtils;

import static constants.Constants.*;
import static objects.enums.Access.ALL;

@Log4j2
public class ProjectBuilder {

    public static Project getProject() {
        Project project = Project.builder()
                .title(getProjectName())
                .code(getCode())
                .description(PROJECT_DESCRIPTION)
                .build();
        return project;
    }

    public static Project getProjectByAPI() {
        Project project = Project.builder()
                .title(getProjectName())
                .access(ALL)
                .code(getCode())
                .group(PROJECT_GROUP)
                .description(PROJECT_DESCRIPTION)
                .build();
        log.debug(String.format("Getting project %s", project.toString()));
        return project;
    }

    private static String getCode() {
        String code = getProjectName().substring(0, 4);
        log.debug(String.format("Getting code %s", code));
        return code;
    }

    private static String getProjectName() {
        String name = PROJECT_PREFIX_NAME + RandomStringUtils.randomAlphabetic(5);
        log.debug(String.format("Getting project name %s", name));
        return name;
    }
}
