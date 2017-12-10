package SelectQueryElements;

public class SelectQuery implements ISelectQuery {

	private final String previousQuery;
	private String selectClause;

	public SelectQuery(String selectQuery) {
		this.previousQuery = selectQuery;
	}

	public IJoinQuery from(String table){
		selectClause = String.format("FROM %s", table);
		return fromQuery();
	}

	public IJoinQuery from(String table, String alias){
		selectClause = String.format("FROM %s %s", table, alias);
		return fromQuery();
	}

	private IJoinQuery fromQuery(){
		String formattedQuery = String.format("%s %s", previousQuery, selectClause);
		return new JoinQuery(formattedQuery);
	}

}
