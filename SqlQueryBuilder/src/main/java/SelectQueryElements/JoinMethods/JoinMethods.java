package SelectQueryElements.JoinMethods;

import SelectQueryElements.GroupQuery;
import SelectQueryElements.IJoinQuery;
import SelectQueryElements.JoinQuery;

public class JoinMethods extends GroupQuery {

	private final String type;

	public JoinMethods(String query, String type) {
		super(query);
		this.type = type;
	}

	public IJoinQuery join(String table, String clause){
		localClause = String.format("%s JOIN %s ON %s", type, table, clause);
		return joinQuery();
	}

	public IJoinQuery joinAs(String table, String alias, String clause){
		localClause = String.format("%s JOIN %s %s ON %s", type, table, alias, clause);
		return joinQuery();
	}

	public IJoinQuery join(String table, String oneColumn, String anotherColumn){
		String clause = String.format("%s=%s", oneColumn, anotherColumn);
		return join(table, clause);
	}

	public IJoinQuery join(String table, String oneColumn, String anotherColumn, String otherClauses){
		localClause = String.format("%s %s", join(table, oneColumn, anotherColumn), otherClauses);
		return joinQuery();
	}

	private IJoinQuery joinQuery(){
		return new JoinQuery(formattedQuery());
	}
}