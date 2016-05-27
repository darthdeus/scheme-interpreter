package sexp;

public class SAtom extends SExpression {
    private String value;

    public SAtom(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}
