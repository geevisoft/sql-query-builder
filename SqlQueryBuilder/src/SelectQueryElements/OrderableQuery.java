package SelectQueryElements;

import QueryElements.FinishableQuery;
import Utils.StringHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderableQuery extends FinishableQuery {

    protected OrderableQuery(String query) {
        super(query);
    }

    //<editor-fold desc="ORDER BY">
    public OrderByQuery orderBy(String firstColumn, String... otherColumns){
        return orderBy(StringHelper.EMPTY, firstColumn, otherColumns);
    }

    public OrderByQuery orderByDescending(String firstColumn, String... otherColumns){
        return orderBy("DESC", firstColumn, otherColumns);
    }

    private OrderByQuery orderBy(String direction, String firstColumn, String... otherColumns){
        String columnQuery = columnQuery(firstColumn, otherColumns);
        if(StringHelper.isNullOrEmpty(direction)){
            localClause = String.format("ORDER BY %s", columnQuery);
        } else {
            localClause = String.format("ORDER BY %s %s", columnQuery, direction);
        }
        return orderByQuery();
    }

    private OrderByQuery orderByQuery(){
        return new OrderByQuery(formattedQuery());
    }
    //</editor-fold>

    protected String columnQuery(String firstColumn, String... otherColumns){
        ArrayList<String> columns = new ArrayList<>(Arrays.asList(otherColumns));
        columns.add(0, firstColumn);
        return String.join(", ", columns);
    }
}
