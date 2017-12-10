package SelectQueryElements;

import SelectQueryElements.QueryMethods.IGroupByMethods;

/**
 * Element at almost the end of the query, capable of group and order
 */
public class EndQuery extends OrderableQuery implements IGroupByMethods {

    protected EndQuery(String query) {
        super(query);
    }

    public OrderableQuery groupBy(String firstColumn, String... otherColumns){
        String columnQuery = columnQuery(firstColumn, otherColumns);
        localClause = String.format("GROUP BY %s", columnQuery);
        return groupByQuery();
    }

    private OrderableQuery groupByQuery(){
        return new OrderableQuery(formattedQuery());
    }

}
