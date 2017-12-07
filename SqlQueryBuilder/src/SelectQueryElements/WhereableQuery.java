package SelectQueryElements;

/**
 * Capable of where, group and order
 */
public class WhereableQuery extends EndQuery {

    protected WhereableQuery(String query) {
        super(query);
    }

    public WhereQuery where(String clause){
        localClause = String.format("WHERE %s", clause);
        return whereQuery();
    }

    public WhereQuery whereEqual(String column, String value){
        String clause = equal(column, value);
        return where(clause);
    }

    public WhereQuery whereEqual(String column, int value){
        String clause = equal(column, value);
        return where(clause);
    }

    private WhereQuery whereQuery(){
        return new WhereQuery(formattedQuery());
    }

}
