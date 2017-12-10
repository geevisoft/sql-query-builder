package SelectQueryElements;

import QueryElements.IFinishableQuery;

public interface IOrderQuery extends IFinishableQuery {

	/**
	 * Order query by given column(s)
	 * @param firstColumn
	 * @param otherColumns
	 * @return
	 */
	IFinishableQuery orderBy(String firstColumn, String... otherColumns);

	/**
	 * Order query descending by given column(s)
	 * @param firstColumn
	 * @param otherColumns
	 * @return
	 */
	IFinishableQuery orderByDescending(String firstColumn, String... otherColumns);

}
