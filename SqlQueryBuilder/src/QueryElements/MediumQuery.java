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

    //<editor-fold desc="JOIN">
    //<editor-fold desc="INNER JOIN">
    public JoinQuery innerJoin(String table, String clause){
        join("INNER", table, clause);
        return joinQuery();
    }

    public JoinQuery innerJoin(String table, String leftId, String rightId){
        String clause = String.format("%s=%s", leftId, rightId);
        return innerJoin(table, clause);
    }

    public JoinQuery innerJoin(String table, String leftId, String rightId, String otherClauses){
        return join("INNER", table, leftId, rightId, otherClauses);
    }
    //</editor-fold>

    //<editor-fold desc="LEFT JOIN">
    public JoinQuery leftJoin(String table, String clause){
        return join("LEFT", table, clause);
    }

    public JoinQuery leftJoin(String table, String leftId, String rightId){
        return join("LEFT", table, leftId, rightId);
    }

    public JoinQuery leftJoin(String table, String leftId, String rightId, String otherClauses){
        return join("LEFT", table, leftId, rightId, otherClauses);
    }
    //</editor-fold>

    //<editor-fold desc="RIGHT JOIN">
    public IJoinQuery rightJoin(String table, String clause){
        return join("RIGHT", table, clause);
    }

    public IJoinQuery rightJoin(String table, String leftId, String rightId){
        return join("RIGHT", table, leftId, rightId);
    }

    public IJoinQuery rightJoin(String table, String leftId, String rightId, String otherClauses){
        return join("RIGHT", table, leftId, rightId, otherClauses);
    }
    //</editor-fold>

    private JoinQuery join(String joinType, String table, String clause){
        localClause = String.format("%s JOIN %s ON %s", joinType, table, clause);
        return joinQuery();
    }

    private JoinQuery join(String joinType, String table, String leftId, String rightId){
        String clause = String.format("%s=%s", leftId, rightId);
        return join(joinType, table, clause);
    }

    private JoinQuery join(String joinType, String table, String leftId, String rightId, String otherClauses){
        localClause = String.format("%s %s", join(joinType, table, leftId, rightId), otherClauses);
        return joinQuery();
    }

    private JoinQuery joinQuery(){
        return new JoinQuery(formattedQuery());
    }
    //</editor-fold>

}
