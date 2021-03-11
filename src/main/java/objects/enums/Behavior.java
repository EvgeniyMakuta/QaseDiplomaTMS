package objects.enums;

public enum Behavior {

    NOT_SET("Not set"),
    POSITIVE("Positive"),
    NEGATIVE("Negative"),
    DESTRUCTIVE("Destructive");

    private String field;

    Behavior(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
