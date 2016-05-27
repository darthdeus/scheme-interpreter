package sexp;

import java.util.List;

public class SLambda extends SExpression {
    private List<SExpression> parameters;
    private SExpression body;

    public SLambda(List<SExpression> parameters, SExpression body) {
        this.parameters = parameters;
        this.body = body;
    }

    public List<SExpression> getParameters() {
        return parameters;
    }

    public SExpression getBody() {
        return body;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("(lambda (");

        for (int i = 0; i < parameters.size(); i++) {
            builder.append(parameters.get(i).toString());
            if (i < parameters.size() - 1) {
                builder.append(" ");
            }
        }

        builder.append(") ");
        builder.append(body.toString());
        builder.append(")");

        return builder.toString();
    }
}
