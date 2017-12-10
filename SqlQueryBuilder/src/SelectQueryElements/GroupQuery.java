package SelectQueryElements;

import SelectQueryElements.QueryMethods.IGroupByMethods;

/**
 * Element at almost the end of the query, capable of group and order
 */
public class GroupQuery extends OrderQuery implements IGroupByMethods {

    protected GroupQuery(String query) {
        super(query);
    }

    public OrderQuery groupBy(String firstColumn, String... otherColumns){
        String columnQuery = columnQuery(firstColumn, otherColumns);
        localClause = String.format("GROUP BY %s", columnQuery);
        return groupByQuery();
    }

    private OrderQuery groupByQuery(){
        return new OrderQuery(formattedQuery());
    }

}
