package SelectQueryElements;

public class SelectQuery implements ISelectQuery {

    private final String previousQuery;
    private String selectClause;

    public SelectQuery(String selectQuery) {
        this.previousQuery = selectQuery;
    }

    public FromQuery from(String table){
        selectClause = String.format("FROM %s", table);
        return fromQuery();
    }

    private FromQuery fromQuery(){
        String formattedQuery = String.format("%s %s", previousQuery, selectClause);
        return new FromQuery(formattedQuery);
    }
}
