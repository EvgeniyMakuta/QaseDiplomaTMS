package objects.enums;

public enum AccessType {

    PRIVATE("private"),
    PUBLIC("public");

    private String field;

    AccessType(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
