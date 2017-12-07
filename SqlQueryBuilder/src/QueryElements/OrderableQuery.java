package QueryElements;

public class OrderableQuery extends FinishableQuery {

    protected OrderableQuery(String query) {
        super(query);
    }

    //<editor-fold desc="ORDER BY">
    public OrderByQuery orderBy(String... columns){
        String columnQuery = String.join(", ", columns);
        localClause = String.format("ORDER BY %s", columnQuery);
        return orderByQuery();
    }

    public OrderByQuery orderByDescending(String... columns){
        String columnQuery = String.join(", ", columns);
        localClause =  String.format("ORDER BY %s DESC", columnQuery);
        return orderByQuery();
    }

    private OrderByQuery orderByQuery(){
        return new OrderByQuery(formattedQuery());
    }
    //</editor-fold>
    
}
