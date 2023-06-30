package SelectQueryElements;

import SelectQueryElements.JoinMethods.JoinMethods;

/**
 * Element in the middle of the query, still capable of a lot of method calls
 */
public class JoinQuery extends WhereQuery implements IJoinQuery {

	public JoinQuery(String query) {
		super(query);
	}

	//<editor-fold desc="INNER JOIN">
	public IJoinQuery innerJoin(String table, String clause){
		return innerJoin().join(table, clause);
	}

	public IJoinQuery innerJoinAs(String table, String alias, String clause){
		return innerJoin().joinAs(table, alias, clause);
	}

	public IJoinQuery innerJoin(String table, String oneColumn, String anotherColumn){
		return innerJoin().join(table, oneColumn, anotherColumn);
	}

	public IJoinQuery innerJoin(String table, String oneColumn, String anotherColumn, String otherClauses){
		return innerJoin().join(table, oneColumn, anotherColumn, otherClauses);
	}
	//</editor-fold>

	//<editor-fold desc="LEFT JOIN">
	public IJoinQuery leftJoin(String table, String clause){
		return leftJoin().join(table, clause);
	}

	public IJoinQuery leftJoinAs(String table, String alias, String clause){
		return leftJoin().joinAs(table, alias, clause);
	}

	public IJoinQuery leftJoin(String table, String oneColumn, String anotherColumn){
		return leftJoin().join(table, oneColumn, anotherColumn);
	}

	public IJoinQuery leftJoin(String table, String oneColumn, String anotherColumn, String otherClauses){
		return leftJoin().join(table, oneColumn, anotherColumn, otherClauses);
	}
	//</editor-fold>

	//<editor-fold desc="RIGHT JOIN">
	public IJoinQuery rightJoin(String table, String clause){
		return rightJoin().join(table, clause);
	}

	public IJoinQuery rightJoinAs(String table, String alias, String clause){
		return rightJoin().joinAs(table, alias, clause);
	}

	public IJoinQuery rightJoin(String table, String oneColumn, String anotherColumn){
		return rightJoin().join(table, oneColumn, anotherColumn);
	}

	public IJoinQuery rightJoin(String table, String oneColumn, String anotherColumn, String otherClauses){
		return rightJoin().join(table, oneColumn, anotherColumn, otherClauses);
	}
	//</editor-fold>

	private JoinMethods innerJoin(){
		return new JoinMethods(query(), "INNER");
	}

	private JoinMethods leftJoin(){
		return new JoinMethods(query(), "LEFT");
	}

	private JoinMethods rightJoin(){
		return new JoinMethods(query(), "RIGHT");
	}
}
