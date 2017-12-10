package DeleteQueryElements;

import QueryElements.FinishableQuery;
import QueryElements.IFinishableQuery;
import QueryElements.Query;

public class DeleteQuery extends Query implements IDeleteQuery {

	public DeleteQuery(String query) {
		this.previousQuery = query;
	}

	public IFinishableQuery where(String clause){
		localClause = String.format("WHERE %s", clause);
		return new FinishableQuery(formattedQuery());
	}

	public IFinishableQuery whereEquals(String column, String value){
		String clause = String.format("%s='%s'", column, value);
		return where(clause);
	}

	public IFinishableQuery whereEquals(String column, int value){
		String clause = String.format("%s=%d", column, value);
		return where(clause);
	}
}
