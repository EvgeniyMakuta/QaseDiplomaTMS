package objects;

import lombok.Builder;
import lombok.Data;
import objects.enums.*;

@Builder
@Data
public class TestCase {
    private String title;
    private String description;
    private String preConditions;
    private String postConditions;
    private Status status;
    private Suite suite;
    private Severity severity;
    private Priority priority;
    private Type type;
    private Behavior behavior;
    private AutomationStatus automationStatus;

}
