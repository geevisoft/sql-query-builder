package QueryElements;

/**
 * Element in the middle of the query, still capable of a lot of method calls
 */
public class MediumQuery extends EndQuery {

    protected MediumQuery(String query) {
        super(query);
    }

    //<editor-fold desc="WHERE">
    public WhereQuery where(String clause){
        localClause = String.format("WHERE %s", clause);
        return whereQuery();
    }

    public WhereQuery whereEqual(String left, String right){
        String clause = equal(left, right);
        return where(clause);
    }

    public WhereQuery whereEqual(String left, int right){
        String clause = equal(left, right);
        return where(clause);
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
        String clause = String.format("%s=%s", leftId, rightId);
        return innerJoin(table, clause);
    }

    public InnerJoinQuery innerJoin(String table, String leftId, String rightId, String otherClauses){
        localClause = String.format("%s %s", innerJoin(table, leftId, rightId), otherClauses);
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

}
