package sexp;

import java.util.List;

public class SList extends SExpression {
    private List<SExpression> expressions;

    public SList(List<SExpression> expressions) {
        this.expressions = expressions;
    }

    public List<SExpression> getExpressions() {
        return expressions;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("(");

        for (int i = 0; i < expressions.size(); ++i) {
            builder.append(expressions.get(i));
            if (i < expressions.size() - 1) {
                builder.append(" ");
            }
        }

        builder.append(")");

        return builder.toString();
    }
}
