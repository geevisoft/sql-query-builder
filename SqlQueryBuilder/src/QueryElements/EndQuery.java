package QueryElements;

/**
 * Element at almost the end of the query, capable of group and order
 */
public class EndQuery extends OrderableQuery {

    protected EndQuery(String query) {
        super(query);
    }

    //<editor-fold desc="GROUP BY">
    public GroupByQuery groupBy(String... columns){
        String columnQuery = String.join(", ", columns);
        localClause = String.format("GROUP BY %s", columnQuery);
        return groupByQuery();
    }

    private GroupByQuery groupByQuery(){
        return new GroupByQuery(formattedQuery());
    }
    //</editor-fold>

}
