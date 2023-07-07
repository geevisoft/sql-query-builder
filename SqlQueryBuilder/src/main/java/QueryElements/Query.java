package QueryElements;

public class Query {

	/**
	 * Query built until now
	 */
	protected String previousQuery;

	/**
	 * Clause build in this class
	 */
	protected String localClause;

	/**
	 * Formatted query of joining the query until now and the clause built in this class
	 * @return
	 */
	protected String formattedQuery(){
		return String.format("%s %s", previousQuery, localClause);
	}

	protected String equal(String left, int right){
		return String.format("%s=%d", left, right);
	}

	protected String equal(String left, String right){
		return String.format("%s='%s'", left, right);
	}

}
