package SelectQueryElements.QueryMethods;

import SelectQueryElements.EndQuery;
import SelectQueryElements.JoinQuery;

public class JoinMethods extends EndQuery {

    private final String type;

    public JoinMethods(String query, String type) {
        super(query);
        this.type = type;
    }

    public JoinQuery join(String table, String clause){
        localClause = String.format("%s JOIN %s ON %s", type, table, clause);
        return joinQuery();
    }

    public JoinQuery join(String table, String oneColumn, String anotherColumn){
        String clause = String.format("%s=%s", oneColumn, anotherColumn);
        return join(table, clause);
    }

    public JoinQuery join(String table, String oneColumn, String anotherColumn, String otherClauses){
        localClause = String.format("%s %s", join(table, oneColumn, anotherColumn), otherClauses);
        return joinQuery();
    }

    private JoinQuery joinQuery(){
        return new JoinQuery(formattedQuery());
    }
}