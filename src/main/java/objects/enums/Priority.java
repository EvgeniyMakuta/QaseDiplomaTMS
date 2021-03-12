package objects.enums;

public enum Priority {

    NOT_SET("Not set"),
    HIGH("High"),
    MEDIUM("Medium"),
    LOW("Low");

    private String field;

    Priority(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
