package SelectQueryElements;

import SelectQueryElements.QueryMethods.IWhereMethods;

/**
 * Capable of where, group and order
 */
public class WhereQuery extends GroupQuery implements IWhereMethods {

    protected WhereQuery(String query) {
        super(query);
    }

    public GroupQuery where(String clause){
        localClause = String.format("WHERE %s", clause);
        return whereQuery();
    }

    public GroupQuery whereEqual(String column, String value){
        String clause = equal(column, value);
        return where(clause);
    }

    public GroupQuery whereEqual(String column, int value){
        String clause = equal(column, value);
        return where(clause);
    }

    private GroupQuery whereQuery(){
        return new GroupQuery(formattedQuery());
    }

}
