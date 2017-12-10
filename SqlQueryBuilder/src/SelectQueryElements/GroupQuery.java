package SelectQueryElements;

/**
 * Element at almost the end of the query, capable of group and order
 */
public class GroupQuery extends OrderQuery implements IGroupQuery {

	protected GroupQuery(String query) {
		super(query);
	}

	public IOrderQuery groupBy(String firstColumn, String... otherColumns){
		String columnQuery = columnQuery(firstColumn, otherColumns);
		localClause = String.format("GROUP BY %s", columnQuery);
		return groupByQuery();
	}

	private IOrderQuery groupByQuery(){
		return new OrderQuery(formattedQuery());
	}

}
