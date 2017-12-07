package QueryElements;

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

    public WhereQuery whereEqual(String left, String right){
        String clause = equal(left, right);
        return where(clause);
    }

    public WhereQuery whereEqual(String left, int right){
        String clause = equal(left, right);
        return where(clause);
    }

    private WhereQuery whereQuery(){
        return new WhereQuery(formattedQuery());
    }

}
