package objects.enums;

public enum Status {

    DRAFT("Draft"),
    ACTUAL("Actual"),
    DEPRECATED("Deprecated");

    private String field;

    Status(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
