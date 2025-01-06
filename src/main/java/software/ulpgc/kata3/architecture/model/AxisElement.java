package software.ulpgc.kata3.architecture.model;

public class AxisElement {
    private final String field;
    private final int value;

    public AxisElement(String field, int value) {
        this.field = field;
        this.value = value;
    }

    public String getField() {
        return field;
    }

    public int getValue() {
        return value;
    }
}
