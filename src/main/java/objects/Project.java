package objects;

import lombok.Builder;
import lombok.Data;
import objects.enums.Access;
import objects.enums.AccessType;

@Builder
@Data
public class Project {
    private String title;
    private String code;
    private String description;
    private String group;
    private Access access;
    private AccessType accessType;
}
