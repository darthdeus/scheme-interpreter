package sexp;

public class SNumber extends SExpression {
    private int value;

    public SNumber(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
