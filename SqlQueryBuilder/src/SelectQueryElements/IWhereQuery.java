package SelectQueryElements;

public interface IWhereQuery extends IGroupQuery {

	/**
	 * Filter query with given where clause
	 * @param clause
	 * @return
	 */
	IGroupQuery where(String clause);

	/**
	 * Filter query with given equality as clause
	 * @param column
	 * @param value
	 * @return
	 */
	IGroupQuery whereEqual(String column, String value);

	/**
	 * Filter query with given equality as clause
	 * @param column
	 * @param value
	 * @return
	 */
	IGroupQuery whereEqual(String column, int value);

	/**
	 * Filter query with given inclusion as clause
	 * @param column
	 * @param values
	 * @return
	 */
	IGroupQuery whereIn(String column, String ...values);

	/**
	 * Filter query with given inclusion as clause
	 * @param column
	 * @param values
	 * @return
	 */
	IGroupQuery whereIn(String column, int ...values);

	/**
	 * Filter query with given inclusion as clause
	 * @param column
	 * @param values
	 * @return
	 */
	IGroupQuery whereIn(String column, double ...values);

}
