package SelectQueryElements;

import SelectQueryElements.QueryMethods.IWhereMethods;

/**
 * Capable of where, group and order
 */
public class WhereableQuery extends EndQuery implements IWhereMethods {

    protected WhereableQuery(String query) {
        super(query);
    }

    public EndQuery where(String clause){
        localClause = String.format("WHERE %s", clause);
        return whereQuery();
    }

    public EndQuery whereEqual(String column, String value){
        String clause = equal(column, value);
        return where(clause);
    }

    public EndQuery whereEqual(String column, int value){
        String clause = equal(column, value);
        return where(clause);
    }

    private EndQuery whereQuery(){
        return new EndQuery(formattedQuery());
    }

}
