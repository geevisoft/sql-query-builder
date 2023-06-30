package SelectQueryElements;

public interface IGroupQuery extends IOrderQuery {

	/**
	 * Group query by given column(s)
	 * @param firstColumn
	 * @param otherColumns
	 * @return
	 */
	IOrderQuery groupBy(String firstColumn, String... otherColumns);

}
