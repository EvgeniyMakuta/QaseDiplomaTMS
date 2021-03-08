package objects.enums;

public enum Type {

    OTHER("Other"),
    SMOKE("Smoke"),
    REGRESSION("Regression"),
    SECURITY("Security"),
    USABILITY("Usability"),
    PERFORMANCE("Performance"),
    ACCEPTANCE("Acceptance"),
    FUNCTIONAL("Functional");

    private String field;

    Type(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
