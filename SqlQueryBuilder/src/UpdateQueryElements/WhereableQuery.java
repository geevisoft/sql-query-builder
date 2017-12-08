package UpdateQueryElements;

import QueryElements.Query;
import QueryElements.WhereQuery;
import Utils.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class WhereableQuery extends Query {

    protected final List<String> setValues;

    public WhereableQuery(String query) {
        this.previousQuery = query;
        setValues = new ArrayList<String>();
    }

    public WhereQuery where(String clause){
        String setValuesQuery = StringHelper.join(", ", setValues);
        localClause = String.format("SET %s WHERE %s", setValuesQuery, clause);
        return new WhereQuery(formattedQuery());
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
