package QueryElements;

import QueryMethods.*;

/**
 * Element in the middle of the query, still capable of a lot of method calls
 */
public class MediumQuery extends WhereableQuery {

    protected MediumQuery(String query) {
        super(query);
    }

    //<editor-fold desc="INNER JOIN">
    public JoinQuery innerJoin(String table, String clause){
        return new InnerJoinMethods(query()).join(table, clause);
    }

    public JoinQuery innerJoin(String table, String leftId, String rightId){
        return new InnerJoinMethods(query()).join(table, leftId, rightId);
    }

    public JoinQuery innerJoin(String table, String leftId, String rightId, String otherClauses){
        return new InnerJoinMethods(query()).join(table, leftId, rightId, otherClauses);
    }
    //</editor-fold>

    //<editor-fold desc="LEFT JOIN">
    public JoinQuery leftJoin(String table, String clause){
        return new LeftJoinMethods(query()).join(table, clause);
    }

    public JoinQuery leftJoin(String table, String leftId, String rightId){
        return new LeftJoinMethods(query()).join(table, leftId, rightId);
    }

    public JoinQuery leftJoin(String table, String leftId, String rightId, String otherClauses){
        return new LeftJoinMethods(query()).join(table, leftId, rightId, otherClauses);
    }
    //</editor-fold>

    //<editor-fold desc="RIGHT JOIN">
    public IJoinQuery rightJoin(String table, String clause){
        return new RightJoinMethods(query()).join(table, clause);
    }

    public IJoinQuery rightJoin(String table, String leftId, String rightId){
        return new RightJoinMethods(query()).join(table, leftId, rightId);
    }

    public IJoinQuery rightJoin(String table, String leftId, String rightId, String otherClauses){
        return new RightJoinMethods(query()).join(table, leftId, rightId, otherClauses);
    }
    //</editor-fold>

}
