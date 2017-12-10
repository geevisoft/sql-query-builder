public class SqlQueryBuilderHelper {

	protected String between(String element, String left, String right){
		return String.format(" (%s BETWEEN %s AND %s) ", element, left, right);
	}

	protected String sum(String column){
		return String.format(" sum(%s) ", column);
	}

	protected String and(String clause){
		return String.format(" AND %s", clause);
	}

	protected String isNull(String element){
		return String.format(" %s is null ", element);
	}

}
