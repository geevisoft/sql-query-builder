package QueryElements;

public class FromQuery extends FinishableQuery implements IFromQuery {

    private final String previousQuery;
    private String localClause;

    protected FromQuery(String query) {
        super(query);
        previousQuery = query;
    }

    //<editor-fold desc="WHERE">
    public WhereQuery where(String clause){
        localClause = String.format("WHERE %s", clause);
        return whereQuery();
    }

    public WhereQuery whereEqual(String left, String right){
        localClause = equal(left, right);
        return whereQuery();
    }

    public WhereQuery whereEqual(String left, int right){
        localClause = equal(left, right);
        return whereQuery();
    }

    private WhereQuery whereQuery(){
        return new WhereQuery(formattedQuery());
    }
    //</editor-fold>

    //<editor-fold desc="INNER JOIN">
    public InnerJoinQuery innerJoin(String table, String clause){
        localClause = String.format("INNER JOIN %s ON %s", table, clause);
        return innerJoinQuery();
    }

    public InnerJoinQuery innerJoin(String table, String leftId, String rightId){
        String clause = String.format(" %s=%s ", leftId, rightId);
        return innerJoin(table, clause);
    }

    public InnerJoinQuery innerJoin(String table, String leftId, String rightId, String otherClauses){
        localClause = String.format(" %s %s ", innerJoin(table, leftId, rightId), otherClauses);
        return innerJoinQuery();
    }

    private InnerJoinQuery innerJoinQuery(){
        return new InnerJoinQuery(formattedQuery());
    }
    //</editor-fold>

    //<editor-fold desc="LEFT JOIN">
    public LeftJoinQuery leftJoin(String table, String clause){
        localClause = String.format("LEFT JOIN %s ON %s", table, clause);
        return leftJoinQuery();
    }

    public LeftJoinQuery leftJoin(String table, String leftId, String rightId){
        String clause = String.format(" %s=%s", leftId, rightId);
        return leftJoin(table, clause);
    }

    public LeftJoinQuery leftJoin(String table, String leftId, String rightId, String otherClauses){
        localClause = String.format(" %s %s ", leftJoin(table, leftId, rightId), otherClauses);
        return leftJoinQuery();
    }

    private LeftJoinQuery leftJoinQuery(){
        return new LeftJoinQuery(formattedQuery());
    }
    //</editor-fold>

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

    private String formattedQuery(){
        return String.format("%s %s", previousQuery, localClause);
    }

    private String equal(String left, int right){
        return String.format(" %s=%d ", left, right);
    }

    private String equal(String left, String right){
        return String.format(" %s='%s' ", left, right);
    }

    @Override
    public String query() {
        return previousQuery;
    }
}
