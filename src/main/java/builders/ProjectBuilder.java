package builders;

import lombok.extern.log4j.Log4j2;
import objects.Project;
import org.apache.commons.lang3.RandomStringUtils;

import static constants.Constants.*;
import static objects.enums.Access.ALL;
import static objects.enums.AccessType.PRIVATE;
import static objects.enums.AccessType.PUBLIC;

@Log4j2
public class ProjectBuilder {

    public static Project getPublicProject() {
        Project project = Project.builder()
                .title(getProjectName())
                .code(getCode())
                .description(PROJECT_DESCRIPTION)
                .accessType(PUBLIC)
                .build();
        return project;
    }

    public static Project getPrivateProject() {
        Project project = Project.builder()
                .title(getProjectName())
                .code(getCode())
                .description(PROJECT_DESCRIPTION)
                .accessType(PRIVATE)
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
        String code = getProjectName().substring(3, 7);
        log.debug(String.format("Getting code %s", code));
        return code;
    }

    private static String getProjectName() {
        String name = PROJECT_PREFIX_NAME + RandomStringUtils.randomAlphabetic(10);
        log.debug(String.format("Getting project name %s", name));
        return name;
    }
}
