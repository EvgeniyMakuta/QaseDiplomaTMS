package objects.enums;

public enum Severity {

    NOT_SET("Not set"),
    BLOCKER("Blocker"),
    CRITICAL("Critical"),
    MAJOR("Major"),
    NORMAL("Normal"),
    MINOR("Minor"),
    TRIVIAL("Trivial");

    private String field;

    Severity(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
