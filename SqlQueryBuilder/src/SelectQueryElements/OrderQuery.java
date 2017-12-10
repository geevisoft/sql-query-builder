package SelectQueryElements;

import QueryElements.FinishableQuery;
import QueryElements.IFinishableQuery;
import Utils.StringHelper;

import java.util.ArrayList;
import java.util.Arrays;

public class OrderQuery extends FinishableQuery implements IOrderQuery {

	protected OrderQuery(String query) {
		super(query);
	}

	public IFinishableQuery orderBy(String firstColumn, String... otherColumns){
		return orderBy(StringHelper.EMPTY, firstColumn, otherColumns);
	}

	public IFinishableQuery orderByDescending(String firstColumn, String... otherColumns){
		return orderBy("DESC", firstColumn, otherColumns);
	}

	private IFinishableQuery orderBy(String direction, String firstColumn, String... otherColumns){
		String columnQuery = columnQuery(firstColumn, otherColumns);
		if(StringHelper.isNullOrEmpty(direction)){
			localClause = String.format("ORDER BY %s", columnQuery);
		} else {
			localClause = String.format("ORDER BY %s %s", columnQuery, direction);
		}
		return orderByQuery();
	}

	private IFinishableQuery orderByQuery(){
		return new FinishableQuery(formattedQuery());
	}

	protected String columnQuery(String firstColumn, String... otherColumns){
		ArrayList<String> columns = new ArrayList<String>(Arrays.asList(otherColumns));
		columns.add(0, firstColumn);
		return StringHelper.join(", ", columns);
	}
}
