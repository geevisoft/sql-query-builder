package SelectQueryElements.QueryMethods;

import SelectQueryElements.EndQuery;
import SelectQueryElements.JoinQuery;

public abstract class JoinMethods extends EndQuery {

    private final String type;

    protected JoinMethods(String query, String type) {
        super(query);
        this.type = type;
    }

    public JoinQuery join(String table, String clause){
        localClause = String.format("%s JOIN %s ON %s", type, table, clause);
        return joinQuery();
    }

    public JoinQuery join(String table, String leftId, String rightId){
        String clause = String.format("%s=%s", leftId, rightId);
        return join(table, clause);
    }

    public JoinQuery join(String table, String leftId, String rightId, String otherClauses){
        localClause = String.format("%s %s", join(type, table, leftId, rightId), otherClauses);
        return joinQuery();
    }

    private JoinQuery joinQuery(){
        return new JoinQuery(formattedQuery());
    }
}