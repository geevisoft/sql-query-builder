package SelectQueryElements;

public interface ISelectQuery {

	/**
	 * Retrieve columns from given table
	 * @param table
	 * @return
	 */
	IJoinQuery from(String table);

	/**
	 * Retrieve columns from given table (named as given alias)
	 * @param table
	 * @param alias
	 * @return
	 */
	IJoinQuery from(String table, String alias);
}
