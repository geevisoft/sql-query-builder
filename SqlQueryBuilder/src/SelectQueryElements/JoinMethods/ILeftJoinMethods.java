package SelectQueryElements.JoinMethods;

import SelectQueryElements.IJoinQuery;

public interface ILeftJoinMethods {

	/**
	 * Make left join with given table and clause
	 * @param table
	 * @param clause
	 * @return
	 */
	IJoinQuery leftJoin(String table, String clause);

	/**
	 * Make left join with given table (named as given alias) and clause
	 * @param table
	 * @param alias
	 * @param clause
	 * @return
	 */
	IJoinQuery leftJoinAs(String table, String alias, String clause);

	/**
	 * Make left join with given table and default equality clause
	 * @param table
	 * @param oneColumn
	 * @param anotherColumn
	 * @return
	 */
	IJoinQuery leftJoin(String table, String oneColumn, String anotherColumn);

	/**
	 * Make left join with given table, default equality clause and other complementary clause
	 * @param table
	 * @param oneColumn
	 * @param anotherColumn
	 * @param otherClauses
	 * @return
	 */
	IJoinQuery leftJoin(String table, String oneColumn, String anotherColumn, String otherClauses);

}
