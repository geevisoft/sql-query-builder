package DeleteQueryElements;

import QueryElements.FinishableQuery;
import QueryElements.Query;

public class DeleteQuery extends Query {

    public DeleteQuery(String query) {
        this.previousQuery = query;
    }

    public FinishableQuery where(String clause){
        localClause = String.format("WHERE %s", clause);
        return new FinishableQuery(formattedQuery());
    }

    public FinishableQuery whereEquals(String column, String value){
        String clause = String.format("%s='%s'", column, value);
        return where(clause);
    }

    public FinishableQuery whereEquals(String column, int value){
        String clause = String.format("%s=%d", column, value);
        return where(clause);
    }
}
