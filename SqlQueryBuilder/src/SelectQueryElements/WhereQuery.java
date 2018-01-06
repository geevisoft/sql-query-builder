package SelectQueryElements;

import Utils.StringHelper;

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

	public IGroupQuery whereIn(String column, String ...values){
		String inValues = StringHelper.joinAndQuote(", ", values);
		return whereIn(column, inValues);
	}

	public IGroupQuery whereIn(String column, int ...values){
		String inValues = StringHelper.join(", ", values);
		return whereIn(column, inValues);
	}

	public IGroupQuery whereIn(String column, double ...values){
		String inValues = StringHelper.join(", ", values);
		return whereIn(column, inValues);
	}

	private IGroupQuery whereIn(String column, String inValues){
		String clause = String.format("%s IN (%s)", column, inValues);
		return where(clause);
	}

	private IGroupQuery whereQuery(){
		return new GroupQuery(formattedQuery());
	}

}
