package SelectQueryElements;

import SelectQueryElements.QueryMethods.IFromMethods;

public class SelectQuery implements IFromMethods {

	private final String previousQuery;
	private String selectClause;

	public SelectQuery(String selectQuery) {
		this.previousQuery = selectQuery;
	}

	public JoinQuery from(String table){
		selectClause = String.format("FROM %s", table);
		return fromQuery();
	}

	public JoinQuery from(String table, String alias){
		selectClause = String.format("FROM %s %s", table, alias);
		return fromQuery();
	}

	private JoinQuery fromQuery(){
		String formattedQuery = String.format("%s %s", previousQuery, selectClause);
		return new JoinQuery(formattedQuery);
	}

}
