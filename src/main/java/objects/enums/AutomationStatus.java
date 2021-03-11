package objects.enums;

public enum AutomationStatus {

    NOT_AUTOMATED("Not automated"),
    TO_BE_AUTOMATED("To be automated"),
    AUTOMATED("Automated");

    private String field;

    AutomationStatus(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
