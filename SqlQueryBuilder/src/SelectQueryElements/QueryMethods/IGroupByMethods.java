package SelectQueryElements.QueryMethods;

import SelectQueryElements.OrderableQuery;

public interface IGroupByMethods {

    /**
     * Group query by given column(s)
     * @param firstColumn
     * @param otherColumns
     * @return
     */
    OrderableQuery groupBy(String firstColumn, String... otherColumns);

}
