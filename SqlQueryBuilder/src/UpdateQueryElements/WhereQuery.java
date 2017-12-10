package UpdateQueryElements;

import QueryElements.FinishableQuery;
import QueryElements.IFinishableQuery;
import QueryElements.Query;
import Utils.StringHelper;

import java.util.ArrayList;
import java.util.List;

public class WhereQuery extends Query implements IWhereQuery {

	protected final List<String> setValues;

	public WhereQuery(String query) {
		this.previousQuery = query;
		setValues = new ArrayList<String>();
	}

	public IFinishableQuery where(String clause){
		String setValuesQuery = StringHelper.join(", ", setValues);
		localClause = String.format("SET %s WHERE %s", setValuesQuery, clause);
		return whereQuery();
	}

	public IFinishableQuery whereEqual(String column, String value){
		String clause = equal(column, value);
		return where(clause);
	}

	public IFinishableQuery whereEqual(String column, int value){
		String clause = equal(column, value);
		return where(clause);
	}

	private IFinishableQuery whereQuery(){
		return new FinishableQuery(formattedQuery());
	}

}
