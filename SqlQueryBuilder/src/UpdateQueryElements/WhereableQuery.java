package UpdateQueryElements;

import QueryElements.FinishableQuery;
import QueryElements.Query;
import Utils.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class WhereableQuery extends Query {

    protected final List<String> setValues;

    public WhereableQuery(String query) {
        this.previousQuery = query;
        setValues = new ArrayList<String>();
    }

    public FinishableQuery where(String clause){
        String setValuesQuery = StringHelper.join(", ", setValues);
        localClause = String.format("SET %s WHERE %s", setValuesQuery, clause);
        return whereQuery();
    }

    public FinishableQuery whereEqual(String column, String value){
        String clause = equal(column, value);
        return where(clause);
    }

    public FinishableQuery whereEqual(String column, int value){
        String clause = equal(column, value);
        return where(clause);
    }

    private FinishableQuery whereQuery(){
        return new FinishableQuery(formattedQuery());
    }

}
