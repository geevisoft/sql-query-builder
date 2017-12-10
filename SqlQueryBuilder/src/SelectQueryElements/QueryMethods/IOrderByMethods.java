package SelectQueryElements.QueryMethods;

import QueryElements.FinishableQuery;

public interface IOrderByMethods {

    /**
     * Order query by given column(s)
     * @param firstColumn
     * @param otherColumns
     * @return
     */
    FinishableQuery orderBy(String firstColumn, String... otherColumns);

    /**
     * Order query descending by given column(s)
     * @param firstColumn
     * @param otherColumns
     * @return
     */
    FinishableQuery orderByDescending(String firstColumn, String... otherColumns);

}
