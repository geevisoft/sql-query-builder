package SelectQueryElements;

/**
 * Capable of where, group and order
 */
public class WhereQuery extends GroupQuery implements IWhereQuery {

	protected WhereQuery(String query) {
		super(query);
	}

	public IGroupQuery where(String clause){
		localClause = String.format("WHERE %s", clause);
		return whereQuery();
	}

	public IGroupQuery whereEqual(String column, String value){
		String clause = equal(column, value);
		return where(clause);
	}

	public IGroupQuery whereEqual(String column, int value){
		String clause = equal(column, value);
		return where(clause);
	}

	private IGroupQuery whereQuery(){
		return new GroupQuery(formattedQuery());
	}

}
