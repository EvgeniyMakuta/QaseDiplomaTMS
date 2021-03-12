package objects.enums;

public enum Suite {

    WITHOUT_SUITE("Test cases without suite");

    private String field;

    Suite(String field) {
        this.field = field;
    }

    public String getField() {
        return field;
    }
}
