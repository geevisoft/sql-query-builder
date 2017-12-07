package DeleteQueryElements;

import QueryElements.Query;

public class DeleteQuery extends Query {

    public DeleteQuery(String query) {
        this.previousQuery = query;
    }

    public WhereQuery where(String clause){
        localClause = String.format("WHERE %s", clause);
        return new WhereQuery(formattedQuery());
    }

    public WhereQuery whereEquals(String column, String value){
        String clause = String.format("%s='%s'", column, value);
        return where(clause);
    }

    public WhereQuery whereEquals(String column, int value){
        String clause = String.format("%s=%d", column, value);
        return where(clause);
    }
}
