package SelectQueryElements.JoinMethods;

import SelectQueryElements.IJoinQuery;

public interface IRightJoinMethods {

	/**
	 * Make right join with given table and clause
	 * @param table
	 * @param clause
	 * @return
	 */
	IJoinQuery rightJoin(String table, String clause);

	/**
	 * Make right join with given table (named as given alias) and clause
	 * @param table
	 * @param alias
	 * @param clause
	 * @return
	 */
	IJoinQuery rightJoinAs(String table, String alias, String clause);

	/**
	 * Make right join with given table and default equality
	 * @param table
	 * @param oneColumn
	 * @param anotherColumn
	 * @return
	 */
	IJoinQuery rightJoin(String table, String oneColumn, String anotherColumn);

	/**
	 * Make right join with given table, default equality and other complementary clause
	 * @param table
	 * @param oneColumn
	 * @param anotherColumn
	 * @param otherClauses
	 * @return
	 */
	IJoinQuery rightJoin(String table, String oneColumn, String anotherColumn, String otherClauses);
}
